use fresh
GO
IF NOT EXISTS (SELECT 1 FROM sys.schemas WHERE name = 'core')
  BEGIN
    EXEC( 'CREATE SCHEMA core' );
  END
GO
CREATE TABLE core.Field(
  Field_id INT UNIQUE NOT NULL,
  entity_id VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL,
  type VARCHAR(50) NOT NULL,
  is_primary_key BIT NOT NULL,
  is_nullable BIT NOT NULL,
  need_processing BIT NOT NULL,
  length INT,
  CONSTRAINT PK_FIELD PRIMARY KEY (Field_Id),
  CONSTRAINT FK_ENTITY FOREIGN KEY (entity_id) references core.Entity(entity_id)
)
GO