UPDATE employee
 SET salary = salary / 2
 WHERE cid =
  (SELECT id FROM company
   WHERE name = "meganalysis");

