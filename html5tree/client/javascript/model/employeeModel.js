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
    employeeModel.initEmployee(employeeModel.response.id);
    employeeModel.employee.name = data.name;
    employeeModel.employee.address = data.address;
    employeeModel.employee.salary = data.salary;
    employeeModel.employee.action = "save";
    
    requestUnit.sendRequest(strategy, employeeModel.url, employeeModel.employee);
}