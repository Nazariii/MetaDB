use fresh
GO
IF NOT EXISTS (SELECT 1 FROM sys.schemas WHERE name = 'core')
  BEGIN
    EXEC( 'CREATE SCHEMA core' );
  END
GO
CREATE TABLE [core].[Entity] (
  [entity_id]     [varchar](100) NOT NULL,
  [name_of_schema]  [varchar](100) NOT NULL,
  [need_processing] [bit]          NOT NULL,
  CONSTRAINT PK_ENTITY PRIMARY KEY (entity_id)
)
  GO