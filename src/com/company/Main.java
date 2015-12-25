package com.company;

import org.apache.commons.cli.*;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Manager manager = applicationContext.getBean(Manager.class);

        Options options = new Options();
        Option entityType = Option.builder()
                .argName("type")
                .longOpt("entity")
                .hasArg(true)
                .desc("Type of entity for which stored procedure will be run.")
                .build();

        options.addOption(entityType);
        logger.info("Arguments to the main function:" + Arrays.toString(args));
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine commandLine = parser.parse(options, args);
            String entityTypeOptionValue = commandLine.getOptionValue("entity");
            if (entityTypeOptionValue == null) {
                showUsage(options);
            } else {
                switch (entityTypeOptionValue) {
                    case "Album": {
                        createAlbum(manager);
                        System.out.println("Created an album entity");
                        break;
                    }
                    case "Customer": {
                        createCustomer(manager);
                        System.out.println("Created a customer entity");
                        break;
                    }
                    default: {
                        showUsage(options);
                    }
                }
            }

        } catch (ParseException e) {
            logger.error(e);
        }
    }

    public static void showUsage(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("salesforce_meta", options, true);
    }

    public static void createAlbum(Manager manager) {
        Entity albumEntity = new Entity("Album", "core");
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
        manager.create(albumEntity);
    }

    public static void createCustomer(Manager manager) {
        Entity albumEntity = new Entity("Customer", "core");
        albumEntity.addField(
                new Field.Builder("id", SqlTypes.INT)
                        .primaryKey(true)
                        .nullable(false)
                        .build()
        );
        albumEntity.addField(
                new Field.Builder("name", SqlTypes.VARCHAR)
                        .length(255)
                        .build()
        );
        albumEntity.addField(
                new Field.Builder("surname", SqlTypes.VARCHAR)
                        .length(255)
                        .build()
        );
        manager.create(albumEntity);
    }
}
