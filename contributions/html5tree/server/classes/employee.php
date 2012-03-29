<?php

    class Employee {
        
        public $id;
        public $name;
        public $address;
        public $salary;
        public $departments;
        
        public function getId() {
            return $id;
        }
        
        public function getName() {
            return $name;
        }
        
        public function getAddress() {
            return $address;
        }
        
        public function getSalary() {
            return $salary;
        }
        
        public function getDepartments() {
            return $departments;
        }
        
        public function setId($newId) {
            $this->id = $newId;
        }
        
        public function setName($name) {
            $this->name = $name;
        }
        
        public function setAddress($address) {
            $this->address = $address;
        }
        
        public function setSalary($salary) {
            $this->salary = $salary;
        }
        
        public function setDepartments($newDepartments) {
            $this->departments=$newDepartments;
        }
    }
?>
