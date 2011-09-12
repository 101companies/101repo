<?php

    class Errormessage {
        
        public $error = false;
        public $failures = array();
        
        public function addFailure($key, $failure) {
            $this->error = true;
            $this->failures[$key] = $failure;
        }
    }
    
?>