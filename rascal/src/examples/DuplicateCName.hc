/*
Verifier check: the duplicate company name should be flagged.
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
}

company "meganalysis" {

}