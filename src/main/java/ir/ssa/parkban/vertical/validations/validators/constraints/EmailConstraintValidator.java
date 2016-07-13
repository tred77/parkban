package ir.ssa.parkban.vertical.validations.validators.constraints;

import ir.ssa.parkban.vertical.validations.annotations.EMail;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Behrouz-ZD on 7/9/2016.
 */
public class EmailConstraintValidator implements ConstraintValidator<EMail, String> {

    @Override
    public void initialize(EMail email) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        return false;

    }
}
