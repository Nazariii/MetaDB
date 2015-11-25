package com.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Service
public class Manager {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private QueryGenerator queryGenerator;

    @Transactional
    public int create(Entity entity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.joinTransaction();
        String tableCreationQuery = queryGenerator.generateQueryFrom(entity);
        System.out.println(tableCreationQuery);
        int updatedCount = entityManager.createNativeQuery(tableCreationQuery).executeUpdate();
        return updatedCount;
    }

    @Transactional
    public void persist(Entity entity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(entity);
    }
}
