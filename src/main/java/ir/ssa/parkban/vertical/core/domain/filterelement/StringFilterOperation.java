package ir.ssa.parkban.vertical.core.domain.filterelement;

import java.util.Arrays;

/**
 * @author hym
 */
public enum StringFilterOperation implements FilterOperation {

    EQUAL("eq"),
    GREATER_THAN("gt"),
    LESS_THAN("lt"),
    LIKE("lk"),
    LIKE_START("lks"),
    LIKE_END("lke");

    private String value;
    StringFilterOperation(String val) {
    }

    public String getValue() {
        return value;
    }

    public static StringFilterOperation getFilterOperation(String val){
        return Arrays.stream(StringFilterOperation.values())
                .filter(e -> e.value.equals(val))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Illegal Filter Operation Type"));
    }


    @Override
    public String getType() {
        return value;
    }
}
