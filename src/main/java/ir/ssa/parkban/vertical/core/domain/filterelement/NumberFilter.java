package ir.ssa.parkban.vertical.core.domain.filterelement;

/**
 * Created by hadoop on 5/20/16.
 */
public class NumberFilter {

    private FilterOperation elementOp;
    private Number[] values;

    public FilterOperation getElementOp() {
        return elementOp;
    }

    public void setElementOp(FilterOperation elementOp) {
        this.elementOp = elementOp;
    }

    public Number[] getValues() {
        return values;
    }

    public void setValues(Number[] values) {
        this.values = values;
    }
}
