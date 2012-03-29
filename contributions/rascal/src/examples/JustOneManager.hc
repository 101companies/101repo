/*
Verifier check: each department should have exactly one manager. Both cases are
shown below. In the first, no manager is provided for Development. In the second,
two managers are provided for Development.
*/
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
  department "Development" {
    employee "Frank" {
      address "Redmond"
      salary 123456
    }
    employee "William" {
      address "Utrecht"
      salary 12345
    }
  }
  department "Marketing" {
    manager "Bob" {
      address "Redmond"
      salary 123456
    }
    manager "Russell" {
      address "Utrecht"
      salary 12345
    }
  }
}