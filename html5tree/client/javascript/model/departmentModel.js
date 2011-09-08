var departmentModel = {};

departmentModel.url = 'server/departmentServer.php';

// init request-parameter
departmentModel.initDepartment = function() {
    departmentModel.department = {};
    departmentModel.department.table = "department";
}

// load data for department
departmentModel.load = function(strategy, id) {
    departmentModel.initDepartment();
    departmentModel.department.id = id;
    departmentModel.department.action = "load";

    requestUnit.sendRequest(strategy, departmentModel.url, departmentModel.department);
}

// cut department
departmentModel.cut = function(strategy) {
    departmentModel.initDepartment();
    departmentModel.department.id = departmentModel.response.id;
    departmentModel.department.action = "cut";
    
    requestUnit.sendRequest(strategy, departmentModel.url, departmentModel.department);
}