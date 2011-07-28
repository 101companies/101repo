var model = {};

// send request to the server
model.sendRequest = function(strategy, params) {
    var httpRequest = new XMLHttpRequest();
    httpRequest.open('POST', model.url, true);
    httpRequest.setRequestHeader("Content-Type", "application/json");
    
    httpRequest.onload = function() {
        if (this.status == 200) {
            var result = JSON.parse(httpRequest.responseText);

            // if no error occurs, do something (strategy)
            if (result.error != true) {
                model.response = result; 
                model.error = {};
                model.error.error = false;
                strategy.update();
            // if there is an error: alert
            } else {
                model.error = result;
                strategy.error();
            }
        }
    }
    httpRequest.send(JSON.stringify(params));
}

