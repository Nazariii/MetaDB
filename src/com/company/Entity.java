package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Entity {
    private String tableName;
    private List<Field> fieldList;
    private String schemaName;

    public Entity(String tableName, String schemaName) {
        this.tableName = tableName;
        this.schemaName = schemaName;
        fieldList = new ArrayList<>();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public Iterable<Field> getFields(){
        return Collections.unmodifiableList(fieldList);
    }

    public Stream<Field> getFieldsStream(){
        return fieldList.stream();
    }

    public void addField(Field field){
        fieldList.add(field);
    }

    public void addFields(Field... fields){
        Collections.addAll(fieldList, fields);
    }
}
