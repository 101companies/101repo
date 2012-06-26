package jvalidator;

import japa.parser.JavaParser;
import java.io.File;

/**
 * @author Martin Leinberger
 */
public class JValidator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("usage: inputFile (.java)");
            System.exit(1);
        }
         
        String filePath = args[0];
        
        try {
            JavaParser.parse(new File(filePath));
        } catch (Exception ex) {
				System.err.println(ex);
            System.exit(1);
        }
        
        System.exit(0);
    }
}
