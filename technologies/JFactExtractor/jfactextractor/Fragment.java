/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jfactextractor;

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
    private String classifier;
    private String name;
    private List<Fragment> fragments;
    private List<String> annotations = new ArrayList<String>();
    private Integer index = null;
    private transient Fragment parent = null;
    private int startLine;
    private int endLine;
    
    public Fragment(ClassOrInterfaceDeclaration declaration) {
        classifier = "class";
        fragments = new ArrayList<Fragment>();
        name = declaration.getName();
        startLine = declaration.getBeginLine();
        endLine = declaration.getEndLine();
        
        if (declaration.getAnnotations() != null)
                for (AnnotationExpr expr : declaration.getAnnotations())
                    annotations.add(expr.getName().toString());
        
        for (BodyDeclaration decl : declaration.getMembers()) {
            if (decl instanceof ClassOrInterfaceDeclaration)
                fragments.add(new Fragment((ClassOrInterfaceDeclaration)decl));
            
            if (decl instanceof MethodDeclaration)
                fragments.add(new Fragment(this, (MethodDeclaration) decl));
            
            if (decl instanceof ConstructorDeclaration)
                fragments.add(new Fragment(this, (ConstructorDeclaration)decl));
        } 
    }
    
    public Fragment(Fragment parent, MethodDeclaration declaration) {
        classifier = "method";
        name = declaration.getName();
        this.parent = parent;
        fragments = null;
        startLine = declaration.getBeginLine();
        endLine = declaration.getEndLine();
        
        doOverloadChecking();
        
        if (declaration.getAnnotations() != null)
                for (AnnotationExpr expr : declaration.getAnnotations())
                    annotations.add(expr.getName().toString());
    }
    
    public Fragment(Fragment parent, ConstructorDeclaration declaration) {
        classifier = "method";
        name = declaration.getName();
        this.parent = parent;
        fragments = null;
        startLine = declaration.getBeginLine();
        endLine = declaration.getEndLine();
        
        doOverloadChecking();
        
        if (declaration.getAnnotations() != null)
                for (AnnotationExpr expr : declaration.getAnnotations())
                    annotations.add(expr.getName().toString());
    }
    
    private void doOverloadChecking() {
        int idx = 1;
        for (Fragment f : parent.getFragments()) {
            if (f.isOverloaded(this.name))
                    idx++;
        }
        
        if (idx > 1)
            index = new Integer(idx);    
    }

    public List<Fragment> getFragments() {
        return fragments;
    }

    public String getName() {
        return name;
    }
    
    public boolean isOverloaded(String othermethod) {
        if (this.name.equals(othermethod)) {
            if (index == null)
                index = new Integer(1);
            return true;
        }
        
        return false;
    }
}
