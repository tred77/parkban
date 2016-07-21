package ir.ssa.parkban.service.business.validation.annotations;

import ir.ssa.parkban.service.business.validation.BusinessRegionValidator;
import ir.ssa.parkban.vertical.validations.annotations.BusinessAnnotation;

import java.lang.annotation.*;

/**
 * Created by Behrouz-ZD on 7/18/2016.
 */

@Documented
@Target( { ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@BusinessAnnotation(validatedBy = BusinessRegionValidator.class)
public @interface ValidateRegionDeletion {

    String[] propertyNames() default {"regionId"};
    int[] propertyOrders() default {0};
    Class<?>[] groups() default {};

}
