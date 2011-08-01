<?php

    include("databaseConnection/connection.php");
    include("classes/department.php");
    include("classes/statusMessages.php");
    
    startServer($HTTP_RAW_POST_DATA);
    
    // ---------------------------------------- perform request
    function perform($jsonObject) {
        $action = $jsonObject->action;
	
        switch ($action) {
            case "load":
                return loadDepartment($jsonObject);
            
            case "save":
                return saveName($jsonObject);
            
            case "cut":
                return cut($jsonObject);
            
            case "selectDepartment":
                return getDepartmentId($jsonObject);
                
            case "selectEmployee":
                return getEmployeeId($jsonObject);
        }
    }
    
    // ---------------------------------------- load department
    function loadDepartment($jsonObject) {
        $id = $jsonObject->id;
        
        // name
        $request = "SELECT * FROM department WHERE id = $id";
        $result = mysql_query($request);
        $row = mysql_fetch_object($result);
        
        $name = $row->name;
        
        // departments
        $departments = array();
        $request = "SELECT * FROM department WHERE did = $id";
        $result = mysql_query($request);
        $count = mysql_num_rows($result);
        while($row = mysql_fetch_object($result)) {
            $departments[] = $row->name;
        }
        
        // employees
        $employees = array();
        $request = "SELECT * FROM employee WHERE did = $id";
        $result = mysql_query($request);
        $count = mysql_num_rows($result);
        while($row = mysql_fetch_object($result)) {
            if ($row->manager == true) {
                $manager = $row->name;
            } else {
                $employees[] = $row->name;
            }
        }
        
        // total
        $total = totalDepartment($id);
        
        // create department object
        $department = new Department();
        $department->setDepartments($departments);
        $department->setEmployees($employees);
        $department->setManager($manager);
        $department->setName($name);
        $department->setTotal($total);
        
        // return department object
        return $department;
    }

    // total of a department and its subdepartments
    function totalDepartment($id) {
        $total = 0;
        $request = "SELECT * FROM department WHERE did = $id";
        $result = mysql_query($request);
        while ($row = mysql_fetch_object($result)) {
            $total += totalDepartment("$row->id");
        }
        $request = "SELECT * FROM employee WHERE did = $id";
        $result = mysql_query($request);
        while ($row = mysql_fetch_object($result)) {
            $total += "$row->salary";
        }
        return $total;
    }
    
    // ---------------------------------------- save name
    function saveName($jsonObject) {
        $name = $jsonObject->newName;
        $id = $jsonObject->id;
        
        $request = "UPDATE department SET name = '" . $name . "' WHERE id = " . $id;
	mysql_query($request);
        
        if (mysql_error() == '') {
            return loadDepartment($jsonObject);
        } else {
            $status = new Errormessage();
            $status->addFailure("name", "The name '" . $name . "' is in use.<br> Enter a valid name, please.");
            return $status;
        }
    }
    
    
    // ---------------------------------------- cut department
    function cut($jsonObject) {
        $id = $jsonObject->id;
        
        cutDepartment($id);
        
        return loadDepartment($jsonObject);
    }
    
    function cutDepartment($id) {
        $request = "SELECT * FROM department WHERE did = ". $id;
        $result = mysql_query($request);
        while ($row = mysql_fetch_object($result)) {
            cutDepartment($row->id);
        }
        $request = "UPDATE employee SET salary = salary / 2 WHERE did = " . $id;
        mysql_query($request);
    }
    
    // ---------------------------------------- select department
    function getDepartmentId($jsonObject) {
        $name = $jsonObject->departmentName;
        $table = "department";
		
        $request = "SELECT id FROM $table WHERE name = \"$name\"";
        $result = mysql_query($request);
        $row = mysql_fetch_object($result);
        $id = $row->id;
        
        $status = new DepartmentResponse();
        $status->setDepartmentId($id);
        
        return $status;
    }
    
        // ---------------------------------------- select employee
    function getEmployeeId($jsonObject) {
        $name = $jsonObject->departmentName;
        $table = "employee";
		
        $request = "SELECT id FROM $table WHERE name = \"$name\"";
        $result = mysql_query($request);
        $row = mysql_fetch_object($result);
        $id = $row->id;
        
        $status = new EmployeeResponse();
        $status->setEmployeeId($id);
        
        return $status;
    }

?>
