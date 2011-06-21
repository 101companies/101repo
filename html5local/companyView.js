var gui = {};

gui.update = function() {
	document.querySelector('#headline').innerHTML = "<h1>" + model.headline + "</h1>";
	
	document.querySelector('#reset').innerHTML = "<br><br><br><input type=\"button\" value=\"reset\" onclick=\"model.reset()\">";
	gui.generateDepartments();
}

gui.updateTotal = function() {
	document.querySelector('#total').innerHTML = "<br>Total: " + model.totalValue + " <input type=\"button\" name=\"cut\" value=\"cut\" onclick=\"model.cut()\">";
}

gui.generateDepartments = function() {
	var content = "Departments: <br>";
	content += "<form action=\"select1.htm\">";
	content += "<p>";
	content += "<select name=\"Departments\" size=\"5\" STYLE=\"width:100px;\">";

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
			
	content += "<input type=\"button\" value=\"select\" onclick=\"model.selectDepartment(this.form.Departments.options[this.form.Departments.selectedIndex].value)\" >";
	content += "</form>";

	document.querySelector('#content').innerHTML = content;
}