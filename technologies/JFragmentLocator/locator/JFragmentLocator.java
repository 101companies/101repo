/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locator;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Martin
 */
public class JFragmentLocator {
 
    private static class MethodVisitor extends VoidVisitorAdapter {
        private HashMap<String, Integer> methodCnt = new HashMap<String, Integer>();
        
        @Override
        public void visit(MethodDeclaration decl, Object obj) {
            String methodName = decl.getName();
            if (fragment.isOverloaded()) {
                if (!methodCnt.containsKey(methodName))
                    methodCnt.put(methodName, 0);
                else
                    methodCnt.put(methodName, methodCnt.get(methodName)+1);
                
                methodName += methodCnt.get(methodName);
            }
                
            methods.put(methodName, new Tupel(decl.getBeginLine(), decl.getEndLine()));
        }
    }
    
    private static Fragment fragment;
    private static HashMap<String, Tupel> methods = new HashMap<String, Tupel>(); 
    private static Gson gson = new Gson();
    
    private static void fileBased(String args[]) throws ParseException, IOException {
        String inputFile = args[0];
        String fragmentFile = args[1];
        String ouputFile = args[2];
        
	JsonReader r = new JsonReader(new FileReader(fragmentFile));
        fragment = gson.fromJson(r, Fragment.class);
        
        parse(inputFile);
        
        String methodName = fragment.getMethod();
        if (fragment.isOverloaded())
            methodName += fragment.getOverload();
        
        writeOutput(ouputFile, gson.toJson(methods.get(methodName)));
    }

    private static void consoleBased(String args[]) throws ParseException, IOException {
        String inputFile = args[0];
        String fragmentDescription = args[1];
        
	
        fragment = new Fragment(fragmentDescription);
        
        parse(inputFile);
        
        String methodName = fragment.getMethod();
        if (fragment.isOverloaded())
            methodName += fragment.getOverload();
        
        System.out.println(gson.toJson(methods.get(methodName)));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, IOException {
	switch (args.length) {
		case 2:
			consoleBased(args);
			break;
		case 3: 
			fileBased(args);
			break;
		default:
			System.out.println("usage: inputFile (.java) fragmentFile (.json) outputFile");
            		System.out.println("alt usage: inputFile (.java) fragmentDescription");
            		System.exit(1);
	}       	
    }
    
    private static void parse(String inputFile) throws ParseException, IOException {
        CompilationUnit unit = JavaParser.parse(new File(inputFile));
        MethodVisitor visitor = new MethodVisitor();
        visitor.visit(unit, null);
    }
    
    private static void writeOutput(String fileName, String output) throws IOException {
        FileWriter writer = new FileWriter(new File(fileName));
        writer.write(output);
        writer.write('\n');
        writer.close();
    }
}
