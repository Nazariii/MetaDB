package com.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Service
public class Manager {

    @javax.persistence.PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QueryGenerator queryGenerator;

    @Transactional
    public int create(Entity entity){
        entityManager.joinTransaction();
        String tableCreationQuery = queryGenerator.generateQueryFrom(entity);
        System.out.println(tableCreationQuery);
        int updatedCount = entityManager.createNativeQuery(tableCreationQuery).executeUpdate();
        return updatedCount;
    }

    @Transactional
    public void persist(Entity entity){
        entityManager.merge(entity);
    }
}
