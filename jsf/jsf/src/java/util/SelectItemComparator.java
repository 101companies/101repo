package util;

import java.util.Comparator;
import javax.faces.model.SelectItem;

/**
 *
 * @author Tobias
 */
public class SelectItemComparator implements Comparator<SelectItem> {

    @Override
    public int compare(SelectItem o1, SelectItem o2) {
        Integer o1Value = Integer.parseInt(o1.getValue().toString());
        Integer o2Value = Integer.parseInt(o2.getValue().toString());
        return o1Value.compareTo(o2Value);
    }
    
}
