package jfragmentlocator;

import japa.parser.ast.Node;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.expr.AnnotationExpr;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin
 */
public class Fragment {
    private Node astNode;
    private String classifier;
    private String name;
    private List<Fragment> fragments;
    private List<String> annotations = new ArrayList<String>();;
    
    public Fragment(ClassOrInterfaceDeclaration declaration) {
        astNode = declaration;
        
        classifier = "class";
        name = declaration.getName();
        fragments = new ArrayList<Fragment>();
        
        if (declaration.getAnnotations() != null)
                for (AnnotationExpr expr : declaration.getAnnotations())
                    annotations.add(expr.getName().toString());
        
        for (BodyDeclaration decl : declaration.getMembers()) {
            if (decl instanceof ClassOrInterfaceDeclaration)
                fragments.add(new Fragment((ClassOrInterfaceDeclaration)decl));
            
            if (decl instanceof MethodDeclaration)
                fragments.add(new Fragment((MethodDeclaration) decl));
            
            if (decl instanceof ConstructorDeclaration)
                fragments.add(new Fragment((ConstructorDeclaration)decl));
        } 
    }
    
    public Fragment(MethodDeclaration declaration) {
        astNode = declaration;
        
        classifier = "method";
        name = declaration.getName();
        fragments = null;
        
        if (declaration.getAnnotations() != null)
                for (AnnotationExpr expr : declaration.getAnnotations())
                    annotations.add(expr.getName().toString());
    }
    
    public Fragment(ConstructorDeclaration declaration) {
        astNode = declaration;
                
        classifier = "method";
        name = declaration.getName();
        fragments = null;
        
        if (declaration.getAnnotations() != null)
                for (AnnotationExpr expr : declaration.getAnnotations())
                    annotations.add(expr.getName().toString());
    }

    public Node getAstNode() {
        return astNode;
    }

    public String getClassifier() {
        return classifier;
    }

    public List<Fragment> getFragments() {
        return fragments;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        
        if (obj instanceof Query.QueryPart) {
            final Query.QueryPart other = (Query.QueryPart)obj;
            if (!this.classifier.equals(other.getClassifier()))
                return false;
            
            if (!this.name.equals(other.getName()))
                return false;
            
            return true;
        }
        
        if (obj instanceof Fragment) {
            final Fragment other = (Fragment)obj;
            if (!this.classifier.equals(other.getClassifier())) 
                return false;

            if (!this.name.equals(other.getName()))
                return false;
            
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.classifier.hashCode();
        hash = 59 * hash + this.name.hashCode();
        return hash;
    }
}
