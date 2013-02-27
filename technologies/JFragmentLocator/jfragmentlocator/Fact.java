package jfragmentlocator;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author Martin
 */
public class Fact {
    List<Fragment> fragments = new ArrayList<Fragment>();
    
    public Fact(CompilationUnit unit) throws FileNotFoundException {
      
	//comments are currently disabled, since they are not easily accessable from the CompilationUnit
        //comment = extractTopComment(inputText);
        
        analyze(unit);
    }
    
    private void analyze(CompilationUnit unit) {
        for (TypeDeclaration decl : unit.getTypes()) {
            if (decl instanceof ClassOrInterfaceDeclaration) {
                fragments.add(new Fragment((ClassOrInterfaceDeclaration)decl));
            }
        }
    }
}
