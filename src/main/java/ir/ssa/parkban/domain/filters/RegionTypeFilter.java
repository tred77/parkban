package ir.ssa.parkban.domain.filters;

import ir.ssa.parkban.service.dto.enums.RegionNodeTypeDto;
import ir.ssa.parkban.vertical.core.domain.filterelement.EnumFilter;
import org.springframework.util.ObjectUtils;


/**
 * Created by Behrouz-ZD on 7/17/2016.
 */
public class RegionTypeFilter extends EnumFilter<RegionNodeTypeDto> {

    @Override
    public String[] getValues() {
        if(ObjectUtils.isEmpty(this.values))
            return null;
        String[] vals = new  String[values.length];
        for(int i=0;i<this.values.length;i++){
            vals[i] = RegionNodeTypeDto.value((RegionNodeTypeDto)values[i]);
        }
        return vals;

    }

    @Override
    public void setValues(String[] values) {
        if(ObjectUtils.isEmpty(values))
            this.values = null;
        else {
            this.values = new  RegionNodeTypeDto[values.length];
            for(int i=0;i<this.values.length;i++){
                this.values[i] = RegionNodeTypeDto.fromValue(Short.valueOf(values[i]));
            }
        }
    }
}
