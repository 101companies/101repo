/*
Verifier check: the empty department name should be flagged.
*/
company "pico-analysis" {
  department "" {
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