<?php

class Application_Model_DbTable_Employee extends Zend_Db_Table_Abstract
{

    protected $_name = 'employee';
    
    public function getEmployee($id) {
        $id = (int)$id;
        $row = $this->fetchRow('id = ' . $id);
        if (!$row) {
            throw new Exception("Could not find row $id");
        }
        return $row->toArray();
    }
    
    public function getEmployeesForDepartment($id) {
        $id = (int)$id;
        $rows = $this->fetchAll('did = ' . $id);
        return $rows->toArray();
    }
    
    public function getTotalForCompany($id) {
        $id = (int)$id;
        $rows = $this->fetchAll('cid = ' . $id);
        $total = 0;
        foreach ($rows as $row) {
            $total += $row->salary;
        }
        return $total;
    }
    
        public function getTotalForDepartment($id) {
        $id = (int)$id;
        $rows = $this->fetchAll('did = ' . $id);
        $total = 0;
        foreach ($rows as $row) {
            $total += $row->salary;
        }
        $department = new Application_Model_DbTable_Department();
        $subdepartments = $department->getDepartmentsForDepartment($id);
        foreach ($subdepartments as $dep) {
            $depId = $dep[id];
            $total += $this->getTotalForDepartment($depId);
        }
        return $total;
    }
    
    public function cutCompany($id) {
        $this->_db->query("UPDATE employee SET salary = salary / 2 WHERE cid = " .$id);
    }
    
    public function cutDepartment($id) {
        $id = (int)$id;
        
        $this->_db->query("UPDATE employee SET salary = salary / 2 WHERE did = " .$id);

        $department = new Application_Model_DbTable_Department();
        $subdepartments = $department->getDepartmentsForDepartment($id);
        foreach ($subdepartments as $dep) {
            $depId = $dep[id];
            $this->cutDepartment($depId);
        }
    }
    
    public function cutEmployee($id) {
        $id = (int)$id;
        $this->_db->query("UPDATE employee SET salary = salary / 2 WHERE id = " .$id);
    }
    
    public function updateEmployee($id, $name, $address, $salary) {
        $data = array(
            'name' => $name,
            'address' => $address,
            'salary' => $salary
        );
        $this->update($data, 'id = '. (int) $id);
    }
    
    public function getManagerForDepartment($id) {
        $id = (int)$id;
        $row = $this->fetchRow('did = ' . $id . ' AND manager = 1');
        return $row->toArray();
    }
}

