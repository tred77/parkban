package ir.ssa.parkban.vertical.exceptions.acl;

import ir.ssa.parkban.vertical.exceptions.BaseRunTimeException;

/**
 * Created by Bzamani on 04/07/2015.
 */
public class ACLException extends BaseRunTimeException {

    public ACLException() {
        super();
    }

    public ACLException(String message) {
        super(message);
    }

    public ACLException(Throwable cause) {
        super(cause);
    }

    public ACLException(String message,int errorCode) {
        super(message,errorCode);
    }

    public ACLException(String message, Throwable cause) {
        super(message, cause);
    }

    public ACLException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public ACLException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public ACLException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }

}
