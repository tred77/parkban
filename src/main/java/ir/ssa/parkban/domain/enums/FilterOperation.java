package ir.ssa.parkban.domain.enums;

import java.util.Arrays;

/**
 * @author hym
 */
public enum FilterOperation {

    EQUAL("eq"),
    GREATER_THAN("gt"),
    LESS_THAN("lt"),
    LIKE("lk"),
    LIKE_START("lks"),
    LIKE_END("lke");

    private String value;
    FilterOperation(String val) {
    }

    public String getValue() {
        return value;
    }

    public static FilterOperation getFilterOperation(String val){
        return null; /*Arrays.stream(FilterOperation.values())
                .filter(e -> e.value.equals(val))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Illegal Filter Operation Type"));*/
    }
}
