package ir.ssa.parkban.service.impl.report;

import ir.ssa.parkban.domain.enums.DateDimensionLevel;
import ir.ssa.parkban.domain.filters.warehouse.DateDimensionEntityFilter;
import ir.ssa.parkban.domain.filters.warehouse.ParkbanProceedInformationFilter;
import ir.ssa.parkban.repository.warehouse.ParkbanProceedInformationDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.DateDimensionEntityService;
import ir.ssa.parkban.service.bean.report.ParkbanProceedInformationService;
import ir.ssa.parkban.service.dto.entity.ParkbanProceedInformationDto;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilterOperation;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Behrouz-ZD on 8/4/2016.
 */
@Service
public class ParkbanProceedInformationServiceImpl implements ParkbanProceedInformationService{

    @Autowired
    ParkbanProceedInformationDAO parkbanProceedInformationDAO;

    @Autowired
    DateDimensionEntityService dateDimensionEntityService;

    @Override
    public List<ParkbanProceedInformationDto> getParkbanProceedInformation(ParkbanProceedInformationFilter filter) {
        ParkbanProceedInformationFilter parkbanProceedInformationFilter =  prepareParkbanProceedInformationFilter(filter);
        parkbanProceedInformationFilter.addGraphPath("region");
        parkbanProceedInformationFilter.addGraphPath("parkban");
        parkbanProceedInformationFilter.addGraphPath("dateDimensionEntity");
        BaseService.setEntityGraph(parkbanProceedInformationDAO,parkbanProceedInformationFilter,"findAll");
        return ObjectMapper.map(parkbanProceedInformationDAO.findAll(parkbanProceedInformationFilter.getCriteriaExpression()),ParkbanProceedInformationDto.class);
    }


    private ParkbanProceedInformationFilter prepareParkbanProceedInformationFilter(ParkbanProceedInformationFilter filter){

        ParkbanProceedInformationFilter parkbanProceedInformationFilter = new ParkbanProceedInformationFilter();
        parkbanProceedInformationFilter.setDateDimensionEntity(new DateDimensionEntityFilter());
        parkbanProceedInformationFilter.setRegion(filter.getRegion());
        parkbanProceedInformationFilter.getDateDimensionEntity().setDateDimensionLevel(filter.getDateDimensionEntity().getDateDimensionLevel());

        Long startDate=dateDimensionEntityService.prepareStartDateDimensionLevel((DateDimensionLevel)filter.getDateDimensionEntity().getDateDimensionLevel().getEnumValue(),filter.getDateDimensionEntity().getStartDate().getValues()[0]);
        Long endDate=dateDimensionEntityService.prepareEndDateDimensionLevel((DateDimensionLevel)filter.getDateDimensionEntity().getDateDimensionLevel().getEnumValue(),filter.getDateDimensionEntity().getEndDate().getValues()[0]);

        parkbanProceedInformationFilter.getDateDimensionEntity().setStartDateFa(new NumberFilter());
        parkbanProceedInformationFilter.getDateDimensionEntity().getStartDateFa().setValue(startDate);
        parkbanProceedInformationFilter.getDateDimensionEntity().getStartDateFa().setEnumElementOp(NumberFilterOperation.GREATER_EQUAL_THAN);

        parkbanProceedInformationFilter.getDateDimensionEntity().setEndDateFa(new NumberFilter());
        parkbanProceedInformationFilter.getDateDimensionEntity().getEndDateFa().setEnumElementOp(NumberFilterOperation.LESS_EQUAL_THAN);
        parkbanProceedInformationFilter.getDateDimensionEntity().getEndDateFa().setValue(endDate);

        return parkbanProceedInformationFilter;
    }
}
