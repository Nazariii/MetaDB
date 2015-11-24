package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Manager manager = applicationContext.getBean(Manager.class);
        Entity entity = new Entity("Albums", "test");

        entity.addField(new Field.Builder("Id", "INT").nullable(false).primaryKey(true).build());
        entity.addField(new Field.Builder("Title", "VARCHAR(MAX)").nullable(false).primaryKey(false).build());
        entity.addField(new Field.Builder("Year", "INT").nullable(true).primaryKey(false).build());

        //TODO: add some processing of types
        manager.create(entity);
    }
}
