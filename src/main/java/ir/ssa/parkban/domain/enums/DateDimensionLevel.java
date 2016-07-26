package ir.ssa.parkban.domain.enums;

import java.util.Arrays;

/**
 * author hym
 */
public enum DateDimensionLevel {
    DAY("D"),
    WEEK("W"),
    MONTH("M");

    private String value;

    DateDimensionLevel(String value){
        this.value=value;
    }

    public static DateDimensionLevel fromValue(String value){
        return Arrays.stream(DateDimensionLevel.values()).filter(v-> v.value.equals(value)).
                findFirst().orElseThrow(()-> new IllegalArgumentException());
    }
}
