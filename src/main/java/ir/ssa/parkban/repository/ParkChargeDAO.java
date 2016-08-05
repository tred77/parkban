package ir.ssa.parkban.repository;

import ir.ssa.parkban.domain.entities.ParkCharge;
import ir.ssa.parkban.domain.entities.VehicleOwner;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Behrouz-ZD on 5/20/2016.
 */
@Repository
public interface ParkChargeDAO extends PagingAndSortingRepository<ParkCharge, Long>, JpaSpecificationExecutor<ParkCharge>, QueryDslPredicateExecutor<ParkCharge> {

    ParkCharge findByPlateNumber(String plateNumber);

    ParkCharge findByOwner(VehicleOwner owner);

}

