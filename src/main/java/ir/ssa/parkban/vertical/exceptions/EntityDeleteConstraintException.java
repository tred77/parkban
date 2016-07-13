package ir.ssa.parkban.vertical.exceptions;

/**
 * Created by Bzamani on 01/07/2015.
 */
public class EntityDeleteConstraintException extends EntityOperationException {

    public EntityDeleteConstraintException() {
        super();
    }

    public EntityDeleteConstraintException(String message) {
        super(message);
    }

    public EntityDeleteConstraintException(Throwable cause) {
        super(cause);
    }

    public EntityDeleteConstraintException(String message,int errorCode) {
        super(message,errorCode);
    }

    public EntityDeleteConstraintException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityDeleteConstraintException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public EntityDeleteConstraintException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public EntityDeleteConstraintException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
