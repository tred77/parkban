package ir.ssa.parkban.service.impl.report;

import ir.ssa.parkban.domain.enums.DateDimensionLevel;
import ir.ssa.parkban.domain.filters.ComparedRegionParkInfoFilter;
import ir.ssa.parkban.domain.filters.RegionParkInformationFilter;
import ir.ssa.parkban.domain.filters.enumfilter.DateLevelFilter;
import ir.ssa.parkban.repository.warehouse.RegionParkInformationDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.report.RegionParkInformationService;
import ir.ssa.parkban.service.dto.entity.RegionParkInformationDto;
import ir.ssa.parkban.service.dto.enums.DateDimensionLevelDto;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.EnumFilterOperation;
import ir.ssa.parkban.vertical.core.util.DateUtils.CalendarUtils;
import ir.ssa.parkban.vertical.core.util.DateUtils.DateConverter;
import ir.ssa.parkban.vertical.core.util.DateUtils.DateUtils;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Behrouz-ZD on 7/26/2016.
 */
@Service
public class RegionParkInformationServiceImpl implements RegionParkInformationService {


    @Autowired
    RegionParkInformationDAO regionParkInformationDAO;

    @Override
    public List<RegionParkInformationDto> getRegionParkInformation(RegionParkInformationFilter filter) {
        BaseService.setEntityGraph(regionParkInformationDAO,filter,"findAll");

        // shift start date and end date
        if(filter.getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.MONTH)){
            filter.getStartDate().setValues(new Date[]{DateUtils.shiftShamsyToBeginningOfMonth(filter.getStartDate().getValues()[0])});
            filter.getStartDate().setElementOp("gt");
            filter.getEndDate().setValues(new Date[]{DateUtils.shiftShamsyToEndOfMonth(filter.getEndDate().getValues()[0])});
            filter.getEndDate().setElementOp("lt");
        }

        return ObjectMapper.map(regionParkInformationDAO.findAll(filter.getCriteriaExpression()),RegionParkInformationDto.class);
    }

    @Override
    public List<RegionParkInformationDto> getComparedRegionParkInformation(@Validated @NotNull ComparedRegionParkInfoFilter filter){
        RegionParkInformationFilter informationFilter = new RegionParkInformationFilter();
        DateLevelFilter dateLevelFilter = new DateLevelFilter();
        dateLevelFilter.setEnumElementOp(EnumFilterOperation.EQUAL);
        informationFilter.addGraphPath("region");
        BaseService.setEntityGraph(regionParkInformationDAO,informationFilter,"findAll");

        if(filter.getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.DAY)){
            dateLevelFilter.setEnumValue(DateDimensionLevel.DAY);
            informationFilter.setDateDimensionLevel(dateLevelFilter);

            DateFilter startDate = new DateFilter();
            startDate.setElementOp("gt");

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(filter.getPeriodDate().getValues()[0]);
            calendar.add(Calendar.DAY_OF_MONTH,-1);
            startDate.setValues(new Date[]{calendar.getTime()});

            DateFilter endDate = new DateFilter();
            endDate.setElementOp("lt");
            calendar.add(Calendar.DAY_OF_MONTH,2);
            endDate.setValues(new Date[]{calendar.getTime()});

            informationFilter.setStartDate(startDate);
            informationFilter.setEndDate(endDate);

            return ObjectMapper.map(regionParkInformationDAO.findAll(informationFilter.getCriteriaExpression()),RegionParkInformationDto.class);

        }else if(filter.getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.WEEK)){

            //

        }else if(filter.getDateDimensionLevel().getEnumValue().equals(DateDimensionLevel.MONTH)){

            dateLevelFilter.setEnumValue(DateDimensionLevel.MONTH);
            informationFilter.setDateDimensionLevel(dateLevelFilter);

            Integer moth = (Integer) filter.getMonth().getValues()[0];
            Integer year = (Integer) filter.getYear().getValues()[0];
            DateFilter startDate = new DateFilter();
            DateFilter endDate = new DateFilter();
            String startShamsiDate = year+"/"+moth+"/01";
            String endShamsiDate = year+"/"+moth+"/29";
            startDate.setElementOp("gt");
            startDate.setValues(new Date[]{DateConverter.convertShamsiToMiladiBeginningOfDay(startShamsiDate)});
            endDate.setElementOp("lt");
            endDate.setValues(new Date[]{DateConverter.convertShamsiToMiladiBeginningOfDay(endShamsiDate)});


            informationFilter.setStartDate(startDate);
            informationFilter.setEndDate(endDate);
            return ObjectMapper.map(regionParkInformationDAO.findAll(informationFilter.getCriteriaExpression()),RegionParkInformationDto.class);


        }
        return null;
    }
}
