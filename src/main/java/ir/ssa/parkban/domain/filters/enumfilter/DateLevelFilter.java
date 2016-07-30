package ir.ssa.parkban.domain.filters.enumfilter;

import ir.ssa.parkban.domain.enums.DateDimensionLevel;
import ir.ssa.parkban.vertical.core.domain.filterelement.EnumFilter;
import org.springframework.util.ObjectUtils;


/**
 * author hym
 */
public class DateLevelFilter extends EnumFilter<DateDimensionLevel> {

    @Override
    public void setValues(String[] values) {
        if(ObjectUtils.isEmpty(values))
            this.values = null;
        else {
            this.values = new  DateDimensionLevel[values.length];
            for(int i=0;i<this.values.length;i++){
                this.values[i] = DateDimensionLevel.valueOf(values[i]);
            }
        }
    }
}
