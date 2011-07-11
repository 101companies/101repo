var company = {};

company.response;

company.loadData = function() {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'company.xml', true);
	
	xhr.onload = function(e) {
		if (this.status == 200) {
			company.response = xhr.getResponseHeader("Company");
			controller.loadInner();
		}
	};

	xhr.send();
}

company.saveData = function(data) {
	var serializer = new XMLSerializer();
	var xml = serializer.serializeToString(data);
	
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'upload.php', true);
	xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
	xhr.setRequestHeader("X-File-Name", "company.xml");
	xhr.setRequestHeader("Content-Type", "application/octet-stream");
	xhr.send(xml);
}

company.reset = function() {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'companyReset.xml', true);
	
	xhr.onload = function(e) {
		if (this.status == 200) {
			company.response = xhr.responseXML;
			company.saveData(company.response);
			controller.loadInner();
		}
	};

	xhr.send();
}

function onError(e) {
  console.log('Error', e);
}
