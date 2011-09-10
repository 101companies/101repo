var employeeView = {};

employeeView.refresh = function() {
    document.querySelector('#headline').innerHTML = "<h3> Employee </h3>";

    document.employee.name.value = model.response.name;
    document.employee.address.value = model.response.address;
    document.employee.total.value = model.response.salary;
    
    document.getElementById("empParentList").options.length = 0;
    
    noParent = new Option("", null, false, false);
    document.employee.parent.options[0] = noParent;
    
    for (var j = 0; j < model.response.departments.length; j++) {
        var selected2 = false;
        if (model.response.departments[j].parent == true) {
            selected2 = true;
        }
        var department = new Option(model.response.departments[j].name, model.response.departments[j].id, false, selected2);
        document.employee.parent.options[j + 1] = department;
    }
}

employeeView.getValues = function() {
    var data = {};
    data.name = document.employee.name.value;
    data.address = document.employee.address.value;
    data.salary = document.employee.total.value;
    data.parent = document.employee.parent.options[document.employee.parent.selectedIndex].value;
    return data;
}

employeeView.validate = function(evt) {
    var event = evt || window.event;
    var charcode = event.keyCode || event.which;
    input = String.fromCharCode( charcode );
    
    var regex = /[0-9]|\./;
    if( !regex.test(input) && charcode != 8 && charcode != 37 && charcode != 39 && charcode != 46) {
        event.returnValue = false;
        if(event.preventDefault) event.preventDefault();
    }
}