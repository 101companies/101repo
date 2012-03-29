<?php

    class Company {
        
        public $id;
        public $name;
        public $total;
        
        public function getId() {
            return $id;
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
        
        public function setName($newName) {
            $this->name=$newName;
        }
        
        public function setTotal($newTotal) {
            $this->total = $newTotal;
        }
    }
    
?>
