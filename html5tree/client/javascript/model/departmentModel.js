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