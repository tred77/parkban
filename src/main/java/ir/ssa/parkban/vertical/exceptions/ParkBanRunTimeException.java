package ir.ssa.parkban.vertical.exceptions;

/**
 * @author hym
 */
public class ParkBanRunTimeException extends RuntimeException {

    private String errorCode;

    public ParkBanRunTimeException(){

    }

    public ParkBanRunTimeException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
