module Company where

type Company = Name -- Name of company
type Department = (
	  Name, 	-- Name of department
	  Maybe Name,	-- Name of ancestor department
	  Name		-- Name of associated company
	)
type Employee = (
	  Name,		-- Name of employee
	  Name,		-- Name of associated department
	  Name,		-- Name of associated company
	  Address,	-- Address of employee
	  Salary,	-- Salary of employee
	  Bool		-- Manager?
	)
type Name = String
type Address = String
type Salary = Float
