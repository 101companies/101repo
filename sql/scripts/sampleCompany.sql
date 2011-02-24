# Employees
INSERT INTO employee (name, address, salary) VALUES ("Craig", "Redmond", 123456);		-- employeeId = 1
INSERT INTO employee (name, address, salary) VALUES ("Erik", "Utrecht", 12345);		  	-- employeeId = 2
INSERT INTO employee (name, address, salary) VALUES ("Ralf", "Koblenz", 1234);		  	-- employeeId = 3
INSERT INTO employee (name, address, salary) VALUES ("Ray", "Redmond", 234567);		  	-- employeeId = 4
INSERT INTO employee (name, address, salary) VALUES ("Klaus", "Boston", 23456);		  	-- employeeId = 5
INSERT INTO employee (name, address, salary) VALUES ("Karl", "Riga", 2345);		  		-- employeeId = 6
INSERT INTO employee (name, address, salary) VALUES ("Joe", "Wifi City", 2344);		  	-- employeeId = 7

# Department "Research"
INSERT INTO dept (managerId, name) VALUES (1, "Research"); 				-- deptId = 1
UPDATE employee SET deptId = 1 WHERE employeeId = 1;
UPDATE employee SET deptId = 1 WHERE employeeId = 2;
UPDATE employee SET deptId = 1 WHERE employeeId = 3;

# Department "Dev1.1"
INSERT INTO dept(managerId, name) VALUES (6,"Dev1.1");					-- deptId = 2
UPDATE employee SET deptId = 2 WHERE employeeId = 6;
UPDATE employee SET deptId = 2 WHERE employeeId = 7;

# Department "Dev1"
INSERT INTO dept(managerId, name) VALUES (5,"Dev1");					-- deptId = 3
UPDATE employee SET deptId = 3 WHERE employeeId = 5;
UPDATE dept SET upperDeptId = 3 WHERE deptId = 2;

# Department "Development"
INSERT INTO dept(managerId, name) VALUES (4,"Development");				-- deptId = 4
UPDATE employee SET deptId = 4 WHERE employeeId = 4;
UPDATE dept SET upperDeptId = 4 WHERE deptId = 3;