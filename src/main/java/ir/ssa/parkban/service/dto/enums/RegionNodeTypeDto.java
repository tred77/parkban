package ir.ssa.parkban.service.dto.enums;

import java.util.Arrays;

/**
 * Created by Behrouz-ZD on 7/15/2016.
 */
public enum RegionNodeTypeDto {
    ROOT("R"),
    MIDDLE("M"),
    LEAF("L");

    private String value;

    RegionNodeTypeDto(String value){
        this.value=value;
    }

    public static RegionNodeTypeDto fromValue(short value){
        return Arrays.stream(RegionNodeTypeDto.values()).filter(item->item.value.equals(value)).
                findFirst().orElseThrow(()->new IllegalArgumentException("Illegal argument for Region Node Type"));
    }

    public static String value(RegionNodeTypeDto itm){
        RegionNodeTypeDto[] vals = RegionNodeTypeDto.values();
        for(RegionNodeTypeDto it : vals){
            if (it==itm)
                return it.value;
        }

        return null;
    }
}
