package ir.ssa.parkban.vertical.exceptions;

/**
 * @author hym
 */
public class BaseRunTimeException extends RuntimeException {

    private int errorCode;
    private Object[] args;

    public int getErrorCode() {
        return errorCode;
    }

    public Object[] getArgs() {
        return args;
    }

    public BaseRunTimeException() {
        super();
    }

    public BaseRunTimeException(String message) {
        super(message);
    }

    public BaseRunTimeException(Throwable cause) {
        super(cause);
    }

    public BaseRunTimeException(String message,int errorCode) {
        super(message);
        this.errorCode=errorCode;
    }

    public BaseRunTimeException(String message,int errorCode,Object[] args) {
        super(message);
        this.errorCode=errorCode;
        this.args = args;
    }

    public BaseRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseRunTimeException(String message,int errorCode, Throwable cause){
        super(message, cause);
        this.errorCode=errorCode;
    }


    public BaseRunTimeException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, cause);
        this.errorCode=errorCode;
        this.args = args;
    }

}
