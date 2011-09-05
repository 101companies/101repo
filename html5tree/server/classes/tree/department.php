<?php

    class Department {
        
        public $id;
        public $name;
        public $departments;
        public $employees;
        
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
    }
    
?>
