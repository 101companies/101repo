var departmentModel = {};

departmentModel.url = 'server/departmentServer.php';

// init request-parameter
departmentModel.initDepartment = function(id) {
    departmentModel.department = {};
    departmentModel.department.id = id;
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
    departmentModel.initDepartment(departmentModel.response.id);
    departmentModel.department.action = "cut";
    
    requestUnit.sendRequest(strategy, departmentModel.url, departmentModel.department);
}

departmentModel.saveEntity = function(strategy, data) {
    departmentModel.initDepartment(departmentModel.response.id);
    if (data.name == '' || data.name == null) {
        requestUnit.error = {};
        requestUnit.error.error = true;
        requestUnit.error.failures = {};
        requestUnit.error.failures.name = errors.name;
        strategy.error();
    } else {
        departmentModel.department.name = data.name;
        departmentModel.department.manager = data.manager;
        departmentModel.department.parent = data.parent;
        departmentModel.department.action = "save";
    }   
    requestUnit.sendRequest(strategy, departmentModel.url, departmentModel.department);
}

departmentModel.deleteEntity = function(strategy) {
    departmentModel.initDepartment(departmentModel.response.id);
    departmentModel.department.action = "delete";
    requestUnit.sendRequest(strategy, departmentModel.url, departmentModel.department);
}