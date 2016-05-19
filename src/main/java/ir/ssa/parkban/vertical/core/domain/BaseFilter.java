package ir.ssa.parkban.vertical.core.domain;

import ir.ssa.parkban.domain.enums.FilterOperation;

/**
 * @author hym
 */
public class BaseFilter {

    private Long id;
    private FilterOperation idOp;

    private PagingInfo pagingInfo;

    public void setIdOp(FilterOperation idOp) {
        this.idOp = idOp;
    }

    public PagingInfo getPagingInfo() {
        return pagingInfo;
    }

    public void setPagingInfo(PagingInfo pagingInfo) {
        this.pagingInfo = pagingInfo;
    }

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
