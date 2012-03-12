/* A sample model, based loosely on the example from:
	http://101companies.org/index.php/101feature:Company
	
   But, this one has lots and lots of errors.
*/
company "meganalysis" {
  department "Research" {
    manager "Craig" {
      address ""
      salary 77993
    }
    employee "Erica" {
      salary 44225
    }
    employee "Ray" {
      address "Redmond"
    }
  }
  department "Research" {
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
    	employee "" { 
    		address "New York" 
    		salary 54321 
    	} 
    }
    department "Dev2" { manager "Barry" { address "Austin" salary 22334 } }
  }
}

company "meganalysis" {
}

company "" {
  department "" {
    manager "Craig" {
      address "Redmond"
      salary 77993
    }
    employee "Eric" {
      address ""
      salary 44225
    }
    employee "Susan" {
      address "Redmond"
      salary 11994
    }

    manager "Julia" {
      address "Redmond"
      salary 11994
    }
  }
  
  department "Support" {
  }
}