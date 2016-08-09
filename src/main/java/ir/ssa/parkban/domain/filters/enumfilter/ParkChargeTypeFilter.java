package ir.ssa.parkban.domain.filters.enumfilter;

import ir.ssa.parkban.domain.enums.ParkChargeType;
import ir.ssa.parkban.vertical.core.domain.filterelement.EnumFilter;
import org.springframework.util.ObjectUtils;

/**
 * Created by Behrouz-ZD on 8/9/2016.
 */
public class ParkChargeTypeFilter  extends EnumFilter<ParkChargeType> {

    @Override
    public void setValues(String[] values) {
        if(ObjectUtils.isEmpty(values))
            this.values = null;
        else {
            this.values = new  ParkChargeType[values.length];
            for(int i=0;i<this.values.length;i++){
                this.values[i] = ParkChargeType.valueOf(values[i]);
            }
        }
    }
}