/*
Post-Deployment Script Template							
--------------------------------------------------------------------------------------
 This file contains SQL statements that will be appended to the build script.		
 Use SQLCMD syntax to include a file in the post-deployment script.			
 Example:      :r .\myfile.sql								
 Use SQLCMD syntax to reference a variable in the post-deployment script.		
 Example:      :setvar TableName MyTable							
			   SELECT * FROM [$(TableName)]					
--------------------------------------------------------------------------------------
*/

/* FILL DATA */

INSERT INTO Company (Name, company_id) VALUES ('meganalysis','522365C7-5761-4095-8FDB-2D063CBAF3D0')
INSERT INTO Department (Name, department_id, company_id, parent_id) VALUES  ('Research','D3091B82-1D24-4AE6-BF06-F6C8055513D9','522365C7-5761-4095-8FDB-2D063CBAF3D0',null)
INSERT INTO Department (Name, department_id, company_id, parent_id) VALUES  ('Development','B1171577-87E1-449F-A74D-CCD8BBC6FD74','522365C7-5761-4095-8FDB-2D063CBAF3D0',null)
INSERT INTO Department (Name, department_id, company_id, parent_id) VALUES  ('Dev1','4213EB39-01DF-4B8D-9E97-2370E276C51E','522365C7-5761-4095-8FDB-2D063CBAF3D0','B1171577-87E1-449F-A74D-CCD8BBC6FD74')
INSERT INTO Department (Name, department_id, company_id, parent_id) VALUES  ('Dev 1.1','1F547241-163E-4E14-872C-6F9E65930E9A','522365C7-5761-4095-8FDB-2D063CBAF3D0','4213EB39-01DF-4B8D-9E97-2370E276C51E')

INSERT INTO Person (Name, Address, person_id) VALUES ('Ralf', 'Koblenz', '694BD10A-D2ED-44F5-9D93-6F4DEEBF8001')
INSERT INTO Employee (Salary, employee_id, person_id, department_id, IsManager)
VALUES (1234,'869A8EE0-8868-4FBC-BAB6-F01441B5CBF5','694BD10A-D2ED-44F5-9D93-6F4DEEBF8001','D3091B82-1D24-4AE6-BF06-F6C8055513D9', 0)

INSERT INTO Person (Name, Address, person_id) VALUES ('Erik', 'Utrecht', '49CC2D19-0244-42CE-819A-C2C65B59A16D')
INSERT INTO Employee (Salary, employee_id, person_id, department_id, IsManager)
VALUES (12345,'694BD10A-D2ED-44F5-9D93-6F4DEEBF8001','49CC2D19-0244-42CE-819A-C2C65B59A16D','D3091B82-1D24-4AE6-BF06-F6C8055513D9', 0)

INSERT INTO Person (Name, Address, person_id) VALUES ('Craig', 'Redmond', '3E672ED1-F130-415B-A7FB-6A7D503DAAF2')
INSERT INTO Employee (Salary, employee_id, person_id, department_id, IsManager)
VALUES (123456,'69576BFC-463F-4785-A028-14DC652D6FB9','3E672ED1-F130-415B-A7FB-6A7D503DAAF2','D3091B82-1D24-4AE6-BF06-F6C8055513D9', 1)

INSERT INTO Person (Name, Address, person_id) VALUES ('Ray', 'Redmond', 'EA5FC970-A3E0-45A4-AB90-8027864EFB79')
INSERT INTO Employee (Salary, employee_id, person_id, department_id, IsManager)
VALUES (234567,'504E951C-BEC8-4282-B232-386BD53BAAB6','EA5FC970-A3E0-45A4-AB90-8027864EFB79','B1171577-87E1-449F-A74D-CCD8BBC6FD74', 1)

INSERT INTO Person (Name, Address, person_id) VALUES ('Klaus', 'Boston', '0AB6E49F-71D5-4432-A486-DE950400EFC3')
INSERT INTO Employee (Salary, employee_id, person_id, department_id, IsManager)
VALUES (23456,'A6F4A2ED-83A5-4542-92B1-BF303744A0FA','0AB6E49F-71D5-4432-A486-DE950400EFC3','4213EB39-01DF-4B8D-9E97-2370E276C51E', 1)

INSERT INTO Person (Name, Address, person_id) VALUES ('Karl', 'Riga', 'E8DD7619-3FBA-4C9D-B654-1FD5AC8B5D44')
INSERT INTO Employee (Salary, employee_id, person_id, department_id, IsManager)
VALUES (2345,'38EA7975-B1E7-4397-AD62-B30D0FA31B1B','E8DD7619-3FBA-4C9D-B654-1FD5AC8B5D44','1F547241-163E-4E14-872C-6F9E65930E9A', 1)

INSERT INTO Person (Name, Address, person_id) VALUES ('Joe', 'Wifi City', '714FBE9E-3237-45F8-9F0A-0CE5CBB88D93')
INSERT INTO Employee (Salary, employee_id, person_id, department_id, IsManager)
VALUES (2344,'035EAC2A-BA99-4CA2-908F-2F03D2781E3F','714FBE9E-3237-45F8-9F0A-0CE5CBB88D93','1F547241-163E-4E14-872C-6F9E65930E9A', 0)