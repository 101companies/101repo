<?php

    include("databaseConnection/connection.php");
    include("employeeSupportFunctions.php");
    include("classes/tree/treeCompany.php");
    include("classes/tree/treeDepartment.php");
    include("classes/tree/treeEmployee.php");
    
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
        $departments = loadDepartments($id, -1);
        return $departments;
    }
    
    function loadDepartments($cid, $id) {
        // subdepartments
        $departments = array();
        if ($id == -1) {
            $request = "SELECT * FROM department WHERE cid = $cid AND did IS NULL";
        } else {
           $request = "SELECT * FROM department WHERE cid = $cid and did = $id";
        }
        $result = mysql_query($request);
        $count = mysql_num_rows($result);
        while($row = mysql_fetch_object($result)) {
            $department = new Department();
            $department->setId($row->id);
            $department->setName($row->name);
            $department->setDepartments(loadDepartments($cid, $row->id));
            $employees = loadEmployees($cid, $row->id);
            $department->setEmployees($employees);
            $inconsistent = containsManager($employees);
            
            if ($inconsistent == true) {
                $department->setInconsistent(true);
                $department->setMessage("No Manager!");
            }
            
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
            $maximumSalary = getMaximumSalaryForEmployee($row->did, $row->manager);
        
            $employee = new Employee();
            if ($row->salary > $maximumSalary) {
                $employee->setInconsistent(true);
                $employee->setMessage("Salary > $maximumSalary");
            }
            $employee->setId($row->id);
            $employee->setName($row->name);
            $employee->setManager($row->manager);
            $employees[] = $employee;
        }
        return $employees;
    }
    
    function containsManager($employees) {
        $contains = true;
        for ($i = 0; $i < count($employees); $i++) {
            $isManager = $employees[$i]->manager;
            if ($isManager == 1) {
                $contains = false;
            }
        }
        return $contains;
    }
    
?>
