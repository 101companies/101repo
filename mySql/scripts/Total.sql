SELECT SUM(salary) FROM employee
 WHERE cid = 
  (SELECT id FROM company
   WHERE name = "meganalysis");
