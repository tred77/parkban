package ir.ssa.parkban.service.business.validation;

import ir.ssa.parkban.service.business.validation.annotations.DuplicatedUser;
import ir.ssa.parkban.service.business.validation.annotations.ValidateRegionDeletion;
import ir.ssa.parkban.service.business.validation.annotations.ValidateRegionInsertion;
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
    @Autowired
    private BusinessRegionValidator regionValidator;

    public HandlerMethodPair prepareValidationHandler(Annotation annotation,Object[] args){

        if(annotation == null)
            return null;

        if(annotation.annotationType().equals(DuplicatedUser.class)){
            return prepareDuplicateUserValidation(annotation, args);
        }
        else if(annotation.annotationType().equals(ValidateRegionDeletion.class)){
            return prepareValidateRegionDeletion(annotation,args);
        }
        else if(annotation.annotationType().equals(ValidateRegionInsertion.class)){
            return prepareValidateRegionInsertion(annotation,args);
        }

        return null;
    }

    private HandlerMethodPair prepareDuplicateUserValidation(Annotation annotation,Object[] args){
        String[] props = ((DuplicatedUser)annotation).propertyNames();
        int[] orders = ((DuplicatedUser)annotation).propertyOrders();

        if(props!=null && orders!=null){
            return new HandlerMethodPair(userValidator,"duplicatedUser",extractParams( props,orders,args));
        }else
        {
            return new HandlerMethodPair(userValidator,"duplicatedUser",args);
        }
    }

    private HandlerMethodPair prepareValidateRegionInsertion(Annotation annotation,Object[] args){
        String[] props = ((ValidateRegionInsertion)annotation).propertyNames();
        int[] orders = ((ValidateRegionInsertion)annotation).propertyOrders();

        if(props!=null && orders!=null){
            return new HandlerMethodPair(userValidator,"validateRegionInsertion",extractParams( props,orders,args));
        }else
        {
            return new HandlerMethodPair(userValidator,"validateRegionInsertion",args);
        }
    }

    private HandlerMethodPair prepareValidateRegionDeletion(Annotation annotation,Object[] args){
        String[] props = ((ValidateRegionDeletion)annotation).propertyNames();
        int[] orders = ((ValidateRegionDeletion)annotation).propertyOrders();

        if(props!=null && orders!=null){
            return new HandlerMethodPair(regionValidator,"validateRegionDeletion",extractParams( props,orders,args));
        }else
        {
            return new HandlerMethodPair(regionValidator,"validateRegionDeletion",args);
        }
    }

    private Object[] extractParams(String[] props,int[] orders,Object[] args){
        if(props.length!=orders.length)
            throw new InternalRunTimeException("Error extracting annotation info");
        if(args==null)
            throw new InternalRunTimeException("Error extracting  annotation (invalid input parameters)");

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

        return params;
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
