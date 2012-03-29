/*
Verifier check: the empty manager and employee names should be flagged.
*/
company "meganalysis" {
  department "Research" {
    manager "" {
      address "Redmond"
      salary 123456
    }
    employee "Erik" {
      address "Utrecht"
      salary 12345
    }
    employee "" {
      address "Utrecht"
      salary 12345
    }
  }
}
