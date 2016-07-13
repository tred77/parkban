package ir.ssa.parkban.vertical.exceptions;

/**
 * Created by Bzamani on 01/07/2015.
 */
public class EntitySaveException extends EntityOperationException {

    public EntitySaveException() {
        super();
    }

    public EntitySaveException(String message) {
        super(message);
    }

    public EntitySaveException(Throwable cause) {
        super(cause);
    }

    public EntitySaveException(String message,int errorCode) {
        super(message,errorCode);
    }

    public EntitySaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntitySaveException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public EntitySaveException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public EntitySaveException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
