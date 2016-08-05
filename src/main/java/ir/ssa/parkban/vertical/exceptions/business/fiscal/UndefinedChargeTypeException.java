package ir.ssa.parkban.vertical.exceptions.business.fiscal;

import ir.ssa.parkban.vertical.exceptions.business.BaseBusinessException;

/**
 * author hadoop
 */
public class UndefinedChargeTypeException extends BaseBusinessException {

    public UndefinedChargeTypeException() {
        super();
    }

    public UndefinedChargeTypeException(String message) {
        super(message);
    }

    public UndefinedChargeTypeException(Throwable cause) {
        super(cause);
    }

    public UndefinedChargeTypeException(String message, int errorCode) {
        super(message,errorCode);
    }

    public UndefinedChargeTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UndefinedChargeTypeException(String message, int errorCode, Throwable cause){
        super(message,errorCode, cause);
    }

    public UndefinedChargeTypeException(String message, int errorCode, Object[] args) {
        super(message,errorCode,args);
    }

    public UndefinedChargeTypeException(String message, int errorCode, Object[] args, Throwable cause){
        super(message, errorCode,args,cause);
    }
}
