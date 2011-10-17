package company.dao.exception;

/**
 *
 * @author Tobias
 */
public class CompanyException extends Exception {
    
    private String message;
    
    public CompanyException(String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return this.message;
    }
}
