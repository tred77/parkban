package ir.ssa.parkban.service.impl.report;

import ir.ssa.parkban.domain.enums.DateDimensionLevel;
import ir.ssa.parkban.domain.filters.warehouse.DateDimensionEntityFilter;
import ir.ssa.parkban.domain.filters.warehouse.ParkbanProceedInformationFilter;
import ir.ssa.parkban.repository.warehouse.ParkbanProceedInformationDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.DateDimensionEntityService;
import ir.ssa.parkban.service.bean.report.ParkbanProceedInformationService;
import ir.ssa.parkban.service.dto.entity.ParkbanProceedInformationDto;
import ir.ssa.parkban.vertical.core.domain.PagingList;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.NumberFilterOperation;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.HashMap;


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
    public PagingList<ParkbanProceedInformationDto> getParkbanProceedInformation(ParkbanProceedInformationFilter filter) {
        return getParkbanProceedInformations(filter);
    }

    @Override
    public byte[] printParkbanProceedInformation(ParkbanProceedInformationFilter filter) {

        PagingList<ParkbanProceedInformationDto> list =  getParkbanProceedInformations(filter);

        JasperReportBuilder report = DynamicReports.report();
        report
                .columns(
                        Columns.column("تاریخ", "dateDimensionEntity.title", DataTypes.stringType()),
                        Columns.column("مقدار شارژ دریافتی", "chargeAmount", DataTypes.bigDecimalType()),
                        Columns.column("تعداد ثبت پارک", "parkRegisterCount", DataTypes.longType()),
                        Columns.column("از", "dateDimensionEntity.startDate", DataTypes.dateType()),
                        Columns.column("تا", "dateDimensionEntity.endDate", DataTypes.dateType()))
                .title(//title of the report
                        Components.text("گزارش")
                                .setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY()).setDataSource(list.getContent());


        byte[] breortArray = null;

        try {
            breortArray =  JasperRunManager.runReportToPdf(report.toJasperReport(), new HashMap());
        } catch (JRException e) {
            e.printStackTrace();
        } catch (DRException e) {
            e.printStackTrace();
        }

        return breortArray;
    }


    private PagingList<ParkbanProceedInformationDto> getParkbanProceedInformations(ParkbanProceedInformationFilter filter) {
        ParkbanProceedInformationFilter parkbanProceedInformationFilter =  prepareParkbanProceedInformationFilter(filter);
        parkbanProceedInformationFilter.addGraphPath("region");
        parkbanProceedInformationFilter.addGraphPath("parkban");
        parkbanProceedInformationFilter.addGraphPath("dateDimensionEntity");
        BaseService.setEntityGraph(parkbanProceedInformationDAO,parkbanProceedInformationFilter,"findAll");
        Page page = parkbanProceedInformationDAO.findAll(parkbanProceedInformationFilter.getCriteriaExpression(),parkbanProceedInformationFilter.getPageable());

        return ObjectMapper.mapPagedList(page,ParkbanProceedInformationDto.class);
    }

    private ParkbanProceedInformationFilter prepareParkbanProceedInformationFilter(ParkbanProceedInformationFilter filter){

        ParkbanProceedInformationFilter parkbanProceedInformationFilter = new ParkbanProceedInformationFilter();
        parkbanProceedInformationFilter.setDateDimensionEntity(new DateDimensionEntityFilter());
        parkbanProceedInformationFilter.setRegion(filter.getRegion());
        parkbanProceedInformationFilter.getDateDimensionEntity().setDateDimensionLevel(filter.getDateDimensionEntity().getDateDimensionLevel());

        parkbanProceedInformationFilter.setParkban(filter.getParkban());

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
