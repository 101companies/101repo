<?php

    include("databaseConnection/connection.php");
    include("classes/tree/company.php");
    include("classes/tree/department.php");
    include("classes/tree/employee.php");
    
    startServer($HTTP_RAW_POST_DATA);
    
    // ---------------------------------------- perform request
    function perform($jsonObject) {
        $action = $jsonObject->action;
	
        switch ($action) {
            case "load":
                return loadCompany($jsonObject);
        }
    }
    
    function loadCompany($jsonObject) {
        $id = $jsonObject->id;
        
        // name
        $request = "SELECT * FROM company WHERE id = $id";
        $result = mysql_query($request);
        $row = mysql_fetch_object($result);
        
        // create company object
        $company = new Company();
        $company->setId($row->id);
        $company->setName($row->name);
        
        // departments
        $company->setDepartments(loadDepartmentsForCompany($id));
        
        // return company object
        return $company;
    }
    
    function loadDepartmentsForCompany($id) {
        $request = "SELECT * FROM department WHERE cid = $id";
        $result = mysql_query($request);
        $row = mysql_fetch_object($result);
        
        // departments
        $departments = array();
        $request = "SELECT * FROM department WHERE cid = $id AND did IS NULL";
        $result = mysql_query($request);
        $count = mysql_num_rows($result);
        while($row = mysql_fetch_object($result)) {
            $department = new Department();
            $department->setId($row->id);
            $department->setName($row->name);
            $department->setDepartments(loadDepartments($id, $row->id));
            $department->setEmployees(loadEmployees($id, $row->id));
            $departments[] = $department;
        }
        return $departments;
    }
    
    function loadDepartments($cid, $id) {
        // subdepartments
        $departments = array();
        $request = "SELECT * FROM department WHERE cid = $cid and did = $id";
        $result = mysql_query($request);
        $count = mysql_num_rows($result);
        while($row = mysql_fetch_object($result)) {
            $department = new Department();
            $department->setId($row->id);
            $department->setName($row->name);
            $department->setDepartments(loadDepartments($cid, $row->id));
            $department->setEmployees(loadEmployees($cid, $row->id));
            $departments[] = $department;
        }
        return $departments;
    }
    
    function loadEmployees($cid, $id) {
        // employees
        $employees = array();
        $request = "SELECT * FROM employee WHERE did = $id";
        $result = mysql_query($request);
        $count = mysql_num_rows($result);
        while($row = mysql_fetch_object($result)) {
            $employee = new Employee();
            $employee->setId($row->id);
            $employee->setName($row->name);
            $employee->setManager($row->manager);
            $employees[] = $employee;
        }
        return $employees;
    }
    
?>
