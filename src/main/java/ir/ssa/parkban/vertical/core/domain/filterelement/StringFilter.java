package ir.ssa.parkban.vertical.core.domain.filterelement;

/**
 * Created by hadoop on 5/20/16.
 */
public class StringFilter {

    private StringFilterOperation elementOp;
    private String[] values;

    public StringFilterOperation getElementOp() {
        return elementOp;
    }

    public void setElementOp(StringFilterOperation elementOp) {
        this.elementOp = elementOp;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
}
