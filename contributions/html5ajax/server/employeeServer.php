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
        
        $minimumSalary = getMinimumSalaryForEmployee($id);
        $maximumSalary = getMaximumSalaryForEmployee($id);
        
        if ($minimumSalary > $salary || $maximumSalary < $salary) {
            $status = new Errormessage();
            $status->addFailure("salary", "Enter a valid (" . $minimumSalary . " to " . $maximumSalary . ") salary, please.");
            return $status;
        }
        
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
            $status->addFailure("nameaddress", "Duplicate entry for name and address.<br>Enter a unique name and address combination,<br> please.");
            return $status;
        }
    }
    
    // determines the minimum value for the employee salary
    function getMinimumSalaryForEmployee($id) {
        // current employee
        $request = "SELECT * FROM employee WHERE id =" . $id;
        $result = mysql_query($request);
        $row = mysql_fetch_object($result);
        
        $manager = $row->manager;
        $departmentId = $row->did;
        
        // min value = 0, if there is no inferior employee
        $minValue = 0;
        
        if ($manager == 1) {
            $request = "SELECT * FROM employee WHERE did = " . $departmentId;
            $result = mysql_query($request);
            while($row = mysql_fetch_object($result)) {
                if ($row->manager == 0 && $row->salary > $minValue) {
                    $minValue = $row->salary;
                }
            }
        }
        
        // employees of subdepartments
        $request = "SELECT * FROM employee WHERE did IN (SELECT id FROM department WHERE did =" . $departmentId . ")";
        $result = mysql_query($request);
        while($row = mysql_fetch_object($result)) {
            $salary = $row->salary;
            if ($salary > $minValue) {
                $minValue = $salary;
            }
        }
        
        return $minValue;
    }
    
    function getMaximumSalaryForEmployee($id) {
        $request = "SELECT * FROM employee WHERE id =" . $id;
        $result = mysql_query($request);
        $row = mysql_fetch_object($result);
        
        $departmentId = $row->did;
        $manager = $row->manager;

        // max value = 2000000, if there is no superior employee
        $maxValue = 2000000;
        
        if ($manager == 0) {
            $request = "SELECT * FROM employee WHERE did = " . $departmentId . " AND manager = 1";
            $result = mysql_query($request);
            $row = mysql_fetch_object($result);
            
            $maxValue = $row->salary;
        }
        
        // superior department
        $request = "SELECT * FROM department WHERE id = (SELECT did FROM department WHERE id = " . $departmentId . ")";
        $result = mysql_query($request);
        if ($result != null && mysql_num_rows($result) > 0) {
            $row = mysql_fetch_object($result);
            $superiorDepId = $row->id;
            $request2 = "SELECT * FROM employee WHERE did = " . $superiorDepId;
            $result2 = mysql_query($request2);
            while($row2 = mysql_fetch_object($result2)) {
                $salary = $row2->salary;
                if ($salary < $maxValue) {
                    $maxValue = $salary;
                }
            }
        }
        
        return $maxValue;        
    }
    
?>
