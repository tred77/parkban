package ir.ssa.parkban.domain.enums;

import java.util.Arrays;

/**
 * Created by Behrouz-ZD on 7/14/2016.
 */
public enum RegionNodeType {
    ROOT("R"),
    MIDDLE("M"),
    LEAF("L");

    private String value;

    RegionNodeType(String value){
        this.value=value;
    }

    public static RegionNodeType fromValue(short value){
        return Arrays.stream(RegionNodeType.values()).filter(item->item.value.equals(value)).
                findFirst().orElseThrow(()->new IllegalArgumentException("Illegal argument for Region Node Type"));
    }
}
