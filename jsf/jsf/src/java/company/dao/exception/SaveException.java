package company.dao.exception;

import company.dao.exception.constants.Field;

/**
 *
 * @author Tobias
 */
public class SaveException extends CompanyException {
    
    private Field field;
    
    public SaveException(Field field, String message) {
        super(message);
        this.field = field;   
    }
    
    public Field getField() {
        return this.field;
    }
    
}
