var requestUnit = {};

// send request to the server
requestUnit.sendRequest = function(strategy, url, params) {
    var httpRequest = new XMLHttpRequest();
    httpRequest.open('POST', url, true);
    httpRequest.setRequestHeader("Content-Type", "application/json");
    
    httpRequest.onreadystatechange = function() {
        if (this.readyState == 3) {
            document.querySelector('#progress').innerHTML = "loading ...";
        } else if (this.readyState == 4) {
            document.querySelector('#progress').innerHTML = "";
        }
    }
    
    httpRequest.onload = function() {
        
        if (this.status == 200) {
            //document.querySelector('#headline').innerHTML = httpRequest.responseText;
            var result = JSON.parse(httpRequest.responseText);

            // if no error occurs, do something (strategy)
            if (result.error != true) {
                requestUnit.response = result; 
                requestUnit.error = {};
                requestUnit.error.error = false;
                strategy.update();
            // if there is an error: alert
            } else {
                requestUnit.error = result;
                strategy.error();
            }
        }
    }
    httpRequest.send(JSON.stringify(params));
}