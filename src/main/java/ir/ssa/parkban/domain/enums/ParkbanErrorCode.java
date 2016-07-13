package ir.ssa.parkban.domain.enums;

/**
 * Created by Behrouz-ZD on 7/12/2016.
 */
public enum ParkbanErrorCode {

    ERROR(-520),
    USERNAME_IS_DUPLICATED(ERROR.code()-1),
    NATIONAL_CODE_IS_DUPLICATED(ERROR.code()-2),
    USERNAME_NATIONAL_CODE_IS_DUPLICATED(ERROR.code()-3),

    ;


    public int code() {
        return code;
    }

    private int code;

    ParkbanErrorCode(int code) {
        this.code = code;
    }

    public String toString() {
        return "PARKBAN_EEROR_CODE." + this.name();
    }
}
