var gui = {};

// this function updates the total value
gui.updateTotal = function() {
	document.company.total.value = model.totalValue;
}

gui.updateDepartment = function() {
	document.company.name.value = model.name;
}

gui.updateManager = function() {
	document.company.manager.value = model.manager;
}

gui.updateEmployees = function() {
	var content = "<p><select name=\"Employees\" size=\"5\" STYLE=\"width:100%;\">";
	
	for (var i = 0; i < model.employees.length; i++) {
		if(i == 0) {
			content += "<option value=\"" + model.employees[i] + "\" selected>";
		} else {
			content += "<option value=\"" + model.employees[i] + "\">";
		}
		content += model.employees[i] + "</option>";
	}

	content += "</select>";
	content += "</p>";
	
	// employee selection button
	content += "<input type=\"button\" value=\"select\" onclick=\"model.selectEmployee(this.form.Employees.options[this.form.Employees.selectedIndex].value)\">";
	
	document.querySelector('#employees').innerHTML = content;
}

gui.updateSubdepartments = function() {
	var content = "<p><select name=\"Departments\" size=\"5\" STYLE=\"width:100%;\">";
	
	for (var i = 0; i < model.subdepartments.length; i++) {
		if(i == 0) {
			content += "<option value=\"" + model.subdepartments[i] + "\" selected>";
		} else {
			content += "<option value=\"" + model.subdepartments[i] + "\">";
		}
		content += model.subdepartments[i] + "</option>";
	}

	content += "</select>";
	content += "</p>";
	
// department selection button
	content += "<input type=\"button\" value=\"select\" onclick=\"model.selectDepartment(this.form.Departments.options[this.form.Departments.selectedIndex].value)\"><br><br>";	
	
	document.querySelector('#departments').innerHTML = content;
}

// this function generates the gui for the company-page
gui.generateFormular = function() {

	// create a form
	var content = "<form name=\"company\">";
	
	// create a table
	content += "<table border=0>";
	
	// department name
	content += "<tr><td align=\"right\">Name: </td>";
	content += "<td><input type=\"text\" name=\"name\">";
	content += " <input type=\"button\" name=\"save\" value=\"save\" onclick=\"model.changeName(" + departmentId + ", this.form.name.value)\"></td></tr>";
	
	// manager
	content += "<tr><td align=\"right\">Manager: </td>";
	content += "<td><input type=\"text\" name=\"manager\" readonly=\"readonly\">";
	content += " <input type=\"button\" name=\"edit\" value=\"edit\" onclick=\"model.selectEmployee(this.form.manager.value)\"></td></tr>";
	
	// employee list
	content += "<tr ><td valign=\"top\" align=\"right\"><br>Employees: </td>";
	content += "<td align=\"center\">";
	content += "<div id=\"employees\" name=\"employees\"></div></td></tr>";
	
	// subdepartment list
	content += "<tr ><td valign=\"top\" align=\"right\"><br>Departments: </td>";
	content += "<td align=\"center\">";
	content += "<div id=\"departments\" name=\"departments\"></div></td></tr>";

	// total
	content += "<tr><td align=\"right\">Total: </td>";
	content += "<td><input type=\"text\" name=\"total\" readonly=\"readonly\">";
	content += " <input type=\"button\" name=\"cut\" value=\"cut\" onclick=\"model.cut(" + departmentId + ")\"></td></tr>";
	
	content += "</table>";
	content += "</form>";

	// move content to form
	document.querySelector('#content').innerHTML = content;
}