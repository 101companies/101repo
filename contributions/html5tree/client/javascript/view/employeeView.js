var employeeView = {};

employeeView.refresh = function() {
    document.querySelector('#headline').innerHTML = "<h3> Employee </h3>";

    employeeView.emptyFailures();

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

employeeView.error = function() {
    employeeView.emptyFailures();
    
    if (model.error.failures.other != null) {
        alert(model.error.failures.other);
    } else {
        if (model.error.failures.name) {
            document.querySelector('#empNameFailure').innerHTML = "Name:<error>*</error>";
            document.querySelector('#empNameFailureMessage').innerHTML = "<error>" + model.error.failures.name + "</error>";
        }
        if (model.error.failures.address) {
            document.querySelector('#addressFailure').innerHTML = "Address:<error>*</error>";
            document.querySelector('#addressFailureMessage').innerHTML = "<error>" + model.error.failures.address + "</error>";
        }
        if (model.error.failures.salary) {
            document.querySelector('#salaryFailure').innerHTML = "Salary:<error>*</error>";
            document.querySelector('#salaryFailureMessage').innerHTML = "<error>" + model.error.failures.salary + "</error>";
        }
        if (model.error.failures.nameaddress) {
            document.querySelector('#empNameFailure').innerHTML = "Name:<error>*</error>";
            document.querySelector('#addressFailure').innerHTML = "Address:<error>*</error>";
            document.querySelector('#addressFailureMessage').innerHTML = "<error>" + model.error.failures.nameaddress + "</error>";
        }
    }
    
}

employeeView.emptyFailures = function() {
    document.querySelector('#empNameFailureMessage').innerHTML = "";
    document.querySelector('#empNameFailure').innerHTML = "Name:";
    
    document.querySelector('#addressFailureMessage').innerHTML = "";
    document.querySelector('#addressFailure').innerHTML = "Address:";
    
    document.querySelector('#salaryFailureMessage').innerHTML = "";
    document.querySelector('#salaryFailure').innerHTML = "Salary:";
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