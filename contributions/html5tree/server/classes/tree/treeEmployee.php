<?php

    class Employee {
        
        public $id;
        public $name;
        public $manager;
        public $inconsistent = false;
        public $message;
        
        public function getId() {
            return $id;
        }
        
        public function getName() {
            return $name;
        }
        
        public function getManager() {
            return $manager;
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
        
        public function setName($newName) {
            $this->name=$newName;
        }
        
        public function setManager($newManager) {
            $this->manager=$newManager;
        }
        
        public function setInconsistent($inc) {
            $this->inconsistent=$inc;
        }
        
        public function setMessage($mess) {
            $this->message=$mess;
        }
    }
    
?>
