package ir.ssa.parkban.vertical.exceptions.data.validation;

import ir.ssa.parkban.vertical.exceptions.BaseRunTimeException;

/**
 * Created by Behrouz-ZD on 7/10/2016.
 */
public class DataValidationException extends BaseRunTimeException {

    public DataValidationException() {
        super();
    }

    public DataValidationException(String message) {
        super(message);
    }

    public DataValidationException(Throwable cause) {
        super(cause);
    }

    public DataValidationException(String message, int errorCode) {
        super(message,errorCode);
    }

    public DataValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataValidationException(String message, int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public DataValidationException(String message, int errorCode, Object[] args) {
        super(message,errorCode,args);
    }

    public DataValidationException(String message, int errorCode, Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
