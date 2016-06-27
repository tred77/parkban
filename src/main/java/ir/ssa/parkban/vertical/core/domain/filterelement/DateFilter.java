package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;
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

    public Date[] getValues() {
        return values;
    }

    public void setValues(String[] shamsiDates) {
        List<Date> dates = new ArrayList<>();
        Arrays.stream(shamsiDates)
                .forEach( el -> dates.add(DateConverter.convertShamsiToMiladiBeginningOfDay(el)));

        switch (this.elementOp){
            case ONE_DAY:
                if(dates.size() == 1){
                    dates.add(DateConverter.convertShamsiToMiladiEndOfDay(shamsiDates[0]));
                }
                break;
            case ONE_WEEK:
                Date previousSaturday = CalendarUtils.getPreviousSaturdayAtZeroClock(dates.get(0));
                Date nextSaturday = CalendarUtils.getNextSaturdayAtZeroClock(dates.get(0));
                dates.clear();
                dates.add(previousSaturday);
                dates.add(nextSaturday);
                break;
        }
        this.values = dates.toArray(new Date[dates.size()]);
    }

    public void setMiladiValues(Date[] miladiValues){
        this.values = miladiValues;
    }

    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression expression) {
        return elementOp.getCriteriaExpression(expression, values);
    }
}
