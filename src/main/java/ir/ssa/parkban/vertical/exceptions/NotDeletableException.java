package ir.ssa.parkban.vertical.exceptions;

/**
 * Created by Bzamani on 01/07/2015.
 */
public class NotDeletableException extends EntityOperationException {

    public NotDeletableException() {
        super();
    }

    public NotDeletableException(String message) {
        super(message);
    }

    public NotDeletableException(Throwable cause) {
        super(cause);
    }

    public NotDeletableException(String message,int errorCode) {
        super(message,errorCode);
    }

    public NotDeletableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotDeletableException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public NotDeletableException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public NotDeletableException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
