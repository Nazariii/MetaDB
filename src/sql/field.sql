IF NOT EXISTS (SELECT 1 FROM sys.schemas WHERE name = 'administration_metadata')
  BEGIN
    EXEC( 'CREATE SCHEMA administration_metadata' );
  END

CREATE TABLE [administration_metadata].Field(
  id INT UNIQUE NOT NULL,
  entity_name VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL,
  type VARCHAR(50) NOT NULL,
  is_primary_key BIT NOT NULL,
  is_nullable BIT NOT NULL,
  need_processing BIT NOT NULL,
  length INT,
  CONSTRAINT FK_entity FOREIGN KEY (entity_name) references [administration_metadata].Entity(entity_name)
)