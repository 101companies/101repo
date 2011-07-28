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

    model.sendRequest(strategy, model.company);
}