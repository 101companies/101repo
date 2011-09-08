var employeeModel = {};

employeeModel.url = 'server/employeeServer.php';

// init request-parameter
employeeModel.initEmployee = function() {
    employeeModel.employee = {};
    employeeModel.employee.table = "employee";
}

// load data for employee
employeeModel.load = function(strategy, id) {
    employeeModel.initEmployee();
    employeeModel.employee.id = id;
    employeeModel.employee.action = "load";

    requestUnit.sendRequest(strategy, employeeModel.url, employeeModel.employee);
}

// cut employee
employeeModel.cut = function(strategy) {
    employeeModel.initEmployee(employeeModel.response.id);
    employeeModel.employee.id = employeeModel.response.id;
    employeeModel.employee.action = "cut";
    
    requestUnit.sendRequest(strategy, employeeModel.url, employeeModel.employee);
}