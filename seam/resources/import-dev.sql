-- SQL statements which are executed at application startup if hibernate.hbm2ddl.auto is 'create' or 'create-drop'

INSERT INTO COMPANY(NAME) VALUES ('Meganalysis');

INSERT INTO SUBUNIT(ID, NAME) VALUES(1, 'Research');

-- Unities representing sub-departments or employees must inform 
-- the id of the parent department

INSERT INTO DEPARTMENT(ID) VALUES(1);
  
INSERT INTO SUBUNIT(ID, NAME, DEPARTMENT_ID) VALUES(2, 'Craig', 1);

INSERT INTO EMPLOYEE(ID, ADDRESS, SALARY) VALUES(2, 'Redmond', 123456);

--
-- set the department Id. necessary to insert a department 
-- without a manager because there exists a cyclical dependency.
--  
UPDATE DEPARTMENT SET MANAGER_ID=2 WHERE ID = 1 
 
