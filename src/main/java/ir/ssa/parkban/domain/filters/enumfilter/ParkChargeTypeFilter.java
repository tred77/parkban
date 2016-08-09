package ir.ssa.parkban.domain.filters.enumfilter;

import ir.ssa.parkban.domain.enums.ParkChargeType;
import ir.ssa.parkban.vertical.core.domain.filterelement.EnumFilter;
import org.jfree.chart.LegendItemSource;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Behrouz-ZD on 8/9/2016.
 */
public class ParkChargeTypeFilter  extends EnumFilter<ParkChargeType> {

    @Override
    public void setValues(String[] values) {
        if(ObjectUtils.isEmpty(values))
            this.values = null;
        else {
            List<ParkChargeType> tmp = new ArrayList<>();
            Arrays.stream(values).forEach(item->{
                if(item!=null){
                    tmp.add(ParkChargeType.valueOf(item));
                }
            });
            this.values = new ParkChargeType[tmp.size()];
            for(int i=0;i<tmp.size();i++)
                this.values[i] =tmp.get(i);
        }
    }
}