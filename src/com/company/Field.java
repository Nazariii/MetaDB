package com.company;

public class Field {
    private String name;
    private String type;
    private Long length;
    private boolean isPrimaryKey;
    private boolean isNullable;

    public Field(String name, String type, Long length, boolean isPrimaryKey, boolean isNullable) {
        this.name = name;
        this.type = type;
        this.isPrimaryKey = isPrimaryKey;
        this.isNullable = isNullable;
        this.length = length;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }

    public boolean isNullable() {
        return isNullable;
    }

    public void setNullable(boolean nullable) {
        isNullable = nullable;
    }

    static class Builder {
        private String name;
        private String type;
        private boolean isPrimaryKey;
        private boolean isNullable;
        private Long length;

        public Builder(String name, SqlTypes type) {
            this.name = name;
            this.type = type.toString();
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
