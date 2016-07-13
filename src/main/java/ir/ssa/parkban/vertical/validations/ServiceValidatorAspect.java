package ir.ssa.parkban.vertical.validations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

import ir.ssa.parkban.vertical.exceptions.ArgumentRequiredException;
import ir.ssa.parkban.vertical.validations.annotations.BusinessAnnotation;
import ir.ssa.parkban.vertical.validations.validators.BusinessValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;

/**
 * Created by Behrouz-ZD on 7/9/2016.
 */
@Aspect
@Component
public class ServiceValidatorAspect {

    @Autowired
    private Validator validator;

    @Autowired
    private BusinessValidator businessValidator;


    @Before("execution(* ir.ssa.parkban.service.impl.BaseInformationServiceImpl.*(@org.springframework.validation.annotation.Validated (*)))")
    public void valid(JoinPoint jp) throws NoSuchMethodException {

        Set<ConstraintViolation<?>> violations = new HashSet<ConstraintViolation<?>>();
        Method interfaceMethod = ((MethodSignature)jp.getSignature()).getMethod();
        Method implementationMethod = jp.getTarget().getClass().getMethod(interfaceMethod.getName(), interfaceMethod.getParameterTypes());

        // Fire argument validation by @Validated
        Annotation[][] annotationParameters = implementationMethod.getParameterAnnotations();
        for (int i = 0; i < annotationParameters.length; i++) {
            Annotation[] annotations = annotationParameters[i];
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(Validated.class)){
                    Object arg = jp.getArgs()[i];
                    violations.addAll(validator.validate(arg,BusinessCategory.class));
                }else if(annotation.getClass().equals(NotNull.class) && ObjectUtils.isEmpty(jp.getArgs())){
                    throw new ArgumentRequiredException("");
                }
            }
        }
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        // Fire business validation by @BusinessAnnotation
        Arrays.stream(implementationMethod.getAnnotations()).forEach(annotation->{
            Annotation type = Arrays.stream(annotation.annotationType().getDeclaredAnnotations())
                    .filter(item->item.annotationType().equals(BusinessAnnotation.class)).
                    findFirst().orElse(null);

            if(type!=null){
                businessValidator.validate(annotation,jp.getArgs());
            }
        });
    }


    private boolean hasBusinessCategory(Validated annotation){
        return (Arrays.stream(annotation.value()).
                filter(item->item.equals(BusinessCategory.class)).
                findFirst().orElse(null)!=null)?true:false;
    }

}
