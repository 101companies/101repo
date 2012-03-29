<?php

    class Department {
        
        public $id;
        public $name;
        public $departments;
        public $employees;
        public $inconsistent = false;
        public $message;
        
        public function getId() {
            return $id;
        }
        
        public function getDepartments() {
            return $departments;
        }
        
        public function getEmployees() {
            return $employees;
        }
        
        public function getName() {
            return $name;
        }
        
        public function isInconsistent() {
            return $inconsistent;
        }
        
        public function getMessage() {
            return $message;
        }
        
        public function setId($newId) {
            $this->id = $newId;
        }
        
        public function setDepartments($newDepartments) {
            $this->departments=$newDepartments;
        }
        
        public function setEmployees($newEmployees) {
            $this->employees=$newEmployees;
        }
        
        public function setName($newName) {
            $this->name=$newName;
        }
        
        public function setInconsistent($inc) {
            $this->inconsistent=$inc;
        }
        
        public function setMessage($mess) {
            $this->message=$mess;
        }
    }
    
?>
