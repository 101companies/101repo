function cut(company) {
	var salaryNodes = company.getElementsByTagName("Salary");
	for (var i = 0; i < salaryNodes.length; i++) {
		var element = salaryNodes[i];
		element.childNodes[0].nodeValue = parseFloat(element.childNodes[0].nodeValue) / 2;
	}
}