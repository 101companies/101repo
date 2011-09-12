var employeeCreationModel = {};

// load data for employee
employeeCreationModel.load = function(strategy) {
    employeeCreationModel.employee = {};
    employeeCreationModel.employee.action = "blank";

    requestUnit.sendRequest(strategy, employeeModel.url, employeeCreationModel.employee);
}

// save new employee
employeeCreationModel.saveEntity = function(strategy, data) {
    employeeCreationModel.employee = {};
    employeeCreationModel.employee.name = data.name;
    employeeCreationModel.employee.address = data.address;
    employeeCreationModel.employee.salary = data.salary;
    employeeCreationModel.employee.parent = data.parent;
    employeeCreationModel.employee.action = "create";
    
    requestUnit.sendRequest(strategy, employeeModel.url, employeeCreationModel.employee);
}