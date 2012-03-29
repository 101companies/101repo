var model = {};

model.company;
model.departments;
model.totalValue;
model.changeTo;

model.loadData = function() {
	company.loadData();
}

model.getCompanyName = function() {

	companyChilds = company.response.documentElement.childNodes;
	
	for (var i = 0; i < companyChilds.length; i++) {
		if (companyChilds[i].nodeType == 1) {
			if ("Name" == companyChilds[i].nodeName) {
				model.company = companyChilds[i].childNodes[0].nodeValue;
			}
		}
	}
	controller.notifyCompany();
}

model.getDepartments = function() {
	companyChilds = company.response.documentElement.childNodes;
	model.departments = new Array();
	
	for (var i = 0; i < companyChilds.length; i++) {
		if (companyChilds[i].nodeType == 1) {
			if ("Departments" == companyChilds[i].nodeName) {
				var departmentList = companyChilds[i].childNodes;
				for (var j = 0; j < departmentList.length; j++) {
					if (departmentList[j].nodeType == 1) {
						for (var k = 1; k < departmentList[j].childNodes.length; k++) {
							if ("Name" == departmentList[j].childNodes[k].nodeName) {
								model.departments.push(departmentList[j].childNodes[k].childNodes[0].nodeValue);
							}
						}
					}
				}
				
			}
		}
	}
	controller.notifyDepartments();
}

model.total = function() {
	var t = 0;
	var salaryNodes = company.response.documentElement.getElementsByTagName("Salary");
	for (var i = 0; i < salaryNodes.length; i++) {
		var element = salaryNodes[i];
		t += parseFloat(element.childNodes[0].nodeValue);
	}
	model.totalValue = t;
	controller.notifyTotal();
}

model.cut = function() {
	var salaryNodes = company.response.documentElement.getElementsByTagName("Salary");
	for (var i = 0; i < salaryNodes.length; i++) {
		salaryNodes[i].childNodes[0].nodeValue = parseFloat(salaryNodes[i].childNodes[0].nodeValue) / 2;
	}
	company.saveData(company.response);
	model.total();
}

model.resetData = function() {
	company.reset();
}

model.selectDepartment = function(name) {
	var departmentList = company.response.documentElement.getElementsByTagName("Department");
	for (var i = 0; i < departmentList.length; i++) {
		if (departmentList[i].getElementsByTagName("Name")[0].childNodes[0].nodeValue == name) {
			model.changeTo = departmentList[i].getElementsByTagName("id")[0].childNodes[0].nodeValue;
		}
	}

	controller.changePage();
}

model.changeName = function(newName) {
	companyChilds = company.response.documentElement.childNodes;
	
	for (var i = 0; i < companyChilds.length; i++) {
		if (companyChilds[i].nodeType == 1) {
			if ("Name" == companyChilds[i].nodeName) {
				companyChilds[i].childNodes[0].nodeValue = newName;
			}
		}
	}
	company.saveData(company.response);
}