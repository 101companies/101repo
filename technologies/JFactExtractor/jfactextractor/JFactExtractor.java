/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jfactextractor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Martin Leinberger
 */
public class JFactExtractor {

    private final static Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("usage: inputFile (.java) outputFile (.json)");
                System.exit(1);
            }

            File inputFile = new File(args[0]);
            String factFile = args[1];

            CompilationUnit compilationUnit = JavaParser.parse(inputFile);
            Fact fact = new Fact(inputFile, compilationUnit);

            FileWriter writer = new FileWriter(factFile);
            writer.write(gson.toJson(fact));
            writer.close();
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}
