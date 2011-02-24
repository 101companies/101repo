DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS dept;

# Departments

CREATE TABLE IF NOT EXISTS dept (
	deptId INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100),
    managerId INTEGER,                                     									    -- department manager
	FOREIGN KEY (managerId) REFERENCES employee(employeeID),
	upperDeptId INTEGER,																		-- owning department
	FOREIGN KEY (upperDeptId) REFERENCES dept(deptId) ON DELETE CASCADE ON UPDATE CASCADE
);

# Employees

CREATE TABLE IF NOT EXISTS employee (
	employeeId INTEGER AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	address VARCHAR(50) NOT NULL,
	salary DOUBLE,
	deptId INTEGER,																				-- owning department
    FOREIGN KEY (deptId) REFERENCES dept(deptId) ON DELETE CASCADE ON UPDATE CASCADE
);
