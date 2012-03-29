insert into COMPANY (NAME) values ('meganalysis'); -- ID = 1

insert into DEPARTMENT (NAME, COMP_ID) values ('Research',1); -- ID = 1
insert into DEPARTMENT (NAME, COMP_ID) values ('Development',1); -- ID = 2

insert into DEPARTMENT (NAME, DEPT_ID) values ('Dev1',2); -- ID = 3
insert into DEPARTMENT (NAME, DEPT_ID) values ('Dev1.1',3); -- ID = 4

insert into EMPLOYEE (NAME, DEPT_ID, ADDRESS, SALARY, MANAGER) values ('Craig', 1, 'Redmond', 123456, true);
insert into EMPLOYEE (NAME, DEPT_ID, ADDRESS, SALARY, MANAGER) values ('Erik', 1, 'Utrecht', 12345, false);
insert into EMPLOYEE (NAME, DEPT_ID, ADDRESS, SALARY, MANAGER) values ('Ralf', 1, 'Koblenz', 1234, false);
insert into EMPLOYEE (NAME, DEPT_ID, ADDRESS, SALARY, MANAGER) values ('Ray', 2, 'Redmond', 234567,true);
insert into EMPLOYEE (NAME, DEPT_ID, ADDRESS, SALARY, MANAGER) values ('Klaus', 3, 'Boston', 23456, true);
insert into EMPLOYEE (NAME, DEPT_ID, ADDRESS, SALARY, MANAGER) values ('Karl', 4, 'Riga', 2345, true);
insert into EMPLOYEE (NAME, DEPT_ID, ADDRESS, SALARY, MANAGER) values ('Joe', 4, 'Wifi City', 2344, false);

update EMPLOYEE 
 set MENTOR = 2
 where ID = 3;
