<?php

    include("databaseConnection/connection.php");
    include("employeeSupportFunctions.php");
    include("classes/employee.php");
    include("classes/statusMessages.php");
    
    startServer($HTTP_RAW_POST_DATA);
    
    // ---------------------------------------- perform request
    function perform($jsonObject) {
        $action = $jsonObject->action;
	
        switch ($action) {
            case "load":
                return loadEmployee($jsonObject->id);
            
            case "blank":
                return loadBlank();
                
            case "save":
                return saveEmployee($jsonObject);
            
            case "create":
                return create($jsonObject);
                
            case "cut":
                return cut($jsonObject);
                
            case "delete":
                return delete($jsonObject);
            
        }
    }
    
    // ---------------------------------------- load blank
    function loadBlank() {
        // departments
        $departments = array();
        $request = "SELECT * FROM department";
        $result = mysql_query($request);
        while($row = mysql_fetch_object($result)) {
            $department["id"] = $row->id;
            $department["name"] = $row->name;
            $department["parent"] = false;
            $departments[] = $department;
        }
        
        // create employee object
        $employee = new Employee();
        $employee->setDepartments($departments);
        
        // return employee object
        return $employee;
    }
    
    // ---------------------------------------- load employee
    function loadEmployee($id) {
        
        // name
        $request = "SELECT * FROM employee WHERE id = $id";
        $result = mysql_query($request);
        $row = mysql_fetch_object($result);
        
        $name = $row->name;
        $address = $row->address;
        $salary = $row->salary;
        $did = $row->did;
        
        $departments = array();
        $request = "SELECT * FROM department";
        $result = mysql_query($request);
        while($row = mysql_fetch_object($result)) {
            $department["id"] = $row->id;
            $department["name"] = $row->name;
            if ($row->id == $did) {
                $department["parent"] = true;
            } else {
                $department["parent"] = false;
            }
            $departments[] = $department;
        }
        
        // create employee object
        $employee = new Employee();
        $employee->setId($id);
        $employee->setName($name);
        $employee->setAddress($address);
        $employee->setSalary($salary);
        $employee->setDepartments($departments);
 
        // return employee object
        return $employee;
    }
    
    // ---------------------------------------- cut employee
    function cut($jsonObject) {
        $id = $jsonObject->id;
        
        $request = "UPDATE employee SET salary = salary / 2 WHERE id = " . $id;
        mysql_query($request);
        
        return loadEmployee($id);
    }
    
    // ---------------------------------------- delete employee
    function delete($jsonObject) {
        $id = $jsonObject->id;
        
        $request = "DELETE FROM employee WHERE id = " . $id;
        mysql_query($request);
        
        $status = new Errormessage();
        return $status;
    }
    
    // ---------------------------------------- save employee
    function saveEmployee($jsonObject) {
        $id = $jsonObject->id;
        $name = $jsonObject->name;
        $address = $jsonObject->address;
        $salary = $jsonObject->salary;
        $parent = $jsonObject->parent;
        
        // current employee
        $request = "SELECT * FROM employee WHERE id =" . $id;
        $result = mysql_query($request);
        $row = mysql_fetch_object($result);
        
        $manager = $row->manager;
        $lastParent = $row->did;
        
        if ($parent != $lastParent) {
            $manager = 0;
        }
        
        $minimumSalary = getMinimumSalaryForEmployee($parent, $manager);
        $maximumSalary = getMaximumSalaryForEmployee($parent, $manager);
        
        if ($minimumSalary > $salary || $maximumSalary < $salary) {
            $status = new Errormessage();
            $status->addFailure("salary", "Enter a valid (" . $minimumSalary . " to " . $maximumSalary . ") salary, please.");
            return $status;
        }
        
        $request = "UPDATE employee SET name = '" . $name .
                                    "', address = '" . $address .
                                    "', salary = '" . $salary .
                                    "', manager = " . $manager .
                                    ", did = " . $parent .
                                     " WHERE id = " . $id;
        mysql_query($request);
        
        $error = mysql_error();
        if ($error == '' || $error == null) {
            return loadEmployee($id);
        } else {
            $status = new Errormessage();
            $status->addFailure("nameaddress", "Duplicate entry for name and address.<br>Enter a unique name and address combination,<br> please.");
            return $status;
        }
    }
    
    // ---------------------------------------- create
    function create($jsonObject) {
        $name = $jsonObject->name;
        $address = $jsonObject->address;
        $salary = $jsonObject->salary;
        $parent = $jsonObject->parent;
        $manager = 0;

        $minimumSalary = getMinimumSalaryForEmployee($parent, $manager);
        $maximumSalary = getMaximumSalaryForEmployee($parent, $manager);
        
        if ($minimumSalary > $salary || $maximumSalary < $salary) {
            $status = new Errormessage();
            $status->addFailure("salary", "Enter a valid (" . $minimumSalary . " to " . $maximumSalary . ") salary, please.");
            return $status;
        }
        
        $request = "INSERT employee (name, address, salary, manager, cid, did) VALUES ('" . $name . "', '" . $address . "', " . $salary . ", " . $manager . ", 1, " . $parent . ")";
        mysql_query($request);
        
        $error = mysql_error();
        if ($error == '' || $error == null) {
            $request = "SELECT * FROM employee WHERE name = '" . $name . "'";
            $result = mysql_query($request);
            $row = mysql_fetch_object($result);
            return loadEmployee($row->id);
        } else {
            $status = new Errormessage();
            $status->addFailure("nameaddress", "Duplicate entry for name and address.<br>Enter a unique name and address combination,<br> please.");
            return $status;
        }
    }
    
?>
