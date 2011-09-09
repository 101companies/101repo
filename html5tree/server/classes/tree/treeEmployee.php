<?php

    class Employee {
        
        public $id;
        public $name;
        public $manager;
        
        public function getId() {
            return $id;
        }
        
        public function getName() {
            return $name;
        }
        
        public function getManager() {
            return $manager;
        }
        
        public function setId($newId) {
            $this->id = $newId;
        }
        
        public function setName($newName) {
            $this->name=$newName;
        }
        
        public function setManager($newManager) {
            $this->manager=$newManager;
        }
    }
    
?>
