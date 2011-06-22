var gui = {};

// this function updates the complete page
gui.update = function() {
	gui.generateFormular();
	
	document.querySelector('#reset').innerHTML = "<br><br><br><input type=\"button\" value=\"reset\" onclick=\"controller.reset()\">";
}

// this function updates the total value
gui.updateTotal = function() {
	document.company.total.value = model.totalValue;
}

// this function generates the gui for the company-page
gui.generateFormular = function() {

	// create a form
	var content = "<form name=\"company\">";
	
	// create a table
	content += "<table border=0>";
	
	// company name
		content += "<tr><td align=\"right\">Total: </td>";
	content += "<td><input type=\"text\" name=\"name\" value='" + model.headline + "'>";
	content += " <input type=\"button\" name=\"save\" value=\"save\" onclick=\"controller.changeName(this.form.name.value)\"></td></tr>";
	
	// department list
	content += "<tr ><td valign=\"top\" align=\"right\"><br>Departments: </td>";
	content += "<td align=\"center\"><p>";
	content += "<select name=\"Departments\" size=\"5\" STYLE=\"width:100%;\">";

	for (var i = 0; i < model.departments.length; i++) {
		if(i == 0) {
			content += "<option value=\"" + model.departments[i] + "\" selected>";
		} else {
			content += "<option value=\"" + model.departments[i] + "\">";
		}
		content += model.departments[i] + "</option>";
	}

	content += "</select>";
	content += "</p>";
	
	// department selection button
	content += "<input type=\"button\" value=\"select\" onclick=\"controller.selectDepartment(this.form.Departments.options[this.form.Departments.selectedIndex].value)\"><br><br></td></tr>";

	// total
	content += "<tr><td align=\"right\">Total: </td>";
	content += "<td><input type=\"text\" name=\"total\" readonly=\"readonly\">";
	content += " <input type=\"button\" name=\"cut\" value=\"cut\" onclick=\"controller.cut()\"></td></tr>";
	
	content += "</table>";
	content += "</form>";

	// move content to form
	document.querySelector('#content').innerHTML = content;
}