var departmentView = {};

departmentView.refresh = function() {
    document.querySelector('#headline').innerHTML = "<h3> Department </h3>";

    document.department.name.value = model.response.name;
    document.department.total.value = model.response.total;
    
    document.getElementById("managerList").options.length = 0;
    document.getElementById("depParentList").options.length = 0;
    
    noManager = new Option("", null, false, false);
    document.department.manager.options[0] = noManager;
    
    for (var i = 0; i < model.response.employees.length; i++) {
        var selected = false;
        if (model.response.employees[i].manager == true) {
            selected = true;
        }
        var employee = new Option(model.response.employees[i].name, model.response.employees[i].id, false, selected);
        document.department.manager.options[i + 1] = employee;
    }
    
    noParent = new Option("", null, false, false);
    document.department.parent.options[0] = noParent;
    
    for (var j = 0; j < model.response.departments.length; j++) {
        var selected2 = false;
        if (model.response.departments[j].parent == true) {
            selected2 = true;
        }
        var department = new Option(model.response.departments[j].name, model.response.departments[j].id, false, selected2);
        document.department.parent.options[j + 1] = department;
    }
}

departmentView.getValues = function() {
    var data = {};
    data.name = document.department.name.value;
    data.manager = document.department.manager.options[document.department.manager.selectedIndex].value;
    data.parent = document.department.parent.options[document.department.parent.selectedIndex].value;
    return data;
}