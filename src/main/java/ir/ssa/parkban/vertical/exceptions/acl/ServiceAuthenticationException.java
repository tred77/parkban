package ir.ssa.parkban.vertical.exceptions.acl;

import ir.ssa.parkban.vertical.exceptions.acl.ACLException;

/**
 * Created by Behrouz-ZD on 7/8/2016.
 */
public class ServiceAuthenticationException extends ACLException {

    public ServiceAuthenticationException() {
        super();
    }

    public ServiceAuthenticationException(String message) {
        super(message);
    }

    public ServiceAuthenticationException(Throwable cause) {
        super(cause);
    }

    public ServiceAuthenticationException(String message,int errorCode) {
        super(message,errorCode);
    }

    public ServiceAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceAuthenticationException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public ServiceAuthenticationException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public ServiceAuthenticationException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}