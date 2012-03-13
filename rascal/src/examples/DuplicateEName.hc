/*
Verifier check: each employee can appear at most once.
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
  department "Marketing" {
    manager "John" {
      address "Redmond"
      salary 123456
    }
    employee "Craig" {
      address "Utrecht"
      salary 12345
    }
  }
}

company "pico-analysis" {
  department "Research" {
    manager "Erik" {
      address "Redmond"
      salary 123456
    }
    employee "Ted" {
      address "Utrecht"
      salary 12345
    }
  }
}