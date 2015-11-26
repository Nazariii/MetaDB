package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Manager manager = applicationContext.getBean(Manager.class);
        Entity entity = new Entity("Albums2", "test");
        entity.addField(
                new Field.Builder("name", SqlTypes.VARCHAR)
                .length(255)
                .primaryKey(true)
                .build()
        );

        entity.addField(
                new Field.Builder("year", SqlTypes.INT)
                        .nullable(true)
                        .build()
        );
        manager.persist(entity);
    }
}
