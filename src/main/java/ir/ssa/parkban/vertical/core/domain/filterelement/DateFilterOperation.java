package ir.ssa.parkban.vertical.core.domain.filterelement;

import java.util.Arrays;

/**
 * @author hym
 */
public enum DateFilterOperation implements FilterOperation {

    EQUAL("eq"),
    GREATER_THAN("gt"),
    LESS_THAN("lt"),
    BETWEEN("bw");

    private String value;
    DateFilterOperation(String val) {
    }

    public String getValue() {
        return value;
    }

    public static DateFilterOperation getFilterOperation(String val){
        return Arrays.stream(DateFilterOperation.values())
                .filter(e -> e.value.equals(val))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Illegal Filter Operation Type"));
    }


    @Override
    public String getType() {
        return value;
    }
}
