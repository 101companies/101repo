BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS Department( --Table for Departments
	ID INTEGER PRIMARY KEY AUTOINCREMENT, 
	name TEXT NOT NULL, 
	superdepartment INTEGER, --Subdepartments reference their superdepartment
	FOREIGN KEY(superdepartment) REFERENCES Department(ID) 
);
CREATE TABLE IF NOT EXISTS Employee( --Table for Employees
	ID INTEGER PRIMARY KEY AUTOINCREMENT,
	department INTEGER NOT NULL, --reference department
	name TEXT NOT NULL,
	address TEXT,
	salary REAL NOT NULL DEFAULT 0 CHECK (salary >= 0), -- salaries are greater equal zero nowadays
	isManager BOOLEAN NOT NULL DEFAULT "FALSE",
	FOREIGN KEY(department) REFERENCES Department(ID) ON DELETE SET NULL
);
-- CREATE TRIGGER IF NOT EXISTS noManager AFTER DELETE ON Department BEGIN UPDATE Employee SET isManager = NULL WHERE department == NULL; END; --Removes Manager Attribute if Department is erased
CREATE TRIGGER IF NOT EXISTS deleteEmployee AFTER DELETE ON Department BEGIN DELETE FROM Employee WHERE department == NULL; END; --Removes Employees if Departement is deleted
END TRANSACTION;
PRAGMA foreign_keys = "TRUE"; --enable foreign keys
PRAGMA recursive_triggers = "TRUE"; --enable recursive triggers