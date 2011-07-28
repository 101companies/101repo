<?php

    include("databaseConnection/connection.php");
    include("classes/employee.php");
    include("classes/statusMessages.php");
    
    startServer($HTTP_RAW_POST_DATA);
    
    // ---------------------------------------- perform request
    function perform($jsonObject) {
        $action = $jsonObject->action;
	
        switch ($action) {
            case "load":
                return loadEmployee($jsonObject);
            
            case "save":
                return saveEmployee($jsonObject);
            
            case "cut":
                return cut($jsonObject);
        }
    }
    
    // ---------------------------------------- load employee
    function loadEmployee($jsonObject) {
        $id = $jsonObject->id;
        
        // name
        $request = "SELECT * FROM employee WHERE id = $id";
        $result = mysql_query($request);
        $row = mysql_fetch_object($result);
        
        $name = $row->name;
        $address = $row->address;
        $salary = $row->salary;
        
        // create department object
        $employee = new Employee();
        $employee->setName($name);
        $employee->setAddress($address);
        $employee->setSalary($salary);
 
        // return department object
        return $employee;
    }
    
    // ---------------------------------------- cut employee
    function cut($jsonObject) {
        $id = $jsonObject->id;
        
        $request = "UPDATE employee SET salary = salary / 2 WHERE id = " . $id;
        mysql_query($request);
        
        return loadEmployee($jsonObject);
    }
    
    // ---------------------------------------- save 
    function saveEmployee($jsonObject) {
        $id = $jsonObject->id;
        $name = $jsonObject->newName;
        $address = $jsonObject->newAddress;
        $salary = $jsonObject->newSalary;
        
        $request = "UPDATE employee SET name = '" . $name .
                                    "', address = '" . $address .
                                    "', salary = '" . $salary .
                                     "' WHERE id = " . $id;
        mysql_query($request);
        
        
        $error = mysql_error();
        if ($error == '' || $error == null) {
            return loadEmployee($jsonObject);
        } else {
            $status = new Errormessage();
            $status->addFailure("nameaddress", "Duplicate entry for name and address.");
            return $status;
        }
    }
    
?>
