package ir.ssa.parkban.service.dto.exception;

import ir.ssa.parkban.vertical.exceptions.business.BaseBusinessException;

/**
 * Created by Behrouz-ZD on 7/19/2016.
 */
public class RegionInsertNotAllowedUnderLeafException extends BaseBusinessException {

    public RegionInsertNotAllowedUnderLeafException() {
        super();
    }

    public RegionInsertNotAllowedUnderLeafException(String message) {
        super(message);
    }

    public RegionInsertNotAllowedUnderLeafException(Throwable cause) {
        super(cause);
    }

    public RegionInsertNotAllowedUnderLeafException(String message,int errorCode) {
        super(message,errorCode);
    }

    public RegionInsertNotAllowedUnderLeafException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegionInsertNotAllowedUnderLeafException(String message,int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public RegionInsertNotAllowedUnderLeafException(String message,int errorCode,Object[] args) {
        super(message,errorCode,args);
    }

    public RegionInsertNotAllowedUnderLeafException(String message,int errorCode,Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }

}
