package ir.ssa.parkban.service.business.validation;

import ir.ssa.parkban.service.business.validation.annotations.DuplicatedUser;
import ir.ssa.parkban.vertical.exceptions.InternalRunTimeException;
import ir.ssa.parkban.vertical.validations.validators.HandlerMethodPair;
import ir.ssa.parkban.vertical.validations.validators.comparators.DateComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by Behrouz-ZD on 7/9/2016.
 */

@Component
public class CustomizedValidatorProvider{


    @Autowired
    private DateComparator dateComparator ;


    @Autowired
    private BusinessUserValidator userValidator;


    public HandlerMethodPair prepareValidationHandler(Annotation annotation,Object[] args){

        if(annotation == null)
            return null;

        if(annotation.annotationType().equals(DuplicatedUser.class))
        {
            return prepareDuplicateUserValidation(annotation, args);
        }

        return null;
    }

    private HandlerMethodPair prepareDuplicateUserValidation(Annotation annotation,Object[] args){
        String[] props = ((DuplicatedUser)annotation).propertyNames();
        int[] orders = ((DuplicatedUser)annotation).propertyOrders();

        if(props!=null && orders!=null){
            if(props.length!=orders.length)
                throw new InternalRunTimeException("Error extracting @DuplicatedUser info");
            if(args==null)
                throw new InternalRunTimeException("Error extracting @DuplicatedUser info(invalid input parameters)");

            Object[] params = new Object[orders.length];
            for (int i=0;i<orders.length;i++){
                String[] att = StringUtils.split(props[i],".");
                if(att == null || att .length==0){
                    params[i] = args[orders[i]];
                }else{
                    params[i] = getPropertyValueOf(
                            props[i].substring(props[i].indexOf('.')+1,props[i].length()),
                            args[orders[i]]
                    );
                }

            }

            return new HandlerMethodPair(userValidator,"duplicatedUser",params);
        }else
        {
            return new HandlerMethodPair(userValidator,"duplicatedUser",args);
        }
    }

    private Object getPropertyValueOf(String propertyPath,Object obj){

        String[] fieldNames = propertyPath.split(".");
        if(ObjectUtils.isEmpty(fieldNames)){
            fieldNames = new String[]{propertyPath};
        }
        Field field;
        Class<?> targetClass = obj.getClass();
        Object value = obj;
        for (String fieldName: fieldNames) {
            try {
                field =  getFieldByName(targetClass, fieldName);
                targetClass = field.getType();
                value = getFieldValue(value, field);
            }catch (Exception e){
                throw new InternalRunTimeException("Error extracting field",e);
            }
        }
        return value;
    }

    private Object getFieldValue(Object obj, Field field) throws Exception {
        field.setAccessible(true);
        return field.get(obj);
    }

    private Field getFieldByName(Class<?> targetClass, String fieldName)
            throws Exception {
        return targetClass.getDeclaredField(fieldName);
    }
}
