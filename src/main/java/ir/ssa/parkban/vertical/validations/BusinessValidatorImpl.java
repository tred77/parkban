package ir.ssa.parkban.vertical.validations;

import ir.ssa.parkban.vertical.exceptions.InternalRunTimeException;
import ir.ssa.parkban.vertical.springcontext.SpeakWithApplicationContext;
import ir.ssa.parkban.vertical.validations.annotations.BusinessAnnotation;
import ir.ssa.parkban.vertical.validations.validators.BusinessValidator;
import ir.ssa.parkban.vertical.validations.validators.HandlerMethodPair;
import ir.ssa.parkban.vertical.validations.validators.ValidationHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Behrouz-ZD on 7/9/2016.
 */
@Component
public class BusinessValidatorImpl implements BusinessValidator {


    @Override
    public void validate(Annotation annotation, Object[] args) {

        HandlerMethodPair handlerMethodPair = prepareValidationHandler(annotation,args);
        if(handlerMethodPair == null || handlerMethodPair.getHandler() == null)
            return;

        if(!StringUtils.isEmpty(handlerMethodPair.getMethodName())){

            String methodName= handlerMethodPair.getMethodName();
            ValidationHandler handler = handlerMethodPair.getHandler();
            Class clazz = ((Object[]) handlerMethodPair.getArguments()).getClass();

            try {
                Object[] argz = new Object[]{handlerMethodPair.getArguments()};
                handler.getClass().getDeclaredMethod(methodName,clazz).invoke(handler,argz);
            } catch (IllegalAccessException e) {
                throw new InternalRunTimeException("Error invoking validator",null);
            } catch (InvocationTargetException e) {
                throw new InternalRunTimeException("Error invoking validator",e.getTargetException());
            } catch (NoSuchMethodException e) {
                throw new InternalRunTimeException("Error invoking validator",null);
            }
        }else{
            handlerMethodPair.getHandler().invoke(handlerMethodPair.getArguments());
        }
    }


    public HandlerMethodPair prepareValidationHandler(Annotation annotation,Object[] args){
        BusinessAnnotation businessAnnotation = annotation.annotationType().getAnnotation(BusinessAnnotation.class);
        if(businessAnnotation!=null && businessAnnotation.validatedBy()!=null){
            ValidationHandler handler = SpeakWithApplicationContext.getRootApplicationContext().getBean(businessAnnotation.validatedBy());

            String[] props = null;
            int[] orders = null;


            Class<? extends Annotation> type = annotation.annotationType();
            System.out.println("Values of " + type.getName());


            try {
                for (Method method : type.getDeclaredMethods()) {
                    if(method.getName().equals("propertyNames")){
                        props =  (String[]) method.invoke(annotation, (Object[])null);
                    }else if(method.getName().equals("propertyOrders")){
                        orders = (int[]) method.invoke(annotation, (Object[])null);
                    }
                }
            } catch (IllegalAccessException e) {
                throw new InternalRunTimeException("BusinessValidatorImpl");
            } catch (InvocationTargetException e) {
                throw new InternalRunTimeException("BusinessValidatorImpl");
            }

            if(props!=null && orders!=null){
                return new HandlerMethodPair(handler,type.getSimpleName(),extractParams( props,orders,args));
            }else
            {
                return new HandlerMethodPair(handler,type.getSimpleName(),args);
            }
        }

        return null;
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

        String[] fieldNames = propertyPath.split("\\.");
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
