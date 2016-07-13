package ir.ssa.parkban.vertical.exceptions.entity.operation;

/**
 * Created by Bzamani on 8/31/2015.
 */
public class DuplicateEntityAfterEditException extends EntityOperationException {
    public DuplicateEntityAfterEditException() {
        super();
    }

    public DuplicateEntityAfterEditException(String message) {
        super(message);
    }

    public DuplicateEntityAfterEditException(Throwable cause) {
        super(cause);
    }

    public DuplicateEntityAfterEditException(String message,int errorCode) {
        super(message,errorCode);
    }

    public DuplicateEntityAfterEditException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateEntityAfterEditException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public DuplicateEntityAfterEditException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public DuplicateEntityAfterEditException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
