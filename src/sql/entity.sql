IF NOT EXISTS (SELECT 1 FROM sys.schemas WHERE name = 'administration_metadata')
  BEGIN
    EXEC( 'CREATE SCHEMA administration_metadata' );
  END

CREATE TABLE [administration_metadata].[Entity] (
  [entity_name]     [varchar](100) NOT NULL PRIMARY KEY,
  [name_of_schema]  [varchar](100) NOT NULL,
  [need_processing] [bit]          NOT NULL
)