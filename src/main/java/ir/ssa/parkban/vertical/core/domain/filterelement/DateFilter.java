package ir.ssa.parkban.vertical.core.domain.filterelement;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;
import ir.ssa.parkban.vertical.core.util.DateUtils.DateConverter;

import java.util.ArrayList;
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
        for (String sDate : shamsiDates) {
            dates.add(DateConverter.convertShamsiToMiladiBeginningOfDay(sDate));
        }

        if (elementOp == DateFilterOperation.ONE_DAY
                && dates.size() == 1 ) {
            dates.add(DateConverter.convertShamsiToMiladiEndOfDay(shamsiDates[0]));
        }
        this.values = dates.toArray(new Date[dates.size()]);
    }

    @Override
    public BooleanExpression getCriteriaExpression(SimpleExpression expression) {
        return elementOp.getCriteriaExpression(expression, values);
    }
}
