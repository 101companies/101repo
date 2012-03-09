/*
Verifier check: the duplicate department name should be flagged inside the
first company. However, it should not be flagged inside the second company,
since duplicates are only problems within a company.
*/
company "meganalysis" {
  department "Research" {
    manager "Craig" {
      address "Redmond"
      salary 123456
    }
    employee "Erik" {
      address "Utrecht"
      salary 12345
    }
  }
  department "Research" {
    manager "John" {
      address "Redmond"
      salary 123456
    }
    employee "Frank" {
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
      address "Utrecht"
      salary 12345
    }
  }
}