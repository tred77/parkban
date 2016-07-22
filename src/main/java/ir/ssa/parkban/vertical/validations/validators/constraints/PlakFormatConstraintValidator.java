package ir.ssa.parkban.vertical.validations.validators.constraints;

import ir.ssa.parkban.vertical.validations.annotations.PlakFormat;
import org.springframework.util.ObjectUtils;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Behrouz-ZD on 7/22/2016.
 */
public class PlakFormatConstraintValidator implements ConstraintValidator<PlakFormat, String> {
    @Override
    public void initialize(PlakFormat constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(ObjectUtils.isEmpty(value))
            return true;
        return true;
    }
}
