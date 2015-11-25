package com.company;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@javax.persistence.Entity
@Table(name="core.Entity")
public class Entity {
    @Id
    @Column(name = "entity_id")
    private String entityId;

    @OneToMany(
            targetEntity = Field.class,
            mappedBy = "entity",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Field> fieldSet; //set

    @Column(name= "name_of_schema")
    private String nameOfSchema;

    @Column(name="need_processing")
    private boolean needProcessing;

    public Entity(){
    }

    public Entity(String entityId, String nameOfSchema) {
        this.entityId = entityId;
        this.nameOfSchema = nameOfSchema;
        fieldSet = new HashSet<>();
    }

    public boolean isNeedProcessing() {
        return needProcessing;
    }

    public void setNeedProcessing(boolean needProcessing) {
        this.needProcessing = needProcessing;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getNameOfSchema() {
        return nameOfSchema;
    }

    public void setNameOfSchema(String nameOfSchema) {
        this.nameOfSchema = nameOfSchema;
    }

    public Iterable<Field> getFields(){
        return Collections.unmodifiableSet(fieldSet);
    }

    public Stream<Field> getFieldsStream(){
        return fieldSet.stream();
    }

    public void addField(Field field){
        fieldSet.add(field);
        setNeedProcessing(true);
    }

    public void addFields(Field... fields){
        Collections.addAll(fieldSet, fields);
        setNeedProcessing(true);
    }
}
