package ir.ssa.parkban.controller.dto.enums;

import java.util.Arrays;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public enum ParkChargeTypeDto {

    Owner("O"),
    Vehicle("V");

    private String value;

    ParkChargeTypeDto(String value){
        this.value=value;
    }

    public static ParkChargeTypeDto fromValue(String value){
        return Arrays.stream(ParkChargeTypeDto.values()).filter(v-> v.value.equals(value)).
                findFirst().orElseThrow(()-> new IllegalArgumentException());
    }
}
