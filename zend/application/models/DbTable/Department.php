<?php

class Application_Model_DbTable_Department extends Zend_Db_Table_Abstract
{

    protected $_name = 'department';

    public function getDepartmentsForCompany($id) {
        $id = (int)$id;
        $rows = $this->fetchAll('cid = ' . $id . ' AND did IS NULL');
        return $rows->toArray();
    }
    
    public function getDepartmentsForDepartment($id) {
        $id = (int)$id;
        $rows = $this->fetchAll('did = ' . $id);
        return $rows->toArray();
    }
    
    public function getDepartment($id) {
        $id = (int)$id;
        $row = $this->fetchRow('id = ' . $id);
        if (!$row) {
            throw new Exception("Could not find row $id");
        }
        return $row->toArray();
    }
    
    public function updateDepartment($id, $name) {
        try {
            $data = array(
                'name' => $name
            );
            $this->update($data, 'id = '. (int) $id);
            return "";
        }
        catch (Exception $e) {
            return "Duplicate entry for " . $name . ". Enter a valid name, please.";
        }
    }
}

