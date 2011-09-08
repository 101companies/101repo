<?php

    class Errormessage {
        
        public $error = false;
        public $failures = array();
        
        public function addFailure($key, $failure) {
            $this->error = true;
            $this->failures[$key] = $failure;
        }
    }
    
    class DepartmentResponse {
        public $departmentId;
        public $resp = "department";
        
        public function setDepartmentId($id) {
            $this->departmentId=$id;
        }
    }
    
    class EmployeeResponse {
        public $employeeId;
        public $resp = "employee";
        
        public function setEmployeeId($id) {
            $this->employeeId=$id;
        }
    }
    
?>