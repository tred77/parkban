package ir.ssa.parkban.vertical.exceptions;

/**
 * Created by Bzamani on 01/07/2015.
 */
public class NotEditableException extends EntityOperationException {

    public NotEditableException() {
        super();
    }

    public NotEditableException(String message) {
        super(message);
    }

    public NotEditableException(Throwable cause) {
        super(cause);
    }

    public NotEditableException(String message,int errorCode) {
        super(message,errorCode);
    }

    public NotEditableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEditableException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public NotEditableException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public NotEditableException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
