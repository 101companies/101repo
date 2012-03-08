/*
Verifier check: the empty company name should be flagged.
*/
company "" {
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
}