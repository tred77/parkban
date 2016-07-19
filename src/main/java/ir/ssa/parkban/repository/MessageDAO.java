package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * author hym
 */
@Repository
public interface MessageDAO extends PagingAndSortingRepository<MessageEntity, Long>, JpaSpecificationExecutor<MessageEntity>, QueryDslPredicateExecutor<MessageEntity> {
}
