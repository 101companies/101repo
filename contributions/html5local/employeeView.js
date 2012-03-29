var gui = {};

// this function updates the complete page
gui.update = function() {
	gui.generateFormular();
}

gui.generateFormular = function() {
	// create a form
	var content = "<form name=\"company\">";
	
	// create a table
	content += "<table border=0>";
	
	// employee name
	content += "<tr><td align=\"right\">Name: </td>";
	content += "<td><input type=\"text\" name=\"name\" class=\"text\" value='" + model.name + "'></td></tr>";
	
	// employee address
	content += "<tr><td align=\"right\">Address: </td>";
	content += "<td><input type=\"text\" name=\"address\" class=\"text\" value='" + model.address + "'></td></tr>";
	
	// employee salary
	content += "<tr><td align=\"right\">Salary: </td>";
	content += "<td><input type=\"text\" name=\"salary\" class=\"text\" value='" + model.salary + "'></td></tr>";	
	
	
	content += "<tr><td colspan=\"2\"><input type=\"button\" name=\"save\" class=\"button\" value=\"save\" onclick=\"model.save(" + employeeId + ", this.form.name.value, this.form.address.value, this.form.salary.value)\"></td></tr>";
	content += "</table>";
	
	content += "</form>";

	// move content to form
	document.querySelector('#content').innerHTML = content;
}