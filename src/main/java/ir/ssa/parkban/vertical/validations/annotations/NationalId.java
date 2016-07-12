package ir.ssa.parkban.vertical.validations.annotations;

import ir.ssa.parkban.vertical.validations.validators.constraints.NationalIdConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Behrouz-ZD on 7/9/2016.
 */

@Documented
@Constraint(validatedBy = NationalIdConstraintValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface NationalId {

    long value() default 1234567890;
    String message() default "{NationalId}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
