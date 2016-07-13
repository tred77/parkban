package ir.ssa.parkban.vertical.exceptions;

/**
 * Created by Bzamani on 7/12/2015.
 */
public class ServiceAuthorizationException extends ACLException {

    public ServiceAuthorizationException() {
        super();
    }

    public ServiceAuthorizationException(String message) {
        super(message);
    }

    public ServiceAuthorizationException(Throwable cause) {
        super(cause);
    }

    public ServiceAuthorizationException(String message,int errorCode) {
        super(message,errorCode);
    }

    public ServiceAuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceAuthorizationException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public ServiceAuthorizationException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public ServiceAuthorizationException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
