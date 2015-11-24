package com.company;

public class Field {
    private String name;
    private SqlTypes type;
    private Long length;
    private boolean isPrimaryKey;
    private boolean isNullable;
    private boolean needProcessing;

    public Field(String name, SqlTypes type, Long length, boolean isPrimaryKey, boolean isNullable) {
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

    public boolean isNeedProcessing() {
        return needProcessing;
    }

    public void setNeedProcessing(boolean needProcessing) {
        this.needProcessing = needProcessing;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
        setNeedProcessing(true);
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
        private Long length;

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

        public Builder length(long value) {
            this.length = value;
            return this;
        }

        public Field build() {
            return new Field(name, type, length, isPrimaryKey, isNullable);
        }


    }
}
