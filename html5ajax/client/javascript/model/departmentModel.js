// server for company-manipulation
model.url = '../server/departmentServer.php';

// init request-parameter
model.initDepartment = function() {
    model.department = {};
    model.department.table = "department";
}

// load data for company
model.loadData = function(strategy, id) {
    model.initDepartment();
    model.department.id = id;
    model.department.action = "load";

    model.sendRequest(strategy, model.department);
}

// save company name
model.saveData = function(strategy, newName, id) {
    model.initDepartment();
    model.department.id = id;
    model.department.action = "save";
    
    if (newName == '' || newName == null) {
        model.error = {};
        model.error.error = true;
        model.error.failures = {};
        model.error.failures.name = errors.name;
        strategy.error();
    } else {
        model.department.newName = newName;
    
        model.sendRequest(strategy, model.department);
    }
}

// cut company
model.cut = function(strategy, id) {
    model.initDepartment();
    model.department.id = id;
    model.department.action = "cut";
    
    model.sendRequest(strategy, model.department);
}

// select department
model.selectDepartment = function(strategy, departmentName) {
    model.initDepartment();
    model.department.action = "selectDepartment";
    model.department.departmentName = departmentName;
    
    model.sendRequest(strategy, model.department);
}

// select employee
model.selectEmployee = function(strategy, employeeName) {
    model.initDepartment();
    model.department.action = "selectEmployee";
    model.department.departmentName = employeeName;
    
    model.sendRequest(strategy, model.department);
}