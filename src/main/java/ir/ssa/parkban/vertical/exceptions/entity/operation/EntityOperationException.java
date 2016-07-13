package ir.ssa.parkban.vertical.exceptions.entity.operation;

import ir.ssa.parkban.vertical.exceptions.BaseRunTimeException;

/**
 * Created by Behrouz-ZD on 7/8/2016.
 */
public class EntityOperationException extends BaseRunTimeException {

    public EntityOperationException() {
        super();
    }

    public EntityOperationException(String message) {
        super(message);
    }

    public EntityOperationException(Throwable cause) {
        super(cause);
    }

    public EntityOperationException(String message,int errorCode) {
        super(message,errorCode);
    }

    public EntityOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityOperationException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public EntityOperationException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public EntityOperationException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }

}
