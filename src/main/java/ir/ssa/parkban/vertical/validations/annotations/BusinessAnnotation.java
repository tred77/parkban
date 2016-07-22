package ir.ssa.parkban.vertical.validations.annotations;

import ir.ssa.parkban.vertical.validations.validators.ValidationHandler;

import java.lang.annotation.*;

/**
 * Created by Behrouz-ZD on 7/9/2016.
 */

@Documented
@Target( { ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface BusinessAnnotation {
    Class<? extends ValidationHandler> validatedBy();
}
