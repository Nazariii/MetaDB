package com.company;

public class Field {
    private String name;
    private String type;
    private boolean isPrimaryKey;
    private boolean isNullable;

    public Field(String name, String type, boolean isPrimaryKey, boolean isNullable) {
        this.name = name;
        this.type = type;
        this.isPrimaryKey = isPrimaryKey;
        this.isNullable = isNullable;
    }


    static class Builder {
        private String name;
        private String type;
        private boolean isPrimaryKey;
        private boolean isNullable;


        public Builder(String name, String type){
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

        public Field build(){
            return new Field(name,type,isPrimaryKey, isNullable);
        }


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
}
