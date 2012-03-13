/* A sample model, based on the example from:
	http://101companies.org/index.php/101feature:Company
*/
company "meganalysis" {
  department "Research" {
    manager "Craig" {
      address "Redmond"
      salary 77993
    }
    employee "Erica" {
      address "Utrecht"
      salary 44225
    }
    employee "Ray" {
      address "Redmond"
      salary 11994
    }
  }
  department "Development" {
    manager "Susan" {
      address "Boca Raton"
      salary 99541
    }
    
    employee "Raymond" {
      address "Galena"
      salary 234567
    }
    employee "James" { address "Amsterdam" salary 12345 }    
    department "Dev1" { 
    	manager "Betty" { 
    		address "Oslo" 
    		salary 12345 
    	} 
    	employee "Charles" { 
    		address "New York" 
    		salary 54321 
    	} 
    }
    department "Dev2" { manager "Barry" { address "Austin" salary 22334 } }
  }
}