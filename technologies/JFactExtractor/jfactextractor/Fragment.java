/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jfactextractor;

import japa.parser.ast.body.*;
import japa.parser.ast.expr.AnnotationExpr;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin
 */
public class Fragment {
    private String classifier;
    private String name;
    private List<Fragment> fragments;
    private List<String> annotations = new ArrayList<String>();;
    
    public Fragment(ClassOrInterfaceDeclaration declaration) {
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
        classifier = "method";
        name = declaration.getName();
        fragments = null;
        
        if (declaration.getAnnotations() != null)
                for (AnnotationExpr expr : declaration.getAnnotations())
                    annotations.add(expr.getName().toString());
    }
    
    public Fragment(ConstructorDeclaration declaration) {
        classifier = "method";
        name = declaration.getName();
        fragments = null;
        
        if (declaration.getAnnotations() != null)
                for (AnnotationExpr expr : declaration.getAnnotations())
                    annotations.add(expr.getName().toString());
    }

}
