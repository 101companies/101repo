INSERT INTO company (name) VALUES ("meganalysis"); -- compId = 1


INSERT INTO department (name,cid) VALUES ("Research",1); -- deptId = 1
INSERT INTO department (name,cid) VALUES ("Development",1); -- deptId = 2
INSERT INTO department (name,cid,did) VALUES ("Dev1",1,2); -- deptId = 3
INSERT INTO department (name,cid,did) VALUES ("Dev1.1",1,3); -- deptId = 4


INSERT INTO employee (name, address, salary, isManager, cid, did)
SELECT "Craig", "Redmond", 123456, 1, 1, 1
UNION ALL
SELECT "Ray", "Redmond", 234567, 1, 1, 2
UNION ALL
SELECT "Klaus", "Boston", 23456, 1, 1, 3
UNION ALL
SELECT "Karl", "Riga", 2345, 1, 1, 4
UNION ALL
SELECT "Erik", "Utrecht", 12345, 0, 1, 1
UNION ALL
SELECT "Ralf", "Koblenz", 1234, 0, 1, 1
UNION ALL
SELECT "Joe", "Wifi City", 2344, 0, 1, 4;
