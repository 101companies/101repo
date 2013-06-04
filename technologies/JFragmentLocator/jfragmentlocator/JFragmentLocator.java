package jfragmentlocator;

import japa.parser.JavaParser;
import japa.parser.ast.Comment;
import japa.parser.ast.CompilationUnit;
import java.io.File;
import java.util.List;

/**
 *
 * @author Martin
 */
public class JFragmentLocator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String queryString = args[0];
            CompilationUnit unit = JavaParser.parse(System.in);
            
            //create Fact tree and Query
            Fact fact = new Fact(unit);
            Query q = new Query(queryString);
          
            //evaluate the query and get begin and end
            List<Fragment> result = q.walk(fact);
            int beginLine = beginLine(result);
            int endLine = endLine(result);
            
            //include preceeding comment
            if (unit.getComments() != null)
                for (Comment c : unit.getComments())
                    if (c.getEndLine()+1 == beginLine) {
                        beginLine = c.getBeginLine();
                        break; 
                    }
                    
            System.out.println("{\"from\":" + beginLine + ",\"to\":"+endLine+"}");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public static int beginLine( List<Fragment> fragments) {
        int min = Integer.MAX_VALUE;
        for (Fragment fragment : fragments)
            if (fragment.getAstNode().getBeginLine() < min)
                min = fragment.getAstNode().getBeginLine();
        return min;
    }
    
    public static int endLine( List<Fragment> fragments) {
        int max = 0;
        for (Fragment fragment : fragments)
            if (fragment.getAstNode().getEndLine() > max)
                max = fragment.getAstNode().getEndLine();
        return max;
    }
}
