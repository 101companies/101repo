<?php

    class Employee {
        public $name;
        public $address;
        public $salary;
        
        public function getName() {
            return $name;
        }
        
        public function getAddress() {
            return $address;
        }
        
        public function getSalary() {
            return $salary;
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
    }
?>
