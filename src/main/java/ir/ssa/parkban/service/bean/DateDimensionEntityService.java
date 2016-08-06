package ir.ssa.parkban.service.bean;

import ir.ssa.parkban.domain.filters.warehouse.DateDimensionEntityFilter;
import ir.ssa.parkban.service.dto.entity.DateDimensionEntityDto;

import java.util.Date;
import java.util.List;

/**
 * Created by Behrouz-ZD on 8/6/2016.
 */
public interface DateDimensionEntityService extends BaseService {

    List<DateDimensionEntityDto> findAllDateDimensionEntity(DateDimensionEntityFilter filter);

    // return shamsi format date : 13950103
    Long getStartDateOfWeekInShamsi(short year,short month,short week);


    // return shamsi format date : 13950103
    Long getStartDateOfWeekInShamsi(Date date);

    // return shamsi format date : 13950103
    Long getEndDateOfWeekInShamsi(short year,short month,short week);

    // return shamsi format date : 13950103
    Long getEndDateOfWeekInShamsi(Date date);

    // return shamsi format date : 13950103
    Long getStartDateOfMonthInShamsi(short year,short month);

    // return shamsi format date : 13950103
    Long getStartDateOfMonthInShamsi(Date date);

    // return shamsi format date : 13950103
    Long getEndDateOfMonthInShamsi(short year,short month);

    // return shamsi format date : 13950103
    Long getEndDateOfMonthInShamsi(Date date);


}
