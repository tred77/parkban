package ir.ssa.parkban.vertical.core.domain.springcustom;

import ir.ssa.parkban.vertical.core.domain.BaseFilter;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by hadoop on 5/27/16.
 */
public interface CustomQueryExecutor<T> extends QueryDslPredicateExecutor<T>{

    List<T> customFindAll(BaseFilter filter);
}
