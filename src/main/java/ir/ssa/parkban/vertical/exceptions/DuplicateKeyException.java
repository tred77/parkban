package ir.ssa.parkban.vertical.exceptions;


public class DuplicateKeyException extends EntityOperationException {

    public DuplicateKeyException() {
        super();
    }

    public DuplicateKeyException(String message) {
        super(message);
    }

    public DuplicateKeyException(Throwable cause) {
        super(cause);
    }

    public DuplicateKeyException(String message,int errorCode) {
        super(message,errorCode);
    }

    public DuplicateKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateKeyException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public DuplicateKeyException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public DuplicateKeyException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
