package ir.ssa.parkban.vertical.exceptions;

/**
 * @author hym
 */
public class ParkBanRunTimeException extends RuntimeException {

    private String errorCode;

    public ParkBanRunTimeException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
