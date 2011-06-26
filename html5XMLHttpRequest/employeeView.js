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
	content += "<td><input type=\"text\" name=\"name\">";
	
	// employee address
	content += "<tr><td align=\"right\">Address: </td>";
	content += "<td><input type=\"text\" name=\"address\">";
	
	// employee salary
	content += "<tr><td align=\"right\">Salary: </td>";
	content += "<td><input type=\"text\" name=\"salary\">";	
	content += "</table>";
	
	content += " <input type=\"button\" name=\"save\" value=\"save\" onclick=\"controller.save(" + employeeId + ", this.form.name.value, this.form.address.value, this.form.salary.value)\"></td></tr>";
	content += "</form>";

	// move content to form
	document.querySelector('#content').innerHTML = content;
}