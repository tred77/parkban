package ir.ssa.parkban.controller.exceptionhandeling;

import ir.ssa.parkban.vertical.exceptions.ParkBanRunTimeException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hadoop on 6/30/16.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private final static String UN_HANDLED_EXCEPTION = "0000";

    @ExceptionHandler (value = Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception ex) throws Exception{

        if(AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null)
            throw ex;

        ExceptionResponse exceptionResponse = new ExceptionResponse(ExceptionResponse.ExceptionType.ERROR
            , UN_HANDLED_EXCEPTION, "Unknown Error");
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler (value = ParkBanRunTimeException.class)
    public ResponseEntity<ExceptionResponse> handelParkBanRunTimeException(ParkBanRunTimeException ex){

        //TODO log Error

        ExceptionResponse exceptionResponse = new ExceptionResponse(ExceptionResponse.ExceptionType.ERROR
                ,ex.getErrorCode() , ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.OK);
    }

}
