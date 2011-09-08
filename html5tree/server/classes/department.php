<?php

   class Department {
        
        public $id;
        public $name;
        public $departments;
        public $employees;
        public $manager;
        public $total;

        public function getId() {
            return $id;
        }
        
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
        
        public function setId($newId) {
            $this->id = $newId;
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