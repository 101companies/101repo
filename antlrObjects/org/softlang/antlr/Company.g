grammar Company;

options {
  k = 1;
}

@header {
package org.softlang.antlr;
import org.softlang.company.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
}

@lexer::header {
package org.softlang.antlr;
}

@members {
public static Company parse(String s) throws IOException, RecognitionException {
    FileInputStream stream = new FileInputStream("inputs" + File.separatorChar + s);
    ANTLRInputStream antlr = new ANTLRInputStream(stream);
    CompanyLexer lexer = new CompanyLexer(antlr);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    CompanyParser parser = new CompanyParser(tokens);
    Company c = parser.company();
    if (parser.error) throw new RecognitionException();
    return c;
}

// Throw if any error was emitted
public boolean error = false;

@Override
public void emitErrorMessage(String msg) 
{
  error = true;
  super.emitErrorMessage(msg);
}
}

company returns [Company c]:
  { $c = new Company(); }
  'company' STRING
  { $c.setName($STRING.text); }
  '{' 
  ( topdept=dept
    { $c.getDepts().add($topdept.d); }
  )* 
  '}'
  ;
  
dept returns [Department d]:
  { $d = new Department(); }
  'department' name=STRING
  { $d.setName($STRING.text); } 
  '{'
    'manager' m=employee
    { $d.setManager($m.e); }
    ( 'employee' e=employee
      { $d.getEmployees().add($e.e); }
    )*
    ( sub=dept
      { $d.getSubdepts().add($sub.d); }
    )*
  '}'
  ;
    
employee returns [Employee e]:
  n=STRING '{'
    'address' a=STRING
    'salary' s=FLOAT
  '}'
  {
    $e = new Employee();
    e.setName($n.text);
    e.setAddress($a.text);
    $e.setSalary(Double.parseDouble($s.text));
  }
  ;

WS      :   (' '|'\r'? '\n'|'\t')+ {skip();};
STRING  :   '"' (~'"')* '"';
FLOAT   :   ('0'..'9')+ ('.' ('0'..'9')+)?;
