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
                return loadDepartment($jsonObject->id);
                
            case "blank":
                return loadBlank();
            
            case "save":
                return saveName($jsonObject);
            
            case "create":
                return create($jsonObject);
                
            case "cut":
                return cut($jsonObject);
       
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
        
        // employees
        $employees = array();
        $request = "SELECT * FROM employee";
        $result = mysql_query($request);
        while($row = mysql_fetch_object($result)) {
            $employee = array();
            $employee["id"] = $row->id;
            $employee["name"] = $row->name;
            $employee["manager"] = false;
            $employees[] = $employee;
        }
        
        // create department object
        $department = new Department();
        $department->setId(null);
        $department->setDepartments($departments);
        $department->setEmployees($employees);
        $department->setName(null);
        $department->setTotal(0);
        
        // return department object
        return $department;
    }
    
    // ---------------------------------------- load department
    function loadDepartment($id) {
        // name
        $request = "SELECT * FROM department WHERE id = " . $id;
        $result = mysql_query($request);
        $row = mysql_fetch_object($result);
        
        $name = $row->name;
        $parent = $row->did;
        
        // departments
        $unselectable = unselectable($id);
        $departments = array();
        $request = "SELECT * FROM department WHERE id NOT IN (" . $unselectable . ")";
        $result = mysql_query($request);
        while($row = mysql_fetch_object($result)) {
            $department["id"] = $row->id;
            $department["name"] = $row->name;
            if ($row->id == $parent) {
                $department["parent"] = true;
            } else {
                $department["parent"] = false;
            }
            $departments[] = $department;
        }
        
        // employees
        $employees = array();
        $request = "SELECT * FROM employee";
        $result = mysql_query($request);
        while($row = mysql_fetch_object($result)) {
            $employee = array();
            $employee["id"] = $row->id;
            $employee["name"] = $row->name;
            if ($row->manager == true && $row->did == $id) {
                $employee["manager"] = true;
            } else {
                $employee["manager"] = false;
            }
            $employees[] = $employee;
        }
        
        // total
        $total = totalDepartment($id);
        
        // create department object
        $department = new Department();
        $department->setId($id);
        $department->setDepartments($departments);
        $department->setEmployees($employees);
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
    
    // ---------------------------------------- unselectable departments
    function unselectable($id) {
        $unselectableDeps = $id;
        $request = "SELECT * FROM department WHERE did = $id";
        $result = mysql_query($request);
        while ($row = mysql_fetch_object($result)) {
            $unselectableDeps = $unselectableDeps . ", " . unselectable("$row->id");
        }
        return $unselectableDeps;
    }
    
    // ---------------------------------------- save name
    function saveName($jsonObject) {
        $name = $jsonObject->name;
        $id = $jsonObject->id;
        $manager = $jsonObject->manager;
        $parent = $jsonObject->parent;

        $request = "UPDATE department SET name = '" . $name . "', did = " . $parent . " WHERE id = " . $id;
        mysql_query($request);
        
        if (mysql_error() == '') {
            $request = "UPDATE employee SET manager = 0 WHERE did = " .$id;
            mysql_query($request);
            
            if ($manager != null) {
                $request = "UPDATE employee SET did = " . $id . ", manager = 1 WHERE id = " . $manager;
                mysql_query($request);
            }
        
            return loadDepartment($id);
        } else {
            $status = new Errormessage();
            $status->addFailure("name", "The name '" . $name . "' is in use.<br> Enter a valid name, please.");
            return $status;
        }
    }
    
    // ---------------------------------------- create
    function create($jsonObject) {
        $name = $jsonObject->name;
        $manager = $jsonObject->manager;
        $parent = $jsonObject->parent;

        $request = "INSERT INTO department (name, cid, did) VALUES ('" . $name . "', 1, " . $parent . ")";
        mysql_query($request);       
        
        if (mysql_error() == '') {
            $request = "SELECT * FROM department WHERE name = '" . $name . "'";
            mysql_query($request);
            $result = mysql_query($request);
            $row = mysql_fetch_object($result);

            $id = $row->id;
                
            if ($manager != null) {
                $request = "UPDATE employee SET did = " . $id . ", manager = 1 WHERE id = " . $manager;
                mysql_query($request);
            }
        
            return loadDepartment($id);
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

?>
