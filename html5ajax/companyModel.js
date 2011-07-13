var model = {};

model.company;
model.departments;
model.totalValue;
model.changeTo;

model.loadData = function() {
	model.execute("load");
}

model.getCompanyName = function() {	
	model.company = company.response.name;
	
	controller.notifyCompany();
}

model.getDepartments = function() {
	model.departments = company.response.departments;
	
	controller.notifyDepartments();
}

model.total = function() {
	model.totalValue = company.response.total;
	
	controller.notifyTotal();
}

model.cut = function() {
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'company.php', true);
	xhr.setRequestHeader("action", "cut");
	xhr.setRequestHeader("table", "company");
	xhr.setRequestHeader("id", "1");
	
	xhr.onload = function(e) {
		if (this.status == 200) {
			var temp = xhr.responseText;
			model.totalValue = temp;
			controller.notifyTotal();
		}
	}
	xhr.send();
}

model.resetData = function() {
	model.execute("reset");
}

model.selectDepartment = function(name) {
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'company.php', true);
	xhr.setRequestHeader("action", "selectDepartment");
	xhr.setRequestHeader("table", "company");
	xhr.setRequestHeader("id", "1");
	
	xhr.onload = function(e) {
		if (this.status == 200) {
			model.changeTo = xhr.responseText;
			controller.changePage();
		}
	}
	xhr.send(name);
}

model.changeName = function(newName) {
	model.execute("save", newName);
}

model.execute = function(action, param) {
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'company.php', true);
	xhr.setRequestHeader("action", action);
	xhr.setRequestHeader("table", "company");
	xhr.setRequestHeader("id", "1");
	
	xhr.onload = function(e) {
		if (this.status == 200) {
			var temp = xhr.responseText;
			company.response = JSON.parse(temp);
			controller.loadInner();
		}
	}
	xhr.send(param);
}