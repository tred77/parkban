package ir.ssa.parkban.vertical.validations.annotations;

import ir.ssa.parkban.vertical.validations.BindingCategory;
import ir.ssa.parkban.vertical.validations.validators.constraints.EmailConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Behrouz-ZD on 7/9/2016.
 */
@Documented
@Constraint(validatedBy = EmailConstraintValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EMail {

    String value() default "a@yahoo.com";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
