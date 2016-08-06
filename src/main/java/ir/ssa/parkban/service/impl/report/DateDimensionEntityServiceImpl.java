package ir.ssa.parkban.service.impl.report;

import ir.ssa.parkban.domain.filters.warehouse.DateDimensionEntityFilter;
import ir.ssa.parkban.repository.DateDimensionEntityDAO;
import ir.ssa.parkban.service.bean.DateDimensionEntityService;
import ir.ssa.parkban.service.dto.entity.DateDimensionEntityDto;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Behrouz-ZD on 8/6/2016.
 */
@Service
public class DateDimensionEntityServiceImpl implements DateDimensionEntityService {

    @Autowired
    DateDimensionEntityDAO dateDimensionEntityDAO;

    @Override
    public List<DateDimensionEntityDto> findAllDateDimensionEntity(DateDimensionEntityFilter filter) {
        return ObjectMapper.map(dateDimensionEntityDAO.findAll(filter.getCriteriaExpression()),DateDimensionEntityDto.class);
    }
}
