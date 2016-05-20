package ir.ssa.parkban.vertical.core.domain;

import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;

/**
 * @author hym
 */
public abstract class BaseFilter implements FilterCriteriaProvider{

    private NumberFilter id;

    private PagingInfo pagingInfo;


    public PagingInfo getPagingInfo() {
        return pagingInfo;
    }

    public void setPagingInfo(PagingInfo pagingInfo) {
        this.pagingInfo = pagingInfo;
    }

    public NumberFilter getId() {
        return id;
    }

    public void setId(NumberFilter id) {
        this.id = id;
    }
}
