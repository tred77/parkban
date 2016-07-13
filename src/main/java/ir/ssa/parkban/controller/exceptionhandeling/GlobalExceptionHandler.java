package ir.ssa.parkban.controller.exceptionhandeling;


import ir.ssa.parkban.vertical.exceptions.BaseRunTimeException;
import ir.ssa.parkban.vertical.rest.error.handling.RestError;
import ir.ssa.parkban.vertical.rest.error.handling.RestErrorConverter;
import ir.ssa.parkban.vertical.rest.error.handling.RestErrorResolver;
import ir.ssa.parkban.vertical.exceptions.acl.ACLException;
import ir.ssa.parkban.vertical.exceptions.entity.operation.EntityOperationException;
import ir.ssa.parkban.vertical.exceptions.InternalRunTimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * Created by hadoop on 6/30/16.
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final static String UN_HANDLED_EXCEPTION = "0000";

    @Autowired
    private RestErrorResolver errorResolver;

    @Autowired
    private RestErrorConverter<?> errorConverter;


    @ExceptionHandler (value = Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception ex) throws Exception{

        if(AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null)
            throw ex;

        ExceptionResponse exceptionResponse = new ExceptionResponse(ExceptionResponse.ExceptionType.ERROR
            , UN_HANDLED_EXCEPTION, "Unknown Error");
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler (value = InternalRunTimeException.class)
    public ResponseEntity<RestError> handelInternalRunTimeException(InternalRunTimeException ex,WebRequest request){

        RestError error =null;
        if(ex.getCause()!=null && BaseRunTimeException.class.isAssignableFrom(ex.getCause().getClass()))
            error = errorResolver.resolveError(request,(BaseRunTimeException)ex.getCause());
        else
            error = errorResolver.resolveError(request,ex);
        //Object body = errorConverter.convert(error);

        return new ResponseEntity<RestError>(error, error.getStatus());
    }


    @ExceptionHandler (value = ACLException.class)
    public ResponseEntity<RestError> handelACLException(ACLException ex,WebRequest request){
        RestError error =null;
        error = errorResolver.resolveError(request,ex);
        return new ResponseEntity<RestError>(error, error.getStatus());
    }

    @ExceptionHandler (value = EntityOperationException.class)
    public ResponseEntity<RestError> handelEntityOperationException(EntityOperationException ex,WebRequest request){

        RestError error = errorResolver.resolveError(request,ex);
        return new ResponseEntity<RestError>(error, error.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {

        RestError error = errorResolver.resolveError(request,exception);
        return super.handleExceptionInternal(exception, error, headers, status, request);

    }




}
