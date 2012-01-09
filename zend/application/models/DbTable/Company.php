<?php

class Application_Model_DbTable_Company extends Zend_Db_Table_Abstract
{

    protected $_name = 'company';
    
    public function cutCompany($id) {
        
    }
    
    public function getCompany($id) {
        $id = (int)$id;
        $row = $this->fetchRow('id = ' . $id);
        if (!$row) {
            throw new Exception("Could not find row $id");
        }
        return $row->toArray();
    }
    
    public function updateCompany($id, $name) { 
        try {
            $data = array(
                'name' => $name
            );
            $this->update($data, 'id = '. (int) $id);
        }
        catch (Exception $e) {
            echo $e->getMessage();
        }
    }
}

