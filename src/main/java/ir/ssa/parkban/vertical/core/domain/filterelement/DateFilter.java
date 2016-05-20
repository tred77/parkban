package ir.ssa.parkban.vertical.core.domain.filterelement;

import java.util.Date;

/**
 * Created by hadoop on 5/20/16.
 */
public class DateFilter {

    private DateFilterOperation elementOp;
    private Date[] values;

    public DateFilterOperation getElementOp() {
        return elementOp;
    }

    public void setElementOp(DateFilterOperation elementOp) {
        this.elementOp = elementOp;
    }

    public Date[] getValues() {
        return values;
    }

    public void setValues(Date[] values) {
        this.values = values;
    }
}
