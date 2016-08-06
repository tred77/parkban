package ir.ssa.parkban.vertical.exceptions.business;

import ir.ssa.parkban.vertical.exceptions.BaseRunTimeException;

/**
 * Created by Behrouz-ZD on 7/19/2016.
 */
public class BaseBusinessException extends BaseRunTimeException {

    public BaseBusinessException() {
        super();
    }

    public BaseBusinessException(String message) {
        super(message);
    }

    public BaseBusinessException(Throwable cause) {
        super(cause);
    }

    public BaseBusinessException(String message, int errorCode) {
        super(message,errorCode);
    }

    public BaseBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseBusinessException(String message, int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public BaseBusinessException(String message, int errorCode, Object[] args) {
        super(message,errorCode,args);
    }

    public BaseBusinessException(String message, int errorCode, Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
