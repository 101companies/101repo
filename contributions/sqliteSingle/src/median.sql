-- Median for odd number of employees
SELECT salary FROM Employee 
		    ORDER BY salary 
		    LIMIT 1 
		    OFFSET 
		      CAST((SELECT COUNT(ID) FROM Employee) / 2 AS INTEGER);
-- Median for even number of employees
SELECT AVG(salary) FROM Employee 
		      ORDER BY salary 
		      LIMIT 2 
		      OFFSET 
			CAST((SELECT COUNT(ID) FROM Employee) / 2 AS INTEGER);
-- A Way to Compute median for even and ood numbers of employees simulatinious
SELECT AVG(salary) FROM Employee -- avarage of one element is the identity-function
			  ORDER BY salary 
			  LIMIT (((SELECT COUNT(ID) FROM Employee) % 2 ) + 1 ) -- for even numbers 1 and odd numers 2
			  OFFSET CAST((SELECT COUNT(ID) FROM Employee) / 2 AS INTEGER);