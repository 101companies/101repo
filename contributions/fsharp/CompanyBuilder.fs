module CompanyBuilder
open CompanyModel

let buildCompany = 
    let c = new Company()
    c.Name <- "meganalysis"

    // research department
    let researchDept = new Department()
    researchDept.Name <- "Research"

    let craigPerson = new Person()
    craigPerson.Name <- "Craig"
    craigPerson.Address <- "Redmond"
    let craigManager = new Employee(craigPerson)
    craigManager.Salary <- 123456M

    let erikPerson = new Person()
    erikPerson.Name <- "Erik"
    erikPerson.Address <- "Utrecht"
    let erikEmployee = new Employee(erikPerson)
    erikEmployee.Salary <- 12345M

    let ralfPerson = new Person()
    ralfPerson.Name <- "Ralf"
    ralfPerson.Address <- "Koblenz"
    let ralfEmployee = new Employee(ralfPerson)
    ralfEmployee.Salary <- 1234M

    researchDept.Manager <- craigManager;
    researchDept.Employees.Add(erikEmployee);
    researchDept.Employees.Add(ralfEmployee);

    //development department
    let devDept = new Department()
    devDept.Name <- "Development"

    let rayPerson = new Person()
    rayPerson.Name <- "Ray"
    rayPerson.Address <- "Redmond"
    let rayManager= new Employee(rayPerson)
    rayManager.Salary <- 234567M

    devDept.Manager <- rayManager;

    // dev1 subunit
    let dev1Dept = new Department()
    dev1Dept.Name <- "Dev1"

    let klausPerson = new Person()
    klausPerson.Address <- "Boston"
    klausPerson.Name <- "Klaus"
    let klausManager = new Employee(klausPerson)
    klausManager.Salary <- 23456M

    dev1Dept.Manager <- klausManager;
    devDept.SubUnits.Add(dev1Dept)

    // dev1.1 subunit
    let dev11 = new Department()
    dev11.Name <- "Dev1.1"

    dev1Dept.SubUnits.Add(dev11)

    let karlPerson = new Person()
    karlPerson.Address <- "Riga"
    karlPerson.Name <- "Karl"
    let karlManger = new Employee(karlPerson)
    karlManger.Salary <- 2345M

    dev11.Manager <- karlManger;

    let joePerson = new Person()
    joePerson.Address <- "Wifi City"
    joePerson.Name <- "Joe"
    let joeEmployee = new Employee(joePerson)
    joeEmployee.Salary <- 2344M

    dev11.Employees.Add(joeEmployee)

    c.Departments.Add(researchDept)
    c.Departments.Add(devDept)
    c
