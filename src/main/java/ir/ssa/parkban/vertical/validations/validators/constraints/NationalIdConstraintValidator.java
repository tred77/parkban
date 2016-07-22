package ir.ssa.parkban.vertical.validations.validators.constraints;

import ir.ssa.parkban.vertical.validations.annotations.NationalId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Created by Behrouz-ZD on 7/9/2016.
 */
public class NationalIdConstraintValidator implements ConstraintValidator<NationalId, Long> {

    @Override
    public void initialize(NationalId nationalId) {
    }

    @Override
    public boolean isValid(Long nationalId, ConstraintValidatorContext constraintValidatorContext) {

        if(nationalId==null)
            return true;

        String nationalCode = String.valueOf(nationalId);
        if (nationalCode.length() != 10)
            return false;

        String[] allDigitEqual = new String[]{"0000000000","1111111111","2222222222","3333333333","4444444444","5555555555","6666666666","7777777777","8888888888","9999999999"};

        if (Arrays.asList(allDigitEqual).contains(nationalCode))
            return false;

        int num10 = Integer.valueOf(String.valueOf(nationalCode.charAt(0)))*10;
        int num9 = Integer.valueOf(String.valueOf(nationalCode.charAt(1)))*9;
        int num8 = Integer.valueOf(String.valueOf(nationalCode.charAt(2)))*8;
        int num7 = Integer.valueOf(String.valueOf(nationalCode.charAt(3)))*7;
        int num6 = Integer.valueOf(String.valueOf(nationalCode.charAt(4)))*6;
        int num5 = Integer.valueOf(String.valueOf(nationalCode.charAt(5)))*5;
        int num4 = Integer.valueOf(String.valueOf(nationalCode.charAt(6)))*4;
        int num3 = Integer.valueOf(String.valueOf(nationalCode.charAt(7)))*3;
        int num2 = Integer.valueOf(String.valueOf(nationalCode.charAt(8)))*2;
        int a = Integer.valueOf(String.valueOf(nationalCode.charAt(9)));

        int b = num2+num3+num4+num5+num6+num7+num8+num9+num10;
        int c = b%11;

        return (((c < 2) && (a == c)) || ((c >= 2) && ((11 - c) == a)));

    }
}
