CREATE TABLE [Employee]
( 
	[Salary]             decimal(10,1)  NULL ,
	[employee_id]        uniqueidentifier  NOT NULL ,
	[person_id]          uniqueidentifier  NOT NULL ,
	[department_id]      uniqueidentifier  NOT NULL ,
	[IsManager]          bit  NULL 
)


