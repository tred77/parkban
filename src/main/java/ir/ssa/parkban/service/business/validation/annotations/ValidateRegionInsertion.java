package ir.ssa.parkban.service.business.validation.annotations;

import ir.ssa.parkban.vertical.validations.annotations.BusinessAnnotation;

import java.lang.annotation.*;

/**
 * Created by Behrouz-ZD on 7/19/2016.
 */

@Documented
@Target( { ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@BusinessAnnotation
public @interface ValidateRegionInsertion {

    String[] propertyNames() default {"region"};
    int[] propertyOrders() default {0};
    Class<?>[] groups() default {};
}