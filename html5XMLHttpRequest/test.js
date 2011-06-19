function loadCompany(path) {
	var xhReq = new XMLHttpRequest();
	xhReq.open("GET", path, false);
	xhReq.send();
	var serverResponse = xhReq.responseXML;
	return serverResponse;
}

var company = loadCompany('company.xml').documentElement;
document.write("Total = " + total(company) + "<br>");
document.write("Cut<br>");
cut(company);
document.write("Total = " + total(company) + "<br>");