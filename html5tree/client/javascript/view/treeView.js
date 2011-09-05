var treeView = {};

// company content refresh
treeView.refresh = function() {
    content = "<ul>";
    
    if (model.response.departments.length > 0) {
        content += "<li> <input id=\"0\" type=\"image\" src=\"symbols/plus.gif\" onclick=\"treeNavigation.toggleList(this)\">";
        content += "<input type=\"button\" class=\"companyButton\" value=\"" + model.response.name + "\" onclick=\"controller.loadCompany(" + model.response.id + ")\">";
        content += treeView.showDepartments(model.response.departments, "0");
        content += "</li>";
    } else {
        content += "<li> <img src=\"symbols/leaf.gif\"> <b>" + model.response.name + "</b></li>";
    }
   
    content += "</ul>";
    
    document.querySelector('#tree').innerHTML = content;
}

treeView.showDepartments = function(deps, id) {
    content = "<ul id=\"" + id + "\" style=\"display:none\">";
    
    for (var i = 0; i < deps.length; i++) {
        if (deps[i].employees.length > 0 || deps[i].departments.length > 0) {
            var idTemp = id + i;
            content += "<li> <input id=\"" + idTemp + "\" type=\"image\" src=\"symbols/plus.gif\" onclick=\"treeNavigation.toggleList(this)\">";
            content += "<input type=\"button\" class=\"departmentButton\" value=\"" + deps[i].name + "\" onclick=\"controller.loadDepartment(" + deps[i].id + ")\">";
            if (deps[i].employees.length > 0) {
                content += treeView.showEmployees(deps[i].employees, idTemp);
            }
            if (deps[i].departments.length > 0) {
                content += treeView.showDepartments(deps[i].departments, idTemp);
            }
            content += "</li>";
        } else {
            content += "<li> <img src=\"symbols/leaf.gif\"> <i>" + deps[i].name + "</i></li>";
        }
        
    }
    
    content += "</ul>";
    
    return content;
}

treeView.showEmployees = function(employees, id) {
    content = "<ul id=\"" + id + "\" style=\"display:none\">";
    
    for (var i = 0; i < employees.length; i++) {
        if (employees[i].manager == false) {
            content += "<li> <img src=\"symbols/leaf.gif\">";
            content += "<input type=\"button\" class=\"employeeButton\" value=\"" + employees[i].name + "\" onclick=\"controller.loadEmployee(" + employees[i].id + ")\"></li>";
        } else {
            content += "<li> <img src=\"symbols/leaf.gif\">";
            content += "<input type=\"button\" class=\"employeeButton\" value=\"" + employees[i].name + "\" onclick=\"controller.loadEmployee(" + employees[i].id + ")\"> (Manager) </li>";
        }
    }
    
    content += "</ul>";
    return content;
}