package ir.ssa.parkban.vertical.exceptions;

/**
 * Created by Behrouz-ZD on 7/10/2016.
 */
public class ArgumentRequiredException  extends BaseRunTimeException{

    public ArgumentRequiredException() {
        super();
    }

    public ArgumentRequiredException(String message) {
        super(message);
    }

    public ArgumentRequiredException(Throwable cause) {
        super(cause);
    }

    public ArgumentRequiredException(String message,int errorCode) {
        super(message,errorCode);
    }

    public ArgumentRequiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArgumentRequiredException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public ArgumentRequiredException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public ArgumentRequiredException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}