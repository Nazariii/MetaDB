use fresh
GO
IF NOT EXISTS (SELECT 1 FROM sys.schemas WHERE name = 'core')
  BEGIN
    EXEC( 'CREATE SCHEMA core' );
  END
GO
CREATE TABLE [core].[Entity] (
  [entity_id]    NUMERIC(19, 0) IDENTITY NOT NULL,
  entity_name     VARCHAR(255)  NOT NULL,
  [name_of_schema]  VARCHAR(255) NOT NULL,
  [need_processing] BIT          NOT NULL,
  CONSTRAINT PK_ENTITY PRIMARY KEY (entity_id),
  CONSTRAINT UNIQUE_ENTITY_NAME UNIQUE (entity_name)
)
  GO