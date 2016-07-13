package ir.ssa.parkban.vertical.exceptions.entity.operation;

/**
 * Created by Bzamani on 01/07/2015.
 */
public class DuplicateEntityException extends EntityOperationException{

    public DuplicateEntityException() {
        super();
    }

    public DuplicateEntityException(String message) {
        super(message);
    }

    public DuplicateEntityException(Throwable cause) {
        super(cause);
    }

    public DuplicateEntityException(String message,int errorCode) {
        super(message,errorCode);
    }

    public DuplicateEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateEntityException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public DuplicateEntityException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public DuplicateEntityException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
