var controller = {};

// -------------------------------------------- load data
controller.loadData = function(id) {
    model.loadData(loadStrategy, id);
}

// -------------------------------------------- save data
controller.changeName = function(newName, id) {
    model.saveData(saveStrategy, newName, id);
}

controller.saveEmployee = function(newName, newAddress, newSalary, id) {
    model.saveData(saveStrategy, newName, newAddress, newSalary, id);
}

// -------------------------------------------- cut
controller.cut = function(id) {
    model.cut(loadStrategy, id);
}

// -------------------------------------------- select department
controller.selectDepartment = function(name) {
    model.selectDepartment(selectStrategy, name);
}

// -------------------------------------------- select employee
controller.selectEmployee = function(name) {
    model.selectEmployee(selectStrategy, name);
}

// -------------------------------------------- Strategies
// load
var loadStrategy = {};
loadStrategy.update = function() {
    view.refresh();
}
loadStrategy.error = function() { /* stub */ }

// save
var saveStrategy = {};
saveStrategy.update = function() { 
    view.refresh();
}
saveStrategy.error = function() {
    view.error();
}

// select department
var selectStrategy = {};
selectStrategy.update = function() {
    if (model.response.resp == "department") {
        location.href = "department.html?departmentId=" + model.response.departmentId;
    } else if (model.response.resp == "employee") {
        location.href = "employee.html?employeeId=" + model.response.employeeId;
    }
   
}
selectStrategy.error = function() { /* stub */ }