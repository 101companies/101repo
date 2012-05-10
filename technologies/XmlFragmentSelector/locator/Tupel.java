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
    private int to;
    private int from;

    public Tupel() { }
    
    public Tupel(int start, int end) {
        from = start;
        to = end;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
    
    public String toJSON() {
        return new StringBuffer("{")
                    .append("\"from\":").append(from).append(",")
                    .append("\"to\":").append(to)
                   .append("}")
                .toString();               
    }
    
    @Override
    public String toString() {
        return toJSON();
    }
}
