<?php

class Application_Form_Employee extends Zend_Form
{

    public function init()
    {
        $this->setName('employee');
        $id = new Zend_Form_Element_Hidden('id');
        $id->addFilter('Int');
        $name = new Zend_Form_Element_Text('name');
        $name   ->setLabel('Name')
                ->setRequired(true)
                ->addFilter('StripTags')
                ->addFilter('StringTrim')
                ->addValidator('NotEmpty');
        
        $address = new Zend_Form_Element_Text('address');
        $address->setLabel('Address')
                ->setRequired(true)
                ->addFilter('StripTags')
                ->addFilter('StringTrim')
                ->addValidator('NotEmpty');
                
        $submit = new Zend_Form_Element_Submit('save');
        $submit->setAttrib('id', 'submitbutton');
        
        $salary = new Zend_Form_Element_Text('salary');
        $salary ->setLabel('Salary')
                ->setRequired(true)
                ->addFilter('StripTags')
                ->addFilter('StringTrim')
                ->addValidator('NotEmpty');
        
        $cut = new Zend_Form_Element_Submit('cut');
        $cut->setAttrib('id', 'submitbutton');
        
        $this->addElements(array($id, $name, $address, $salary, $submit));
        $this->addElements(array($cut));
    }


}

