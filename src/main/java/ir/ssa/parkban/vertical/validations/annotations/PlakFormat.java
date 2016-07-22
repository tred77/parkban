package ir.ssa.parkban.vertical.validations.annotations;

import ir.ssa.parkban.vertical.validations.BindingCategory;
import ir.ssa.parkban.vertical.validations.validators.constraints.PlakFormatConstraintValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Behrouz-ZD on 7/22/2016.
 */

@Documented
@Constraint(validatedBy = PlakFormatConstraintValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PlakFormat {

    String value() default "";
    String message() default "{PlakFormat}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
