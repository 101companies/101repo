package jfactextractor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Martin
 */
public class JFactExtractor {

    private final static Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, IOException {
        if (args.length != 2) {
            System.out.println("usage: inputFile (.java) outputFile (.json)");
            System.exit(1);
        }
            
        String inputFile = args[0];
        String factFile = args[1];
        
        CompilationUnit compilationUnit = JavaParser.parse(new File(inputFile));
        Fact fact = new Fact(compilationUnit);
        
        FileWriter writer = new FileWriter(factFile);
        writer.write(gson.toJson(fact));
        writer.close();
    }
}
