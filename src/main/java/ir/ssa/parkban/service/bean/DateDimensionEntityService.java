package ir.ssa.parkban.service.bean;

import ir.ssa.parkban.domain.filters.warehouse.DateDimensionEntityFilter;
import ir.ssa.parkban.service.dto.entity.DateDimensionEntityDto;

import java.util.List;

/**
 * Created by Behrouz-ZD on 8/6/2016.
 */
public interface DateDimensionEntityService extends BaseService {

    List<DateDimensionEntityDto> findAllDateDimensionEntity(DateDimensionEntityFilter filter);

}
