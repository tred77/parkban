package ir.ssa.parkban.vertical.exceptions;

/**
 * Created by Bzamani on 01/07/2015.
 */
public class EntityDeleteException extends EntityOperationException {

    public EntityDeleteException() {
        super();
    }

    public EntityDeleteException(String message) {
        super(message);
    }

    public EntityDeleteException(Throwable cause) {
        super(cause);
    }

    public EntityDeleteException(String message,int errorCode) {
        super(message,errorCode);
    }

    public EntityDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityDeleteException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public EntityDeleteException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public EntityDeleteException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
