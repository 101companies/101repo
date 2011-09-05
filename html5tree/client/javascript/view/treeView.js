var view = {};

// company content refresh
view.refresh = function() {
    content = "<ul>";
    
    if (model.response.departments.length > 0) {
        content += "<li> <input id=\"0\" type=\"image\" src=\"symbols/plus.gif\" onclick=\"treeNavigation.toggleList(this)\"> <b>" + model.response.name + "</b></li>";
        content += view.showDepartments(model.response.departments, "0");
    } else {
        content += "<li> <img src=\"symbols/leaf.gif\"> <b>" + model.response.name + "</b></li>";
    }
   
    content += "</ul>";
    
    document.querySelector('#tree').innerHTML = content;
}

view.showDepartments = function(deps, id) {
    content = "<ul id=\"" + id + "\" style=\"display:none\">";
    
    for (var i = 0; i < deps.length; i++) {
        if (deps[i].employees.length > 0 || deps[i].departments.length > 0) {
            var idTemp = id + i;
            content += "<li> <input id=\"" + idTemp + "\" type=\"image\" src=\"symbols/plus.gif\" onclick=\"treeNavigation.toggleList(this)\"> <i>" + deps[i].name + "</i></li>";
            if (deps[i].employees.length > 0) {
                content += view.showEmployees(deps[i].employees, idTemp);
            }
            if (deps[i].departments.length > 0) {
                content += view.showDepartments(deps[i].departments, idTemp);
            }
        } else {
            content += "<li> <img src=\"symbols/leaf.gif\"> <i>" + deps[i].name + "</i></li>";
        }
        
    }
    
    content += "</ul>";
    
    return content;
}

view.showEmployees = function(employees, id) {
    content = "<ul id=\"" + id + "\" style=\"display:none\">";
    
    for (var i = 0; i < employees.length; i++) {
        if (employees[i].manager == false) {
            content += "<li> <img src=\"symbols/leaf.gif\"> " + employees[i].name + "</li>";
        } else {
            content += "<li> <img src=\"symbols/leaf.gif\">  Manager: " + employees[i].name + "</li>";
        }
    }
    
    content += "</ul>";
    return content;
}