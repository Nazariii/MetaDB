package com.company;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@javax.persistence.Entity
@Table(name = "core.Entity")
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id")
    private Long entityId;

    @Column(name = "entity_name")
    private String entityName;

    @OneToMany(
            targetEntity = Field.class,
            mappedBy = "entity",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Field> fieldSet;

    @Column(name = "name_of_schema")
    private String nameOfSchema;

    @Column(name = "need_processing")
    private boolean needProcessing;

    public Entity() {
    }

    public Entity(String entityName, String nameOfSchema) {
        this.entityName = entityName;
        this.nameOfSchema = nameOfSchema;
        fieldSet = new HashSet<>();
    }

    public Long getEntityId() {
        return entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public boolean isNeedProcessing() {
        return needProcessing;
    }

    public void setNeedProcessing(boolean needProcessing) {
        this.needProcessing = needProcessing;
    }

    public String getNameOfSchema() {
        return nameOfSchema;
    }

    public void setNameOfSchema(String nameOfSchema) {
        this.nameOfSchema = nameOfSchema;
    }

    public Iterable<Field> getFields() {
        return Collections.unmodifiableSet(fieldSet);
    }

    public Stream<Field> getFieldsStream() {
        return fieldSet.stream();
    }

    public void addField(Field field) {
        fieldSet.add(field);
        field.setEntity(this);
        setNeedProcessing(true);
    }

    public void addFields(Field... fields) {
        Collections.addAll(fieldSet, fields);
        Stream.of(fields).forEach(field -> field.setEntity(this));
        setNeedProcessing(true);
    }
}
