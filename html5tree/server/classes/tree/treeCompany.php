<?php

    class Company {
        
        public $id;
        public $name;
        public $departments;
        
        public function getId() {
            return $id;
        }
        
        public function getDepartments() {
            return $departments;
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
        
        public function setName($newName) {
            $this->name=$newName;
        }
    }
    
?>
