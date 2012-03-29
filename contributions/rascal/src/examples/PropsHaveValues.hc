/*
Verifier check: all properties have values. Names for companies, departments,
and employees are checked in other tests, here we just check address and
salary info. The salary cannot be null (just based on the grammar definition) 
since it is a number, so this really amounts to checking the address.
*/
company "meganalysis" {
  department "Research" {
    manager "Craig" {
      address ""
      salary 123456
    }
    employee "Erik" {
      address "Utrecht"
      salary 12345
    }
  }
}

company "pico-analysis" {
  department "Research" {
    manager "Bill" {
      address "Redmond"
      salary 123456
    }
    employee "Ted" {
      address ""
      salary 12345
    }
  }
}