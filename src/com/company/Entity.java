package com.company;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@javax.persistence.Entity
@Table(name="Entity", schema="administration_metadata")
public class Entity {
    @Id
    @Column(name = "entity_name")
    private String entityName;

    @OneToMany(mappedBy="entityName")
    private List<Field> fieldList;

    @Column(name= "name_of_schema")
    private String nameOfSchema;

    @Column(name="need_processing")
    private boolean needProcessing;

    public Entity(String entityName, String nameOfSchema) {
        this.entityName = entityName;
        this.nameOfSchema = nameOfSchema;
        fieldList = new ArrayList<>();
    }

    public boolean isNeedProcessing() {
        return needProcessing;
    }

    public void setNeedProcessing(boolean needProcessing) {
        this.needProcessing = needProcessing;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getNameOfSchema() {
        return nameOfSchema;
    }

    public void setNameOfSchema(String nameOfSchema) {
        this.nameOfSchema = nameOfSchema;
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
