<?php

class Application_Form_Department extends Zend_Form
{
    
    var $departmentList;
    var $employeeList;
    
    public function init()
    {
        $this->setName('company');
        $id = new Zend_Form_Element_Hidden('id');
        $id->addFilter('Int');
        $name = new Zend_Form_Element_Text('name');
        $name   ->setLabel('Name')
                ->setRequired(true)
                ->addFilter('StripTags')
                ->addFilter('StringTrim')
                ->addValidator('NotEmpty');
                        
        $submit = new Zend_Form_Element_Submit('save');
        $submit->setAttrib('id', 'submitbutton');
        
        $manager = new Zend_Form_Element_Text('manager', array('readonly' => 'readonly'));
        $manager->setLabel('Manager');
        
        $managerId = new Zend_Form_Element_Hidden('managerId');
        $managerId->addFilter('Int');
        
        $edit = new Zend_Form_Element_Submit('edit');
        $edit->setAttrib('id', 'submitbutton');
        
        $this->departmentList = new Zend_Form_Element_Select('departments');
        $this->departmentList ->setLabel('Departments');
        $this->departmentList->setRegisterInArrayValidator(false);
        
        $selectDepartment = new Zend_Form_Element_Submit('selectDepartment');
        $selectDepartment   ->setAttrib('id', 'submitbutton')
                            ->setLabel('select');
        
        $this->employeeList = new Zend_Form_Element_Select('employees');
        $this->employeeList ->setLabel('Employees');
        $this->employeeList->setRegisterInArrayValidator(false);
        
        $selectEmployee = new Zend_Form_Element_Submit('selectEmployee');
        $selectEmployee ->setAttrib('id', 'submitbutton')
                        ->setLabel('select');
        
        $total = new Zend_Form_Element_Text('total', array("readonly" => "readonly"));
        $total  ->setLabel('Total');
        
        $cut = new Zend_Form_Element_Submit('cut');
        $cut->setAttrib('id', 'submitbutton');
        
        $back = new Zend_Form_Element_Submit('back');
        $back->setAttrib('id', 'submitbutton');

        $this->addElements(array($id, $name, $submit));
        $this->addElements(array($managerId, $manager, $edit));
        $this->addElements(array($this->departmentList, $selectDepartment));
        $this->addElements(array($this->employeeList, $selectEmployee));
        $this->addElements(array($total, $cut));
        $this->addElements(array($back));
    }
    
    public function fillLists($id) {
        $department = new Application_Model_DbTable_Department();
        $departments = $department->getDepartmentsForDepartment($id);
        
        foreach($departments as $dep) {
            $this->departmentList->addMultiOption($dep[id], $dep[name]);
        }
        
        $employee = new Application_Model_DbTable_Employee();
        $employees = $employee->getEmployeesForDepartment($id);
        
        foreach($employees as $emp) {
            if ($emp[manager] == 0) {
                $this->employeeList->addMultiOption($emp[id], $emp[name]);
            }
        }
    }


}

