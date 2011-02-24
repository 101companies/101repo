grammar Company;

@header {
package org.softlang.antlr;
import org.softlang.company.*;
}
@lexer::header {
package org.softlang.antlr;
}

company returns [Company c]:
  { $c = new Company(); }
  'company' '{' 
  ( topdept=dept
    { $c.getDepts().add($topdept.d); }
  )* 
  '}'
  ;
  
dept returns [Dept d]:
  { $d = new Dept(); }
  'department' name=STRING '{'
    { $d.setName($STRING.text); } 
    manager
    { $d.setManager($manager.e); }
    ( personunit
      {
        Subunit pu = new Subunit();
        pu.setPu($personunit.e);
        $d.getSubunits().add(pu); 
      }
    )*
    ( subdept=dept
      {
        Subunit du = new Subunit();
        du.setDu($subdept.d);
        $d.getSubunits().add(du); 
      }
    )*
  '}'
  ;
  
manager returns [Employee e]:
  'manager' employee
  { $e = $employee.e; }
  ;
  
personunit returns [Employee e]:
  'employee' employee
  { $e = $employee.e; }
  ; 
  
employee returns [Employee e]:
  n=STRING '{'
    'address' a=STRING
    'salary' s=FLOAT
  '}'
  {
    $e = new Employee();
    Person p = new Person();
    p.setName($n.text);
    p.setAddress($a.text);
    $e.setPerson(p);
    $e.setSalary(Double.parseDouble($s.text));
  }
  ;

WS      :   (' '|'\r'? '\n'|'\t')+ {skip();};
STRING  :   '"' (~'"')* '"';
FLOAT   :   ('0'..'9')+ ('.' ('0'..'9')+)?;
