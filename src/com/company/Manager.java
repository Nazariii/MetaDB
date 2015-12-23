package com.company;


import org.apache.commons.lang3.tuple.Pair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.sql.DataSource;
import java.util.Map;


@Service
public class Manager {
    private final static Logger logger = Logger.getLogger(Manager.class);

    @javax.persistence.PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QueryGenerator queryGenerator;

    @Autowired
    private DataSource dataSource;

    @Transactional
    public void create(Entity entity){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        Pair<String, String> tableCreationQueryMap = queryGenerator.generateStoredProcedureFrom(entity);
        String sqlQuery = tableCreationQueryMap.getValue();
        logger.info(sqlQuery);

        jdbcTemplate.update(sqlQuery);

        //executes stored procedure call
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName(entity.getEntityName())
                .withProcedureName(tableCreationQueryMap.getKey());
        jdbcCall.execute();
    }

    @Transactional
    public void persist(Entity entity){
        entityManager.merge(entity);
    }
}
