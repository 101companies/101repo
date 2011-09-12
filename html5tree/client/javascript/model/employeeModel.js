var employeeModel = {};

employeeModel.url = 'server/employeeServer.php';

// init request-parameter
employeeModel.initEmployee = function(id) {
    employeeModel.employee = {};
    employeeModel.employee.id = id;
    employeeModel.employee.table = "employee";
}

// load data for employee
employeeModel.load = function(strategy, id) {
    employeeModel.initEmployee(id);
    employeeModel.employee.action = "load";

    requestUnit.sendRequest(strategy, employeeModel.url, employeeModel.employee);
}

// cut employee
employeeModel.cut = function(strategy) {
    employeeModel.initEmployee(employeeModel.response.id);
    employeeModel.employee.action = "cut";
    
    requestUnit.sendRequest(strategy, employeeModel.url, employeeModel.employee);
}

employeeModel.saveEntity = function(strategy, data) {
    requestUnit.error = {};
    requestUnit.error.error = false;
    requestUnit.error.failures = {};
    
    if (data.name == '' || data.name == null) {
        requestUnit.error.error = true;
        requestUnit.error.failures.name = errors.name;
    }
    if (data.address == '' || data.address == null) {
        requestUnit.error.error = true;
        requestUnit.error.failures.address = errors.address;
    } 
    if (data.salary == '' || data.salary == null) {
        requestUnit.error.error = true;
        requestUnit.error.failures.salary = errors.salary;
    } 
    
    if (requestUnit.error == null || requestUnit.error.error == false) {
        employeeModel.initEmployee(employeeModel.response.id);
        employeeModel.employee.name = data.name;
        employeeModel.employee.address = data.address;
        employeeModel.employee.salary = data.salary;
        employeeModel.employee.parent = data.parent;
        employeeModel.employee.action = "save";
    
        requestUnit.sendRequest(strategy, employeeModel.url, employeeModel.employee);
    } else {
        strategy.error();
    }
    
    
}