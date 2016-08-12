package ir.ssa.parkban.vertical.core.domain;


import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * Created by hadoop on 5/20/16.
 */
public interface FilterCriteriaProvider {
    BooleanExpression getCriteriaExpression(Path... entityPath);
}
