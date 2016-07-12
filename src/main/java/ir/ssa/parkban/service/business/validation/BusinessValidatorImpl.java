package ir.ssa.parkban.service.business.validation;

import ir.ssa.parkban.vertical.exceptions.InternalRunTimeException;
import ir.ssa.parkban.vertical.validations.validators.BusinessValidator;
import ir.ssa.parkban.vertical.validations.validators.HandlerMethodPair;
import ir.ssa.parkban.vertical.validations.validators.ValidationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Behrouz-ZD on 7/9/2016.
 */
@Component
public class BusinessValidatorImpl implements BusinessValidator {

    @Autowired
    CustomizedValidatorProvider customizedValidatorProvider;

    @Override
    public void validate(Annotation annotation, Object[] args) {

        HandlerMethodPair handlerMethodPair = customizedValidatorProvider.prepareValidationHandler(annotation,args);
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
}
