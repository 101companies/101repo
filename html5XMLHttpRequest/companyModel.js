var model = {};

model.company;
model.departments;
model.totalValue;
model.changeTo;

model.response;

model.loadData = function() {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'company.xml', true);
	xhr.responseType = 'text';

	xhr.onload = function(e) {
		if (this.status == 200) {
			model.response = xhr.responseXML;
			controller.loadInner();
		}
	};

	xhr.send();
}

model.getCompanyName = function() {

	companyChilds = model.response.documentElement.childNodes;
	
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
	companyChilds = model.response.documentElement.childNodes;
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
	var salaryNodes = model.response.documentElement.getElementsByTagName("Salary");
	for (var i = 0; i < salaryNodes.length; i++) {
		var element = salaryNodes[i];
		t += parseFloat(element.childNodes[0].nodeValue);
	}
	model.totalValue = t;
	controller.notifyTotal();
}