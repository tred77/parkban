package ir.ssa.parkban.service.business.validation.annotations;

import ir.ssa.parkban.vertical.validations.annotations.BusinessAnnotation;
import java.lang.annotation.*;

/**
 * Created by Behrouz-ZD on 7/9/2016.
 */

@Documented
@Target( { ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@BusinessAnnotation
public @interface DuplicatedUser {

    String[] propertyNames() default {"username","nationalId"};
    int[] propertyOrders() default {0,0};
    Class<?>[] groups() default {};

}
