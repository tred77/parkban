package ir.ssa.parkban.vertical.validations.validators;

import java.lang.annotation.Annotation;

/**
 * Created by Behrouz-ZD on 7/9/2016.
 */
public interface BusinessValidator {

    void validate(Annotation annotation, Object[] args);
}
