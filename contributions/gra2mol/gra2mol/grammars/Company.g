/**
  * 101 Companies grammar modified to consider mentors (Gra2MoL example)
  * Contributor: Javier Canovas (javier.canovas@inria.fr)
  */

grammar Company;

options {
  k = 1;
}

company :
  'company' STRING '{' department* '}' EOF;
  
department :
  'department' STRING '{' 
    department_manager
    department_employees
    department*
  '}';

department_manager :
  'manager' employee;

department_employees :
  ('employee' employee)* ;

employee :
  STRING '{'
    'address' STRING
    'salary' FLOAT
    ('mentor' STRING)?
  '}';

STRING  :   '"' (~'"')* '"';
FLOAT   :   ('0'..'9')+ ('.' ('0'..'9')+)?;
WS      :   (' '|'\r'? '\n'|'\t')+ {skip();};
