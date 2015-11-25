package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Manager manager = applicationContext.getBean(Manager.class);
        Entity entity = new Entity("Albums", "test");

        entity.addField(new Field.Builder("Id", SqlTypes.INT).nullable(false).primaryKey(true).build());
        entity.addField(new Field.Builder("Title", SqlTypes.VARCHAR).nullable(false).primaryKey(false).length(120).build());
        entity.addField(new Field.Builder("Year", SqlTypes.INT).nullable(true).primaryKey(false).build());
        //manager.create(entity);
        manager.persist(entity);
    }
}
