package ir.ssa.parkban.vertical.exceptions.data.validation;

import ir.ssa.parkban.vertical.exceptions.BaseRunTimeException;

/**
 * Created by Behrouz-ZD on 7/10/2016.
 */
public class DataValidation extends BaseRunTimeException {

    public DataValidation() {
        super();
    }

    public DataValidation(String message) {
        super(message);
    }

    public DataValidation(Throwable cause) {
        super(cause);
    }

    public DataValidation(String message,int errorCode) {
        super(message,errorCode);
    }

    public DataValidation(String message, Throwable cause) {
        super(message, cause);
    }

    public DataValidation(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public DataValidation(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public DataValidation(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
