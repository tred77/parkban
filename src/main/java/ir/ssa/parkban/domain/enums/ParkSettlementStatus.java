package ir.ssa.parkban.domain.enums;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by hym
 */
public enum ParkSettlementStatus implements Serializable{

    R("Registered"),
    S("Settled");

    private String value;

    ParkSettlementStatus(String value){
        this.value=value;
    }

    public static ParkSettlementStatus fromValue(String value){
        return Arrays.stream(ParkSettlementStatus.values()).filter(v-> v.value.equals(value)).
                findFirst().orElseThrow(()-> new IllegalArgumentException());
    }
}
