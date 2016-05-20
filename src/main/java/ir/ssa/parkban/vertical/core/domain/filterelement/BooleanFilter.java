package ir.ssa.parkban.vertical.core.domain.filterelement;

/**
 * Created by hadoop on 5/20/16.
 */
public class BooleanFilter {

    private BooleanFilterOperation elementOp;
    private Boolean[] values;

    public BooleanFilterOperation getElementOp() {
        return elementOp;
    }

    public void setElementOp(BooleanFilterOperation elementOp) {
        this.elementOp = elementOp;
    }

    public Boolean[] getValues() {
        return values;
    }

    public void setValues(Boolean[] values) {
        this.values = values;
    }
}
