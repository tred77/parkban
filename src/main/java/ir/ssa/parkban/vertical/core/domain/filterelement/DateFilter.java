package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.BooleanExpression;
import ir.ssa.parkban.vertical.core.util.DateUtils.CalendarUtils;
import ir.ssa.parkban.vertical.core.util.DateUtils.DateConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by hadoop on 5/20/16.
 */
public class DateFilter implements Filter {

    private DateFilterOperation elementOp;
    private Date[] values;

    public DateFilterOperation getElementOp() {
        return elementOp;
    }

    public void setElementOp(String elementOp) {
        this.elementOp = DateFilterOperation.getFilterOperation(elementOp);
    }

    public void setEnumElementOp(DateFilterOperation elementOp) {
        this.elementOp = elementOp;
    }

    public Date[] getValues() {
        return values;
    }

    public void setValues(Date[] dates) {
        this.values = dates;
        List<Date> lDate = new ArrayList<>(Arrays.asList(dates));
        switch (this.elementOp){
            case ONE_DAY:
                if(lDate.size() == 1){
                    lDate.add(DateConverter.getMiladiDateEndOfDay(dates[0]));
                }
                break;
            case ONE_WEEK:
                Date previousSaturday = CalendarUtils.getPreviousSaturdayAtZeroClock(lDate.get(0));
                Date nextSaturday = CalendarUtils.getNextSaturdayAtZeroClock(lDate.get(0));
                //lDate.clear();
                List<Date> temp = new ArrayList<>();
                temp.add(previousSaturday);
                temp.add(nextSaturday);
                lDate = temp;
                break;
        }
        this.values = lDate.toArray(new Date[lDate.size()]);
    }

    public void setValue(Date date) {
        this.setValues(new Date[]{date});
    }

    public void setMiladiValues(Date[] miladiValues){
        this.values = miladiValues;
    }

    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression expression) {
        return elementOp.getCriteriaExpression(expression, values);
    }
}
