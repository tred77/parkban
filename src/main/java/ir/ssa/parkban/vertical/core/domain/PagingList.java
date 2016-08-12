package ir.ssa.parkban.vertical.core.domain;

import java.util.List;

/**
 * Created by Behrouz-ZD on 8/12/2016.
 */
public class PagingList<T> {

    private List<T> content;
    private long totalCount=-1;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
