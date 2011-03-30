ALTER TABLE [dbo].[Department]
	ADD CONSTRAINT [FK_Department_Departmnent] 
	FOREIGN KEY (parent_id)
	REFERENCES Department (department_id)	

