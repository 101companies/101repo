// server for company-manipulation
model.url = '../server/employeeServer.php';

// init request-parameter
model.initEmployee = function() {
    model.employee = {};
    model.employee.table = "employee";
}

// load data for company
model.loadData = function(strategy, id) {
    model.initEmployee();
    model.employee.id = id;
    model.employee.action = "load";

    model.sendRequest(strategy, model.employee);
}

// save company name
model.saveData = function(strategy, newName, newAddress, newSalary, id) {
    model.initEmployee();
    model.employee.id = id;
    model.employee.action = "save";
    
    model.error = {};
    model.error.error = false;
    model.error.failures = {};
    
    if (newName == '' || newName == null) {
        model.error.error = true;
        model.error.failures.name = errors.name;
    }
    if (newAddress == '' || newAddress == null) {
        model.error.error = true;
        model.error.failures.address = errors.address;
    } 
    if (newSalary == '' || newSalary == null) {
        model.error.error = true;
        model.error.failures.salary = errors.salary;
    } 
    
    if (model.error == null || model.error.error == false) {
        model.employee.newName = newName;
        model.employee.newAddress = newAddress;
        model.employee.newSalary = newSalary;
    
        model.sendRequest(strategy, model.employee);
    } else {
        view.error();
    }
}

// cut company
model.cut = function(strategy, id) {
    model.initEmployee();
    model.employee.id = id;
    model.employee.action = "cut";
    
    model.sendRequest(strategy, model.employee);
}