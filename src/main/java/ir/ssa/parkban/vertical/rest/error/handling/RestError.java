package ir.ssa.parkban.vertical.rest.error.handling;

import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

/**
 * Created by Behrouz-ZD on 7/7/2016.
 */
public class RestError {

    private final HttpStatus status;
    private final int code;
    private final String message;
    private final Throwable throwable;


    public RestError(HttpStatus status, int code, String message, Throwable throwable) {
        if (status == null) {
            throw new NullPointerException("HttpStatus argument cannot be null.");
        }
        this.status = status;
        this.code = code;
        this.message = message;
        this.throwable = throwable;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof RestError) {
            RestError re = (RestError) o;
            return ObjectUtils.nullSafeEquals(getStatus(), re.getStatus()) &&
                    getCode() == re.getCode() &&
                    ObjectUtils.nullSafeEquals(getMessage(), re.getMessage()) &&
                    ObjectUtils.nullSafeEquals(getThrowable(), re.getThrowable());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return ObjectUtils.nullSafeHashCode(new Object[]{
                getStatus(), getCode(), getMessage(), getThrowable()
        });
    }

    public String toString() {
        return new StringBuilder().append(getStatus().value())
                .append(" (").append(getStatus().getReasonPhrase()).append(" )")
                .toString();
    }

    public static class Builder {

        private HttpStatus status;
        private int code;
        private String message;
        private Throwable throwable;

        public Builder() {
        }

        public Builder setStatus(int statusCode) {
            this.status = HttpStatus.valueOf(statusCode);
            return this;
        }

        public Builder setStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder setCode(int code) {
            this.code = code;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setThrowable(Throwable throwable) {
            this.throwable = throwable;
            return this;
        }

        public RestError build() {
            if (this.status == null) {
                this.status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
            return new RestError(this.status, this.code, this.message, this.throwable);
        }
    }


}
