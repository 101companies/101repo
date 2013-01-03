#
# Acme Corporation
#

# Departments

INSERT INTO department (name) VALUES ("Research"); -- deptId = 1
INSERT INTO department (name) VALUES ("Development"); -- deptId = 2
INSERT INTO department (name,did) VALUES ("Dev1",2); -- deptId = 3
INSERT INTO department (name,did) VALUES ("Dev1.1",3); -- deptId = 4

# Employees

INSERT INTO employee (name, address, salary, manager, did)
SELECT "Craig", "Redmond", 123456, true, 1
UNION ALL
SELECT "Ray", "Redmond", 234567, true, 2
UNION ALL
SELECT "Klaus", "Boston", 23456, true, 3
UNION ALL
SELECT "Karl", "Riga", 2345, true, 4
UNION ALL
SELECT "Erik", "Utrecht", 12345, false, 1
UNION ALL
SELECT "Ralf", "Koblenz", 1234, false, 1
UNION ALL
SELECT "Joe", "Wifi City", 2344, false, 4;
