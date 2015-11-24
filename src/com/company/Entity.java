package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Entity {
    private String tableName;
    private List<Field> fieldList;
    private String schemaName;
    private boolean needProcessing;

    public Entity(String tableName, String schemaName) {
        this.tableName = tableName;
        this.schemaName = schemaName;
        fieldList = new ArrayList<>();
    }

    public boolean isNeedProcessing() {
        return needProcessing;
    }

    public void setNeedProcessing(boolean needProcessing) {
        this.needProcessing = needProcessing;
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
        setNeedProcessing(true);
    }

    public void addFields(Field... fields){
        Collections.addAll(fieldList, fields);
        setNeedProcessing(true);
    }
}
