package ir.ssa.parkban.domain.filters;

import ir.ssa.parkban.service.dto.enums.RegionNodeTypeDto;
import ir.ssa.parkban.vertical.core.domain.filterelement.EnumFilter;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Behrouz-ZD on 7/17/2016.
 */
public class RegionTypeFilter extends EnumFilter<RegionNodeTypeDto> {

    @Override
    public void setValues(String[] values) {
        if(ObjectUtils.isEmpty(values))
            this.values = null;
        else {
            List<RegionNodeTypeDto> tmp = new ArrayList<>();
            Arrays.stream(values).forEach(item->{
                if(item!=null){
                    tmp.add(RegionNodeTypeDto.valueOf(item));
                }
            });
            this.values = new RegionNodeTypeDto[tmp.size()];
            for(int i=0;i<tmp.size();i++)
                this.values[i] =tmp.get(i);
        }
    }
}
