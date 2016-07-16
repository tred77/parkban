package ir.ssa.parkban.service.dto.enums;

import java.util.Arrays;

/**
 * Created by Behrouz-ZD on 7/15/2016.
 */
public enum RegionNodeTypeDto {
    ROOT((short)0),
    MIDDLE((short)1),
    LEAF((short)2);

    private short value;

    RegionNodeTypeDto(short value){
        this.value=value;
    }

    public static RegionNodeTypeDto fromValue(short value){
        return Arrays.stream(RegionNodeTypeDto.values()).filter(item->item.value==value).
                findFirst().orElseThrow(()->new IllegalArgumentException("Illegal argument for Region Node Type"));
    }
}
