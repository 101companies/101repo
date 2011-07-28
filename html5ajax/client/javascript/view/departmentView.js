var view = {};

// company content refresh
view.refresh = function() {
    document.company.name.value = model.response.name;
    document.company.total.value = model.response.total;
    
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
    
    // init employee-list
    content = "<select name=\"employees\" size=\"5\" STYLE=\"width:100%;\">";

    for (var i = 0; i < model.response.employees.length; i++) {
        if(i == 0) {
            content += "<option value=\"" + model.employees.departments[i] + "\" selected>";
        } else {
            content += "<option value=\"" + model.employees.departments[i] + "\">";
        }
        content += model.employees.departments[i] + "</option>";
    }

    content += "</select>";

    document.querySelector('#departments').innerHTML = content;
    document.querySelector('#namefailure').innerHTML = "";
    document.querySelector('#name').innerHTML = "Name:";
}

// change page to departments
view.changePage = function() {
    location.href = "department.html?departmentId=" + model.response.departmentId;
}

view.error = function() {
    if (model.error.failures.other != null) {
        alert(model.error.failures.other);
    } else {
        document.querySelector('#name').innerHTML = "Name:<error>*</error>";
        document.querySelector('#namefailure').innerHTML = "<error>" + model.error.failures.name + "</error>";
    }
}