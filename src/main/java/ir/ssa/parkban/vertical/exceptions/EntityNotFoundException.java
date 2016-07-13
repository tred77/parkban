package ir.ssa.parkban.vertical.exceptions;

/**
 * Created by Bzamani on 01/07/2015.
 */
public class EntityNotFoundException extends EntityOperationException {

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }

    public EntityNotFoundException(String message,int errorCode) {
        super(message,errorCode);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public EntityNotFoundException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public EntityNotFoundException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
