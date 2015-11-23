package com.company;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.StringWriter;

@Service
public class QueryGenerator {

    @Value("${template.directory}")
    private String templateDirectory;

    @Value("${output.encoding}")
    private String outputEncoding;

    public String generateQueryFrom(Entity entity){

        Context context = new VelocityContext();
        StringWriter stringWriter = new StringWriter();
        context.put("EntityName", entity.getTableName());
        context.put("SchemaName", entity.getSchemaName());
        context.put("Fields", entity.getFields());
        Velocity.mergeTemplate(templateDirectory + "create.vm", outputEncoding, context, stringWriter);
        return StringUtils.removeEnd(stringWriter.toString(), ",\r\n)").concat("\r\n)");
    }
}
