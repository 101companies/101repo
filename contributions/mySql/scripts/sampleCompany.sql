# Companies

INSERT INTO company (name) VALUES ("meganalysis"); -- compId = 1

# Departments

INSERT INTO department (name,cid) VALUES ("Research",1); -- deptId = 1
INSERT INTO department (name,cid) VALUES ("Development",1); -- deptId = 2
INSERT INTO department (name,cid,did) VALUES ("Dev1",1,2); -- deptId = 3
INSERT INTO department (name,cid,did) VALUES ("Dev1.1",1,3); -- deptId = 4

# Employees

INSERT INTO employee (name, address, salary, manager, cid, did)
SELECT "Craig", "Redmond", 123456, true, 1, 1
UNION ALL
SELECT "Ray", "Redmond", 234567, true, 1, 2
UNION ALL
SELECT "Klaus", "Boston", 23456, true, 1, 3
UNION ALL
SELECT "Karl", "Riga", 2345, true, 1, 4
UNION ALL
SELECT "Erik", "Utrecht", 12345, false, 1, 1
UNION ALL
SELECT "Ralf", "Koblenz", 1234, false, 1, 1
UNION ALL
SELECT "Joe", "Wifi City", 2344, false, 1, 4;
