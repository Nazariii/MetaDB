package com.company;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Manager manager = applicationContext.getBean(Manager.class);
        logger.info("well---------------");
        Entity albumEntity = new Entity("Albums", "core");
        albumEntity.addField(
                new Field.Builder("name", SqlTypes.VARCHAR)
                .length(255)
                .primaryKey(true)
                .build()
        );

        albumEntity.addField(
                new Field.Builder("year", SqlTypes.INT)
                        .nullable(true)
                        .build()
        );
        //manager.persist(albumEntity);
        manager.create(albumEntity);
    }
}
