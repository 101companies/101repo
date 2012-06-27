package jfactextractor;

import com.google.gson.annotations.SerializedName;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.ImportDeclaration;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.expr.AnnotationExpr;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author Martin Leinberger
 */
public class Fact {
    private class Declaration {
        @SerializedName("class")
        public String className;
        public List<String> methods;
        private Set<String> attributes;
        
        public Declaration() { }
        
        public Declaration(TypeDeclaration decl) {
            className = decl.getName();
            methods = new ArrayList<String>();
            attributes = new HashSet<String>();
            processAnnotations(decl);
            for (BodyDeclaration method : decl.getMembers()) {
                processAnnotations(method);
                if (method instanceof MethodDeclaration)
                    methods.add(((MethodDeclaration)method).getName());
            }
        }
 
         private void processAnnotations(BodyDeclaration decl) {
            if (decl.getAnnotations() != null)
                for (AnnotationExpr expr : decl.getAnnotations())
                    attributes.add(expr.getName().toString());
        }
        
        private void processAnnotations(TypeDeclaration decl) {
            if (decl.getAnnotations() != null)
                for (AnnotationExpr expr : decl.getAnnotations())
                    attributes.add(expr.getName().toString());
        }
    }
    
    private String comment = "";
    @SerializedName("package")
    private String packageName = "";
    @SerializedName("imports")
    private Set<String> imports;
    private List<Declaration> declarations;
    
    public Fact() { }
    
    public Fact(File file, CompilationUnit compilationUnit) throws FileNotFoundException {
        if (compilationUnit.getPackage() != null)
            packageName = compilationUnit.getPackage().getName().toString().replace("package", "");
        
        comment = extractTopComment(file);

        imports = new HashSet<String>();
        if (compilationUnit.getImports() != null)
            for (ImportDeclaration imp : compilationUnit.getImports()) {
                String str = imp.getName().toString();
                if (!imp.isAsterisk())
                    str = str.substring(0, str.lastIndexOf("."));
                imports.add(str);
            }
            
        declarations = new ArrayList<Declaration>();
        if (compilationUnit.getTypes() != null)
            for (TypeDeclaration decl : compilationUnit.getTypes()) {
                if (decl instanceof ClassOrInterfaceDeclaration)
                    declarations.add(new Declaration(decl));
            }
    }
    
    private String extractTopComment(File file) throws FileNotFoundException {
        StringBuffer buffer = new StringBuffer("");
        Scanner scanner = new Scanner(file);
        boolean blockComment = false;
        
        String str;
        do {
            str = scanner.nextLine();
            if (str.contains("/*"))
                blockComment = true;
            
            if (blockComment || str.startsWith("//"))
                buffer.append(str).append("\n");
            
            if (str.contains("*/"))
                blockComment = false;
            
            if (!blockComment && (str.matches("package .*;") || str.matches("(private|protected|public) class .* \\{")))
                return buffer.toString().trim();
        } while (true);
    }
}
