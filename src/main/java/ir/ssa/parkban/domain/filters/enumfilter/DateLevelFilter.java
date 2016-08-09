package ir.ssa.parkban.domain.filters.enumfilter;

import ir.ssa.parkban.domain.enums.DateDimensionLevel;
import ir.ssa.parkban.vertical.core.domain.filterelement.EnumFilter;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * author hym
 */
public class DateLevelFilter extends EnumFilter<DateDimensionLevel> {

    @Override
    public void setValues(String[] values) {
        if(ObjectUtils.isEmpty(values))
            this.values = null;
        else {
            List<DateDimensionLevel> tmp = new ArrayList<>();
            Arrays.stream(values).forEach(item->{
                if(item!=null){
                    tmp.add(DateDimensionLevel.valueOf(item));
                }
            });
            this.values = new DateDimensionLevel[tmp.size()];
            for(int i=0;i<tmp.size();i++)
                this.values[i] =tmp.get(i);
        }
    }
}
