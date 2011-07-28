var view = {};

// department content refresh
view.refresh = function() {
    document.employee.name.value = model.response.name;
    document.employee.address.value = model.response.address;
    document.employee.salary.value = model.response.salary;
    
    document.querySelector('#namefailure').innerHTML = "";
    document.querySelector('#name').innerHTML = "Name:";
    
    document.querySelector('#addressfailure').innerHTML = "";
    document.querySelector('#address').innerHTML = "Name:";
    
    document.querySelector('#salaryfailure').innerHTML = "";
    document.querySelector('#salary').innerHTML = "Name:";
}

view.error = function() {
    if (model.error.failures.other != null) {
        alert(model.error.failures.other);
    } else {
        if (model.error.failures.name) {
            document.querySelector('#name').innerHTML = "Name:<error>*</error>";
            document.querySelector('#namefailure').innerHTML = "<error>" + model.error.failures.name + "</error>";
        }
        if (model.error.failures.address) {
            document.querySelector('#address').innerHTML = "Address:<error>*</error>";
            document.querySelector('#addressfailure').innerHTML = "<error>" + model.error.failures.address + "</error>";
        }
        if (model.error.failures.salary) {
            document.querySelector('#salary').innerHTML = "Salary:<error>*</error>";
            document.querySelector('#salaryfailure').innerHTML = "<error>" + model.error.failures.salary + "</error>";
        }
        if (model.error.failures.nameaddress) {
            document.querySelector('#name').innerHTML = "Name:<error>*</error>";
            document.querySelector('#address').innerHTML = "Address:<error>*</error>";
            document.querySelector('#addressfailure').innerHTML = "<error>" + model.error.failures.nameaddress + "</error>";
        }
    }
    
}


