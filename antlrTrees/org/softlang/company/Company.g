grammar Company;

options { 
  output = AST;
  k = 1;
}

tokens { COMPANY; DEPT; MANAGER; EMPLOYEE; }

@header {
package org.softlang.company;

import java.io.IOException;
import java.io.FileInputStream;
}

@lexer::header {
package org.softlang.company;
}

@members {

// Throw if any error was emitted
public boolean error = false;

@Override
public void emitErrorMessage(String msg) 
{
  error = true;
  super.emitErrorMessage(msg);
}

public static company_return parse(String s) throws IOException, RecognitionException {
    FileInputStream stream = new FileInputStream(s);
    ANTLRInputStream antlr = new ANTLRInputStream(stream);
    CompanyLexer lexer = new CompanyLexer(antlr);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    CompanyParser parser = new CompanyParser(tokens);
    company_return r = parser.company();
    if (parser.error) throw new RecognitionException();
    return r;
}
}

company :
  'company' STRING '{' department* '}'
  -> ^(COMPANY STRING department*)
  ;
  
department :
  'department' name=STRING '{' 
    manager
    ('employee' employee)*
    department*
  '}'
  -> ^(DEPT $name manager employee* department*)
  ;
    
manager : 
  'manager' employee 
  -> ^(MANAGER employee)
  ;   
    
employee :
  n=STRING '{'
    'address' a=STRING
    'salary' s=FLOAT
  '}'
  -> ^(EMPLOYEE $n $a $s)
  ;

STRING  :   '"' (~'"')* '"';
FLOAT   :   ('0'..'9')+ ('.' ('0'..'9')+)?;
WS      :   (' '|'\r'? '\n'|'\t')+ {skip();};
