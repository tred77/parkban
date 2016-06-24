package ir.ssa.parkban.domain.enums;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
public enum ParkTimeStatus implements Serializable{

    R("Registered"),
    C("Calculated");

    private String value;

    ParkTimeStatus(String value){
        this.value=value;
    }

    public static ParkTimeStatus fromValue(String value){
        return Arrays.stream(ParkTimeStatus.values()).filter(v-> v.value.equals(value)).
                findFirst().orElseThrow(()-> new IllegalArgumentException());
    }
}
