<?php

class Application_Form_Company extends Zend_Form
{

    var $departmentList;
    
    public function init()
    {
        $this->setName('company');
        $id = new Zend_Form_Element_Hidden('id');
        $id->addFilter('Int');
        $name = new Zend_Form_Element_Text('name');
        $name ->setLabel('Name')
                ->setRequired(true)
                ->addFilter('StripTags')
                ->addFilter('StringTrim')
                ->addValidator('NotEmpty');
        
        $submit = new Zend_Form_Element_Submit('save');
        $submit ->setAttrib('id', 'submitbutton')
                ->setOptions(array('class' => 'button'));
        
        $this->departmentList = new Zend_Form_Element_Select('departments');
        $this->departmentList ->setLabel('Departments');
        $this->departmentList->setRegisterInArrayValidator(false);
        
        $select = new Zend_Form_Element_Submit('select');
        $select ->setAttrib('id', 'submitbutton');
        
        $total = new Zend_Form_Element_Text('total', array("readonly" => "readonly"));
        $total  ->setLabel('Total');
        
        $cut = new Zend_Form_Element_Submit('cut');
        $cut->setAttrib('id', 'submitbutton');

        $this->addElements(array($id, $name, $submit));
        $this->addElements(array($this->departmentList, $select));
        $this->addElements(array($total, $cut));
    }

    public function fillLists($id) {
        $department = new Application_Model_DbTable_Department();
        $departments = $department->getDepartmentsForCompany(1);
        
        foreach($departments as $dep) {
            $this->departmentList->addMultiOption($dep[id], $dep[name]);
        }
    }
}
?>
