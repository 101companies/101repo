#
# The vacious WHERE clause below is needed for "safe mode" of MySQL Workbench.
# Instead, safe mode could also be turned off.
# (Remove the WHERE clause and follow the instructions provided by the error message.)
#
UPDATE employee
 SET salary = salary / 2
 WHERE ID >= 0; 
