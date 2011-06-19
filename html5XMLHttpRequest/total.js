function total(company) {
	var t = 0;
	var salaryNodes = company.getElementsByTagName("Salary");
	for (var i = 0; i < salaryNodes.length; i++) {
		var element = salaryNodes[i];
		t += parseFloat(element.childNodes[0].nodeValue);
	}
	return t;
}