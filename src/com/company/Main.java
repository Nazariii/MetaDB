package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Manager manager = applicationContext.getBean(Manager.class);
        Entity entity = new Entity("Albums", "test");
        entity.addField(Field.of("Title", "VARCHAR(MAX)", false, true));
        entity.addField(Field.of("YEAR", "INT", false, false));
        manager.create(entity);
    }
}
