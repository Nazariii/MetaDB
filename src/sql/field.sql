use fresh;

EXEC( 'CREATE SCHEMA core' );

CREATE TABLE core.Field(
  Field_id NUMERIC(19, 0) IDENTITY NOT NULL,
  entity_id NUMERIC(19, 0) NOT NULL,
  field_name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  is_primary_key BIT NOT NULL,
  is_nullable BIT NOT NULL,
  need_processing BIT NOT NULL,
  length INT,
  CONSTRAINT PK_FIELD PRIMARY KEY (Field_Id),
  CONSTRAINT FK_ENTITY FOREIGN KEY (entity_id) references core.Entity(entity_id)
);
