<?php

   class Department {
        
        public $name;
        public $departments;
        public $employees;
        public $manager;
        public $total;
        
        public function getDepartments() {
            return $departments;
        }
        
        public function getEmployees() {
            return $employees;
        }
        
        public function getManager() {
            return $manager;
        }
        
        public function getName() {
            return $name;
        }
        
        public function getTotal() {
            return $total;
        }
        
        public function setDepartments($newDepartments) {
            $this->departments=$newDepartments;
        }
        
        public function setEmployees($newEmployees) {
            $this->employees=$newEmployees;
        }
        
        public function setManager($manager) {
            $this->manager=$manager;
        }
        
        public function setName($newName) {
            $this->name=$newName;
        }
        
        public function setTotal($newTotal) {
            $this->total=$newTotal;
        }
    }
    
?>