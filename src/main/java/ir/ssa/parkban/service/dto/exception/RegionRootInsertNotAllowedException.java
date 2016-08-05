package ir.ssa.parkban.service.dto.exception;

import ir.ssa.parkban.vertical.exceptions.business.BaseBusinessException;

/**
 * Created by Behrouz-ZD on 7/22/2016.
 */
public class RegionRootInsertNotAllowedException extends BaseBusinessException {

    public RegionRootInsertNotAllowedException() {
        super();
    }

    public RegionRootInsertNotAllowedException(String message) {
        super(message);
    }

    public RegionRootInsertNotAllowedException(Throwable cause) {
        super(cause);
    }

    public RegionRootInsertNotAllowedException(String message,int errorCode) {
        super(message,errorCode);
    }

    public RegionRootInsertNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegionRootInsertNotAllowedException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public RegionRootInsertNotAllowedException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public RegionRootInsertNotAllowedException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
