package ir.ssa.parkban.vertical.core.domain.filterelement;

/**
 * Created by hadoop on 5/20/16.
 */
public class StringFilter {

    private FilterOperation elementOp;
    private String[] values;

    public FilterOperation getElementOp() {
        return elementOp;
    }

    public void setElementOp(FilterOperation elementOp) {
        this.elementOp = elementOp;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
}
