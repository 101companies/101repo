/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locator;

/**
 *
 * @author Martin
 */
public class Tupel {
    private int startLine;
    private int endLine;
    
    public Tupel() { }
    
    public Tupel(int start, int end) {
        startLine = start;
        endLine = end;
    }
    
    public String toJSON() {
        return "{\"to\": "+startLine+ ", \"from\": "+endLine+"}";
    }
}
