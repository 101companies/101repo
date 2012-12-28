module SampleCompany where

import Company

sample :: ([Company], [Department], [Employee])
sample = (companies, departments, employees)

companies :: [Company]
companies = ["meganalysis"]

departments :: [Department]
departments = [
	  ("Research", Nothing, "meganalysis"),
	  ("Development", Nothing, "meganalysis"),
	  ("Dev1", Just "Development", "meganalysis"),
	  ("Dev1.1", Just "Dev1", "meganalysis")
	]
	
employees :: [Employee]
employees = [
	  ("Craig", "Research", "meganalysis", "Redmond", 123456, True),
	  ("Erik", "Research", "meganalysis", "Utrecht", 12345, False),
	  ("Ralf", "Research", "meganalysis", "Koblenz", 1234, False),
	  ("Ray", "Development", "meganalysis", "Redmond", 234567, True),
	  ("Klaus", "Dev1", "meganalysis", "Boston", 23456, True),
	  ("Karl", "Dev1.1", "meganalysis", "Riga", 2345, True),
	  ("Joe", "Dev1.1", "meganalysis", "Wifi City", 2344, False)
	]
