<?php

    class Company {
        
        public $name;
        public $departments;
        public $total;
        
        public function getDepartments() {
            return $departments;
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
        
        public function setName($newName) {
            $this->name=$newName;
        }
        
        public function setTotal($newTotal) {
            $this->total=$newTotal;
        }
    }
    
?>
