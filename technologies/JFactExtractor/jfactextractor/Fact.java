/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jfactextractor;

import japa.parser.ast.Comment;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.ImportDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.TypeDeclaration;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Martin
 */
public class Fact {
    String comment;
    @SerializedName("package")
    String packageStr = "";
    Set<String> imports = new HashSet<String>();
    List<Fragment> fragments = new ArrayList<Fragment>();
    
    public Fact(CompilationUnit unit) throws FileNotFoundException {
        if (unit.getPackage() != null)
            packageStr = unit.getPackage().getName().toString().replace("package", "");
        
        if (unit.getImports() != null)
            for (ImportDeclaration imp : unit.getImports()) {
                String str = imp.getName().toString();
                if (!imp.isAsterisk())
                    str = str.substring(0, str.lastIndexOf("."));
                imports.add(str);
            }
        
	//comments are currently disabled, since they are not easily accessable from the CompilationUnit
        //comment = extractTopComment(inputText);
        
        analyze(unit);
    }
    
    private void analyze(CompilationUnit unit) {
        for (TypeDeclaration decl : unit.getTypes()) {
            if (decl instanceof ClassOrInterfaceDeclaration) {
                fragments.add(new Fragment((ClassOrInterfaceDeclaration)decl, unit));
            }
        }
    }
    
    private String extractTopComment(String input) throws FileNotFoundException {
        StringBuffer buffer = new StringBuffer("");
        Scanner scanner = new Scanner(input);
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
            
            if (!blockComment && (str.matches("package .*;") || str.matches("(private|protected|public)\\s+class .* \\{")))
                return buffer.toString().trim();
        } while (true);
    }
}
