package ir.ssa.parkban.controller.exceptionhandeling;

/**
 * Created by hadoop on 6/30/16.
 */
public class ExceptionResponse {

    private ExceptionType exceptionType;
    private String code;
    private String message;

    public ExceptionResponse(ExceptionType type, String code, String message) {
        this.exceptionType = type;
        this.code = code;
        this.message = message;
    }

    public enum ExceptionType{
        ERROR,
        WARNING
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
