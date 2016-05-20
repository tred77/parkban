package ir.ssa.parkban.vertical.core.domain.filterelement;

import java.util.Arrays;

/**
 * @author hym
 */
public enum NumberFilterOperation implements FilterOperation {

    EQUAL("eq"),
    GREATER_THAN("gt"),
    LESS_THAN("lt");

    private String value;
    NumberFilterOperation(String val) {
    }

    public String getValue() {
        return value;
    }

    public static NumberFilterOperation getFilterOperation(String val){
        return Arrays.stream(NumberFilterOperation.values())
                .filter(e -> e.value.equals(val))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Illegal Filter Operation Type"));
    }


    @Override
    public String getType() {
        return value;
    }
}
