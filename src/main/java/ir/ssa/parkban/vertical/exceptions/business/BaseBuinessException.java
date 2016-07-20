package ir.ssa.parkban.vertical.exceptions.business;

import ir.ssa.parkban.vertical.exceptions.BaseRunTimeException;

/**
 * Created by Behrouz-ZD on 7/19/2016.
 */
public class BaseBuinessException extends BaseRunTimeException {

    public BaseBuinessException() {
        super();
    }

    public BaseBuinessException(String message) {
        super(message);
    }

    public BaseBuinessException(Throwable cause) {
        super(cause);
    }

    public BaseBuinessException(String message,int errorCode) {
        super(message,errorCode);
    }

    public BaseBuinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseBuinessException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public BaseBuinessException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public BaseBuinessException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
