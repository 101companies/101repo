ALTER TABLE [Employee]
	ADD CONSTRAINT [R_15] FOREIGN KEY ([department_id]) REFERENCES [Department]([department_id])
		ON DELETE NO ACTION
		ON UPDATE NO ACTION


