use fresh;

EXEC( 'CREATE SCHEMA core' );

CREATE TABLE [core].[Entity] (
  [entity_id]    NUMERIC(19, 0) IDENTITY NOT NULL,
  entity_name     VARCHAR(255)  NOT NULL,
  [name_of_schema]  VARCHAR(255) NOT NULL,
  [need_processing] BIT          NOT NULL,
  CONSTRAINT PK_ENTITY PRIMARY KEY (entity_id),
  CONSTRAINT UNIQUE_ENTITY_NAME UNIQUE (entity_name)
);
