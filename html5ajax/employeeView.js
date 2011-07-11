var gui = {};

gui.setName = function(name) {
	document.company.name.value = name;
}

gui.setAddress = function(address) {
	document.company.address.value = address;
}

gui.setSalary = function(salary) {
	document.company.salary.value = salary;
}

// this function generates the complete page
gui.generateFormular = function() {
	// create a form
	var content = "<form name=\"company\">";
	
	// create a table
	content += "<table border=0>";
	
	// employee name
	content += "<tr><td align=\"right\">Name: </td>";
	content += "<td><input type=\"text\" class=\"text\" name=\"name\"></td></tr>";
	
	// employee address
	content += "<tr><td align=\"right\">Address: </td>";
	content += "<td><input type=\"text\" class=\"text\" name=\"address\"></td></tr>";
	
	// employee salary
	content += "<tr><td align=\"right\">Salary: </td>";
	content += "<td><input type=\"text\" class=\"text\" name=\"salary\"></td></tr>";	
	
	content += "<tr><td colspan=\"2\"><input type=\"button\" name=\"save\" class=\"button\" value=\"save\" onclick=\"controller.save(" + employeeId + ", this.form.name.value, this.form.address.value, this.form.salary.value)\"></td></tr>";
	content += "</table>";
	content += "</form>";

	// move content to form
	document.querySelector('#content').innerHTML = content;
}