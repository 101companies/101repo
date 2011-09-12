var treeView = {};

// company content refresh
treeView.refresh = function() {
    content = "<ul>";
    
    if (treeModel.response.departments.length > 0) {
        content += "<li> <input id=\"0\" type=\"image\" src=\"symbols/plus.gif\" onclick=\"treeNavigation.toggleList(this)\">";
        content += "<input type=\"button\" class=\"companyButton\" value=\"" + treeModel.response.name + "\" onclick=\"controller.loadCompany(" + treeModel.response.id + ")\">";
        content += treeView.showDepartments(treeModel.response.departments);
        content += "</li>";
    } else {
        content += "<li> <img src=\"symbols/leaf.gif\"> <b>" + treeModel.response.name + "</b></li>";
    }
   
    content += "</ul>";
    
    document.querySelector('#tree').innerHTML = content;
}

treeView.showDepartments = function(deps) {
    content = "<ul style=\"display:none\">";
    
    for (var i = 0; i < deps.length; i++) {
        if (deps[i].employees.length > 0 || deps[i].departments.length > 0) {
            content += "<li> <input type=\"image\" src=\"symbols/plus.gif\" onclick=\"treeNavigation.toggleList(this)\">";
            if (deps[i].inconsistent == false) {
                content += "<input type=\"button\" class=\"departmentButton\" value=\"" + deps[i].name + "\" onclick=\"controller.loadDepartment(" + deps[i].id + ")\">";
            } else {
                content += "<input type=\"button\" class=\"departmentButtonError\" value=\"" + deps[i].name + "\" onclick=\"controller.loadDepartment(" + deps[i].id + ")\"><error>(no Manager)</error>";
            }
            
            if (deps[i].employees.length > 0) {
                content += treeView.showEmployees(deps[i].employees);
            }
            if (deps[i].departments.length > 0) {
                content += treeView.showDepartments(deps[i].departments);
            }
            content += "</li>";
        } else {
            content += "<li> <img src=\"symbols/leaf.gif\"><input type=\"button\" class=\"departmentButtonError\" value=\"" + deps[i].name + "\" onclick=\"controller.loadDepartment(" + deps[i].id + ")\"><error>(no Manager)</error></li>";
        }
        
    }
    
    content += "</ul>";
    
    return content;
}

treeView.showEmployees = function(employees) {
    content = "<ul style=\"display:none\">";
    
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