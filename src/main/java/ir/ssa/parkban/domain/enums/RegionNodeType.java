package ir.ssa.parkban.domain.enums;

import java.util.Arrays;

/**
 * Created by Behrouz-ZD on 7/14/2016.
 */
public enum RegionNodeType {
    ROOT((short)0),
    MIDDLE((short)1),
    LEAF((short)2);

    private short value;

    RegionNodeType(short value){
        this.value=value;
    }

    public static RegionNodeType fromValue(short value){
        return Arrays.stream(RegionNodeType.values()).filter(item->item.value==value).
                findFirst().orElseThrow(()->new IllegalArgumentException("Illegal argument for Region Node Type"));
    }
}
