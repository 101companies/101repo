package jfactextractor;

import com.google.gson.annotations.SerializedName;
import japa.parser.ast.Comment;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.ImportDeclaration;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Martin
 */
public class Fact {
    private class Declaration {
        @SerializedName("class")
        public String className;
        public List<String> methods;
        
        public Declaration() { }
        
        public Declaration(TypeDeclaration decl) {
            className = decl.getName();
            methods = new ArrayList<String>();
            for (BodyDeclaration method : decl.getMembers())
                if (method instanceof MethodDeclaration)
                    methods.add(((MethodDeclaration)method).getName());
        }
    }
    
    private String comment = "";
    @SerializedName("package")
    private String packageName;
    @SerializedName("imports")
    private Set<String> imports;
    private List<Declaration> declarations;
    
    public Fact() { }
    
    public Fact(CompilationUnit compilationUnit) {
        for (Comment c : compilationUnit.getComments())
            if (c.getBeginLine() < compilationUnit.getPackage().getBeginLine())
                comment += c.getContent();
        
        packageName = compilationUnit.getPackage().getName().toString().replace("package", "");
        
        imports = new HashSet<String>();
        for (ImportDeclaration imp : compilationUnit.getImports()) {
            String str = imp.getName().toString();
            if (!imp.isAsterisk())
                str = str.substring(0, str.lastIndexOf("."));
            imports.add(str);
        }
            
        declarations = new ArrayList<Declaration>();
        for (TypeDeclaration decl : compilationUnit.getTypes()) {
            declarations.add(new Declaration(decl));
        }
    }
}
