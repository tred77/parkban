package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.MessageReceiverEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * author hym
 */
@Repository
public interface MessageReceiverDAO extends PagingAndSortingRepository<MessageReceiverEntity, Long>, JpaSpecificationExecutor<MessageReceiverEntity>, QueryDslPredicateExecutor<MessageReceiverEntity> {
}
