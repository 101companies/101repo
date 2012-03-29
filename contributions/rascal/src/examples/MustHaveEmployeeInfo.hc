/*
Verifier check: employees must have salary and address info
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
    employee "Bob" {
      address "Utrecht"
    }
    employee "Frank" {
      salary 12345
    }
    employee "George" {
    }
  }
}