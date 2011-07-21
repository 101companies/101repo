CREATE TABLE [Department]
( 
	[Name]               nvarchar(18)  NULL ,
	[department_id]      uniqueidentifier  NOT NULL ,
	[company_id]         uniqueidentifier  NULL ,
	[parent_id]          uniqueidentifier  NULL 
)


