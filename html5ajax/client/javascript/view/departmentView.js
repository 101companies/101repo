var view = {};

// department content refresh
view.refresh = function() {
    document.department.name.value = model.response.name;
    document.department.total.value = model.response.total;
    document.department.manager.value = model.response.manager;
    
    // init employee-list
    content = "<select name=\"employees\" size=\"5\" STYLE=\"width:100%;\">";

    for (var i = 0; i < model.response.employees.length; i++) {
        if(i == 0) {
            content += "<option value=\"" + model.response.employees[i] + "\" selected>";
        } else {
            content += "<option value=\"" + model.response.employees[i] + "\">";
        }
        content += model.response.employees[i] + "</option>";
    }

    content += "</select>";
    document.querySelector('#employees').innerHTML = content;
    
    // init department-list
    content = "<select name=\"departments\" size=\"5\" STYLE=\"width:100%;\">";

    for (var i = 0; i < model.response.departments.length; i++) {
        if(i == 0) {
            content += "<option value=\"" + model.response.departments[i] + "\" selected>";
        } else {
            content += "<option value=\"" + model.response.departments[i] + "\">";
        }
        content += model.response.departments[i] + "</option>";
    }

    content += "</select>";

    document.querySelector('#departments').innerHTML = content;
    document.querySelector('#namefailure').innerHTML = "";
    document.querySelector('#name').innerHTML = "Name:";
}

view.error = function() {
    if (model.error.failures.other != null) {
        alert(model.error.failures.other);
    } else {
        document.querySelector('#name').innerHTML = "Name:<error>*</error>";
        document.querySelector('#namefailure').innerHTML = "<error>" + model.error.failures.name + "</error>";
    }
}