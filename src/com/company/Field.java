package com.company;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name="core.Field")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    private Long id;

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @ManyToOne(targetEntity = Entity.class)
    @JoinColumn(name = "entity_id", insertable = true, updatable = false)
    private Entity entity;


    private String name;

    @Enumerated(EnumType.STRING)
    private SqlTypes type;

    @Column(name="length")
    private Integer length;

    @Column(name = "is_primary_key")
    private boolean isPrimaryKey;

    @Column(name = "is_nullable")
    private boolean isNullable;

    @Column(name = "need_processing")
    private boolean needProcessing;

    public Field(){
    }

    public Field(String name, SqlTypes type, Integer length, boolean isPrimaryKey, boolean isNullable) {
        this.name = name;
        this.type = type;
        this.isPrimaryKey = isPrimaryKey;
        this.isNullable = isNullable;
        this.length = length;
        this.needProcessing = true;
        if(!type.equals(SqlTypes.VARCHAR)){
            this.length = null; //nobody else can have length
        }
    }



    public Long getId() {
        return id;
    }

    public boolean isNeedProcessing() {
        return needProcessing;
    }

    public void setNeedProcessing(boolean needProcessing) {
        this.needProcessing = needProcessing;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setNeedProcessing(true);
    }

    public SqlTypes getType() {
        return type;
    }

    public void setType(SqlTypes type) {
        this.type = type;
        setNeedProcessing(true);
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.isPrimaryKey = primaryKey;
        setNeedProcessing(true);
    }

    public boolean isNullable() {
        return isNullable;
    }

    public void setNullable(boolean nullable) {
        this.isNullable = nullable;
        setNeedProcessing(true);

    }

    static class Builder {
        private String name;
        private SqlTypes type;
        private boolean isPrimaryKey;
        private boolean isNullable;
        private Integer length;

        public Builder(String name, SqlTypes type) {
            this.name = name;
            this.type = type;
        }

        public Builder primaryKey(boolean value) {
            this.isPrimaryKey = value;
            return this;
        }

        public Builder nullable(boolean value) {
            this.isNullable = value;
            return this;
        }

        public Builder length(Integer value) {
            this.length = value;
            return this;
        }

        public Field build() {
            return new Field(name, type, length, isPrimaryKey, isNullable);
        }


    }
}
