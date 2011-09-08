<?php
    
    include("databaseConnection/connection.php");
    include("classes/company.php");
    include("classes/statusMessages.php");

    startServer($HTTP_RAW_POST_DATA);
    
    // ---------------------------------------- perform request
    function perform($jsonObject) {
        $action = $jsonObject->action;
	
        switch ($action) {
            case "load":
                return loadCompany($jsonObject);
            
            case "save":
                return saveName($jsonObject);
            
            case "cut":
                return cut($jsonObject);
        }
    }
    
    // ---------------------------------------- load company
    function loadCompany($jsonObject) {
        $id = $jsonObject->id;
        
        // name
        $request = "SELECT * FROM company WHERE id = $id";
        $result = mysql_query($request);
        $row = mysql_fetch_object($result);
        
        $name = $row->name;
        
        // total
        $request = "SELECT * FROM employee";
        $result = mysql_query($request);
        $total = 0;
        while($row = mysql_fetch_object($result)) {
                $total += $row->salary;
        }
        
        // create company object
        $company = new Company();
        $company->setName($name);
        $company->setTotal($total);
        
        // return company object
        return $company;
    }
    
    // ---------------------------------------- save name
    function saveName($jsonObject) {
        $name = $jsonObject->newName;
        $id = $jsonObject->id;
        
        $request = "UPDATE company SET name = \"$name\" WHERE id = $id";
	mysql_query($request);
        
        if (mysql_error() == '') {
            return loadCompany($jsonObject);
        } else {
            $status = new Errormessage();
            $status->addFailure("name", "The name '" . $name . "' is in use.<br> Enter a valid name, please.");
            return $status;
        }
    }
    
    // ---------------------------------------- cut company
    function cut($jsonObject) {
        $id = $jsonObject->id;
	$request = "UPDATE employee SET salary = salary / 2 WHERE cid = $id";
	mysql_query($request);
        
        return loadCompany($jsonObject);
    }
    
?>