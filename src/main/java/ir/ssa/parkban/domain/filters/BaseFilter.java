package ir.ssa.parkban.domain.filters;

import ir.ssa.parkban.domain.enums.FilterOperation;

/**
 * @author hym
 */
public class BaseFilter {

    private Long id;
    private FilterOperation idOp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FilterOperation getIdOp() {
        return idOp;
    }

    public void setIdOp(String idOp) {
        this.idOp = FilterOperation.getFilterOperation(idOp);
    }
}
