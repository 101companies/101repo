BEGIN TRANSACTION;
INSERT INTO Department(name) VALUES("Research");
INSERT INTO Department(name) VALUES("Development" );
INSERT INTO Department(name, superdepartment) VALUES("Dev1" ,(SELECT ID FROM Department WHERE name == "Development"));
INSERT INTO Department(name, superdepartment) VALUES("Dev1.1" ,(SELECT ID FROM Department  WHERE name == "Dev1"));

INSERT INTO Employee(name, address, salary, department, isManager) VALUES("Craig","Redmond","123456",(SELECT ID FROM Department  WHERE name == "Research"), "TRUE");
INSERT INTO Employee(name, address, salary, department) VALUES("Erik","Utrecht","12345",(SELECT ID FROM Department   WHERE name == "Research"));
INSERT INTO Employee(name, address, salary, department) VALUES("Ralf","Koblenz","1234",(SELECT ID FROM Department  WHERE name == "Research"));
INSERT INTO Employee(name, address, salary, department, isManager) VALUES("Ray","Redmond","234567",(SELECT ID FROM Department   WHERE name == "Development"), "TRUE");
INSERT INTO Employee(name, address, salary, department, isManager) VALUES("Klaus","Boston","23456",(SELECT ID FROM Department   WHERE name == "Dev1"), "TRUE");
INSERT INTO Employee(name, address, salary, department, isManager) VALUES("Karl","Riga","2345",(SELECT ID FROM Department   WHERE name == "Dev1.1"), "TRUE");
INSERT INTO Employee(name, address, salary, department) VALUES("Joe","Wifi City","2344",(SELECT ID FROM Department  WHERE name == "Dev1.1"));
END TRANSACTION;