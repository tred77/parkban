package ir.ssa.parkban.vertical.exceptions;

/**
 * Created by Bzamani on 01/07/2015.
 */
public class InternalRunTimeException extends BaseRunTimeException {

    public InternalRunTimeException() {
        super();
    }

    public InternalRunTimeException(String message) {
        super(message);
    }

    public InternalRunTimeException(Throwable cause) {
        super(cause);
    }

    public InternalRunTimeException(String message,int errorCode) {
        super(message,errorCode);
    }

    public InternalRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalRunTimeException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public InternalRunTimeException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public InternalRunTimeException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
