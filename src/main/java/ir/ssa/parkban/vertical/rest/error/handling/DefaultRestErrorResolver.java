package ir.ssa.parkban.vertical.rest.error.handling;


import ir.ssa.parkban.vertical.configuration.PersianLocaleResolver;
import ir.ssa.parkban.vertical.exceptions.*;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Behrouz-ZD on 7/7/2016.
 */

@Component
public class DefaultRestErrorResolver implements RestErrorResolver {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private LocaleResolver localeResolver;

    @Autowired
    private RestErrorConverter restErrorConverter;

    public static final String DEFAULT_EXCEPTION_MESSAGE_VALUE = "PARKBAN_EEROR_CODE.ERROR";


    private Map<String, RestError> exceptionMappings = Collections.emptyMap();
    private Map<String, String> exceptionMappingDefinitions = Collections.emptyMap();



    private boolean defaultEmptyCodeToStatus;

    public DefaultRestErrorResolver() {
        this.defaultEmptyCodeToStatus = true;
        this.exceptionMappingDefinitions=createDefaultExceptionMappingDefinitions();
        this.exceptionMappings=toRestErrors(this.exceptionMappingDefinitions);
    }


    protected Map<String,String> createDefaultExceptionMappingDefinitions() {

        Map<String,String> m = new LinkedHashMap<String, String>();

        // 400
        applyDef(m, HttpMessageNotReadableException.class, HttpStatus.BAD_REQUEST);
        applyDef(m, MissingServletRequestParameterException.class, HttpStatus.BAD_REQUEST);
        applyDef(m, TypeMismatchException.class, HttpStatus.BAD_REQUEST);
        applyDef(m, "javax.validation.ValidationException", HttpStatus.BAD_REQUEST);
        applyDef(m, MethodArgumentNotValidException.class, HttpStatus.BAD_REQUEST);

        // 404
        applyDef(m, NoSuchRequestHandlingMethodException.class, HttpStatus.NOT_FOUND);
        applyDef(m, "org.hibernate.ObjectNotFoundException", HttpStatus.NOT_FOUND);

        // 405
        applyDef(m, HttpRequestMethodNotSupportedException.class, HttpStatus.METHOD_NOT_ALLOWED);

        // 406
        applyDef(m, HttpMediaTypeNotAcceptableException.class, HttpStatus.NOT_ACCEPTABLE);

        // 409
        applyDef(m, "org.springframework.dao.DataIntegrityViolationException", HttpStatus.CONFLICT);

        // 415
        applyDef(m, HttpMediaTypeNotSupportedException.class, HttpStatus.UNSUPPORTED_MEDIA_TYPE);

        // 500 (Internal Exception Server Side)
        applyDef(m, InternalRunTimeException.class, HttpStatus.INTERNAL_SERVER_ERROR);

        // 401 Authorization Exception
        applyDef(m, AuthorizationServiceException.class,HttpStatus.UNAUTHORIZED);

        // 511 Authentication Exception
        applyDef(m, AuthenticationServiceException.class,HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);

        // Entity Operation Exceptions
        applyDef(m, DuplicateEntityAfterEditException.class,HttpStatus.NOT_MODIFIED);
        applyDef(m,DuplicateEntityAfterEditException.class,HttpStatus.NOT_MODIFIED);
        applyDef(m, DuplicateEntityException.class,HttpStatus.SEE_OTHER);
        applyDef(m, DuplicateKeyException.class,HttpStatus.SEE_OTHER);
        applyDef(m, EntityDeleteConstraintException.class,HttpStatus.NOT_MODIFIED);
        applyDef(m, EntityDeleteException.class,HttpStatus.NOT_MODIFIED);
        applyDef(m, EntityNotFoundException.class,HttpStatus.NOT_FOUND);
        applyDef(m, EntitySaveException.class,HttpStatus.NOT_MODIFIED);
        applyDef(m, NotDeletableException.class,HttpStatus.NOT_MODIFIED);
        applyDef(m, NotEditableException.class,HttpStatus.NOT_MODIFIED);

        return m;
    }

    private void applyDef(Map<String,String> m, Class clazz, HttpStatus status) {
        applyDef(m, clazz.getName(), status);
    }

    private void applyDef(Map<String,String> m, String key, HttpStatus status) {
        m.put(key, definitionFor(status));
    }

    private String definitionFor(HttpStatus status) {
        return "status="+status.value()+
                ",code="+status.value();
    }

    @Override
    public RestError resolveError(WebRequest request,Exception ex) {

        RestError template = getRestErrorTemplate(ex);
        if (template == null) {
            return null;
        }
        RestError.Builder builder = new RestError.Builder();
        builder.setStatus(getStatusValue(template));
        builder.setCode(getCode(template,ex));
        builder.setThrowable(ex);
        String msg = getMessage(template, ex);
        if (msg != null) {
            builder.setMessage(msg);
        }
        return builder.build();
    }

    protected int getStatusValue(RestError template) {
        return template.getStatus().value();
    }

    protected int getCode(RestError template,Exception ex) {
        int errorCode=0;
        if(ex!=null && BaseRunTimeException.class.isAssignableFrom(ex.getClass()))
            errorCode=((BaseRunTimeException)ex).getErrorCode();

        if ( errorCode == 0 && defaultEmptyCodeToStatus) {
            errorCode = getStatusValue(template);
        }
        return errorCode;
    }


    protected String getMessage(RestError template, Exception ex) {
        String msg = template.getMessage();
        Object[] args=null;
        if (ex != null) {
            msg = ex.getMessage();
            if (ObjectUtils.isEmpty(msg)) {
                msg = DEFAULT_EXCEPTION_MESSAGE_VALUE;
            }

            if(BaseRunTimeException.class.isAssignableFrom(ex.getClass())){
                args=((BaseRunTimeException)ex).getArgs();
            }

            if (messageSource != null) {
                Locale locale = null;
                if (localeResolver != null) {
                    locale = ((PersianLocaleResolver)localeResolver).getDefaultLocale();
                }
                msg = messageSource.getMessage(msg, args, msg, locale);
            }
        }

        return msg;
    }


    private RestError getRestErrorTemplate(Exception ex) {
        Map<String, RestError> mappings = this.exceptionMappings;
        if (CollectionUtils.isEmpty(mappings)) {
            return null;
        }
        RestError template = null;
        int deepest = Integer.MAX_VALUE;
        for (Map.Entry<String, RestError> entry : mappings.entrySet()) {
            String key = entry.getKey();
            int depth = getDepth(key, ex);
            if (depth >= 0 && depth < deepest) {
                deepest = depth;
                template = entry.getValue();
            }
        }
        return template;
    }


    protected int getDepth(String exceptionMapping, Exception ex) {
        return getDepth(exceptionMapping, ex.getClass(), 0);
    }

    private int getDepth(String exceptionMapping, Class exceptionClass, int depth) {
        if (exceptionClass.getName().contains(exceptionMapping)) {
            return depth;
        }
        if (exceptionClass.equals(Throwable.class)) {
            return -1;
        }
        return getDepth(exceptionMapping, exceptionClass.getSuperclass(), depth + 1);
    }


    protected Map<String, RestError> toRestErrors(Map<String, String> smap) {
        if (CollectionUtils.isEmpty(smap)) {
            return Collections.emptyMap();
        }

        Map<String, RestError> map = new LinkedHashMap<>(smap.size());

        for (Map.Entry<String, String> entry : smap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            RestError template = toRestError(value);
            map.put(key, template);
        }

        return map;
    }

    protected RestError toRestError(String exceptionConfig) {
        String[] values = StringUtils.commaDelimitedListToStringArray(exceptionConfig);
        if (ObjectUtils.isEmpty(values)) {
            throw new IllegalStateException("Invalid config mapping.  Exception names must map to a string configuration.");
        }

        RestError.Builder builder = new RestError.Builder();

        for (String value : values) {

            String trimmedVal = StringUtils.trimWhitespace(value);

            //check to see if the value is an explicitly named key/value pair:
            String[] pair = StringUtils.split(trimmedVal, "=");
            if (pair != null) {
                String pairKey = StringUtils.trimWhitespace(pair[0]);
                if (!StringUtils.hasText(pairKey)) {
                    pairKey = null;
                }
                String pairValue = StringUtils.trimWhitespace(pair[1]);
                if (!StringUtils.hasText(pairValue)) {
                    pairValue = null;
                }
                if ("status".equalsIgnoreCase(pairKey)) {
                    int statusCode = getRequiredInt(pairKey, pairValue);
                    builder.setStatus(statusCode);
                } else if ("code".equalsIgnoreCase(pairKey)) {
                    int code = getRequiredInt(pairKey, pairValue);
                    builder.setCode(code);
                } else if ("msg".equalsIgnoreCase(pairKey)) {
                    builder.setMessage(pairValue);
                }
            }
        }

        return builder.build();
    }

    private static int getRequiredInt(String key, String value) {
        try {
            int anInt = Integer.valueOf(value);
            return Math.max(-1, anInt);
        } catch (NumberFormatException e) {
            String msg = "Configuration element '" + key + "' requires an integer value.  The value " +
                    "specified: " + value;
            throw new IllegalArgumentException(msg, e);
        }
    }

}

