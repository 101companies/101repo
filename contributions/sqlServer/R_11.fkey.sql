ALTER TABLE [Department]
	ADD CONSTRAINT [R_11] FOREIGN KEY ([company_id]) REFERENCES [Company]([company_id])
		ON DELETE NO ACTION
		ON UPDATE NO ACTION


