package ir.ssa.parkban.domain.enums;

import java.util.Arrays;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public enum ParkChargeType {
    Owner("O"),
    Vehicle("V");

    private String value;

    ParkChargeType(String value){
        this.value=value;
    }

    public static ParkChargeType fromValue(String value){
        return Arrays.stream(ParkChargeType.values()).filter(v-> v.value.equals(value)).
                findFirst().orElseThrow(()-> new IllegalArgumentException());
    }
}
