/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locator;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import java.io.*;
import java.util.HashMap;

/**
 *
 * @author Martin
 */
public class JFragmentLocator {
    @SuppressWarnings("unchecked")
    private static class MethodVisitor extends VoidVisitorAdapter {
        @Override
        public void visit(MethodDeclaration decl, Object obj) {
            methods.put(decl.getName(), new Tupel(decl.getBeginLine(), decl.getEndLine()));
        }
    }
    
    private static HashMap<String, Tupel> methods = new HashMap<String, Tupel>(); 
    
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ParseException, IOException {
        if (args.length != 3) {
            System.out.println("usage: inputFile (.java) fragmentFile (.json) outputFile");
            System.exit(1);
        }
            
        String inputFile = args[0];
        String fragmentFile = args[1];
        String ouputFile = args[2];
        
        Fragment fragment = readFragment(fragmentFile);
        
        CompilationUnit unit = JavaParser.parse(new File(inputFile));
        MethodVisitor visitor = new MethodVisitor();
        
        visitor.visit(unit, null);
        
        writeOutput(ouputFile, methods.get(fragment.method).toJSON());
	System.exit(0);
    }
    
    private static Fragment readFragment(String fileName) throws FileNotFoundException {
        return new Gson().fromJson(new JsonReader(new FileReader(new File(fileName))), Fragment.class);
    }
    
    private static void writeOutput(String fileName, String output) throws IOException {
        FileWriter writer = new FileWriter(new File(fileName));
        writer.write(output);
        writer.close();
    }
}
