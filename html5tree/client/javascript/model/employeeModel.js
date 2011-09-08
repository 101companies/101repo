var employeeModel = {};

employeeModel.url = 'server/employeeServer.php';

// init request-parameter
employeeModel.initEmployee = function(id) {
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