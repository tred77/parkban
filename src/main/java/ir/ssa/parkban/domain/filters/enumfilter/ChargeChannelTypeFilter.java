package ir.ssa.parkban.domain.filters.enumfilter;

import ir.ssa.parkban.domain.enums.ChargeChannelType;
import ir.ssa.parkban.vertical.core.domain.filterelement.EnumFilter;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Behrouz-ZD on 8/10/2016.
 */
public class ChargeChannelTypeFilter extends EnumFilter<ChargeChannelType> {

    @Override
    public void setValues(String[] values) {
        if(ObjectUtils.isEmpty(values))
            this.values = null;
        else {
            List<ChargeChannelType> tmp = new ArrayList<>();
            Arrays.stream(values).forEach(item->{
                if(item!=null){
                    tmp.add(ChargeChannelType.valueOf(item));
                }
            });
            this.values = new ChargeChannelType[tmp.size()];
            for(int i=0;i<tmp.size();i++)
                this.values[i] =tmp.get(i);
        }
    }
}