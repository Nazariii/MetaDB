package com.company;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class QueryGenerator {
    private final static Logger logger = Logger.getLogger(QueryGenerator.class);

    @Value("${template.directory}")
    private String templateDirectory;

    @Value("${output.encoding}")
    private String outputEncoding;

    public Pair<String, String> generateStoredProcedureFrom(Entity entity){
        Properties props = new Properties();
        props.put("file.resource.loader.path", templateDirectory);
        Velocity.init(props);
        Context context = new VelocityContext();
        StringWriter stringWriter = new StringWriter();

        context.put("EntityName", entity.getEntityName());
        context.put("SchemaName", entity.getNameOfSchema());
        context.put("Fields", entity.getFields());

        Velocity.mergeTemplate("create.vm", outputEncoding, context, stringWriter);

        Pair<String, String> resultPair = new ImmutablePair<>("create" + entity.getEntityName(), stringWriter.toString());
        return resultPair;
    }

}
