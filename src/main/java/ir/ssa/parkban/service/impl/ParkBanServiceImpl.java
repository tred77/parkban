package ir.ssa.parkban.service.impl;

import ir.ssa.parkban.service.dto.entity.ParkbanTimeTableDto;
import ir.ssa.parkban.domain.entities.ParkbanTimeTable;
import ir.ssa.parkban.domain.entities.Region;
import ir.ssa.parkban.domain.filters.ParkbanTimeTableFilter;
import ir.ssa.parkban.domain.filters.RegionFilter;
import ir.ssa.parkban.domain.views.ParkbanTimeTableView;
import ir.ssa.parkban.repository.ParkbanTimeTableDAO;
import ir.ssa.parkban.repository.RegionDAO;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.ParkBanService;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilter;
import ir.ssa.parkban.vertical.core.domain.filterelement.DateFilterOperation;
import ir.ssa.parkban.vertical.core.util.DateUtils.CalendarUtils;
import ir.ssa.parkban.vertical.core.util.DateUtils.DateUtils;
import ir.ssa.parkban.vertical.core.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hym
 */
@Service
public class ParkBanServiceImpl implements ParkBanService {

    @Autowired
    private ParkbanTimeTableDAO parkbanTimeTableDAO;

    @Autowired
    RegionDAO regionDAO;

    @Override
    public ParkbanTimeTableDto insertParkbanTimeTable(ParkbanTimeTableDto parkbanTimeTableDto) {
        ParkbanTimeTable parkbanTimeTable = ObjectMapper.map(parkbanTimeTableDto,ParkbanTimeTable.class);
        parkbanTimeTableDAO.save(parkbanTimeTable);
        return ObjectMapper.map(parkbanTimeTable,ParkbanTimeTableDto.class);
    }

    @Override
    public void updateParkbanTimeTable(ParkbanTimeTableDto parkbanTimeTableDto) {
        ParkbanTimeTable parkbanTimeTable = ObjectMapper.map(parkbanTimeTableDto,ParkbanTimeTable.class);
        parkbanTimeTableDAO.save(parkbanTimeTable);
    }

    @Override
    public void deleteParkbanTimeTable(ParkbanTimeTableDto parkbanTimeTableDto) {
        ParkbanTimeTable parkbanTimeTable = ObjectMapper.map(parkbanTimeTableDto,ParkbanTimeTable.class);
        parkbanTimeTableDAO.delete(parkbanTimeTable);
    }

    @Override
    public List<ParkbanTimeTableDto> findAllParkbanTimeTables(ParkbanTimeTableFilter filter) {

        /* 1) finding involved week days */
        Date sourceDate = new Date();
        if(filter.getWorkDate() != null && filter.getWorkDate().getValues() != null){
            sourceDate = filter.getWorkDate().getValues()[0];
        }
        Date previousSaturday = CalendarUtils.getPreviousSaturdayAtZeroClock(sourceDate);
        Date nextSaturday = CalendarUtils.getNextSaturdayAtZeroClock(sourceDate);
        DateFilter dateFilter = new DateFilter();
        Date[] dates = new Date[]{previousSaturday, nextSaturday};
        dateFilter.setMiladiValues(dates);
        dateFilter.setElementOp(DateFilterOperation.BETWEEN.getValue());
        filter.setWorkDate(dateFilter);
        Sort orders = new Sort(Sort.Direction.ASC, "region.id").and(new Sort(Sort.Direction.ASC, "workDate"));

        filter.addGraphPath("region");
        filter.addGraphPath("parkban");
        BaseService.setEntityGraph(parkbanTimeTableDAO, filter, "findAll");
        Iterable<ParkbanTimeTable> parkbanTimeTables = parkbanTimeTableDAO.findAll(filter.getCriteriaExpression(), orders);

        /* 2) Querying candidate Regions*/
        RegionFilter regionFilter = new RegionFilter();
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Iterable<Region> regions = regionDAO.findAll(regionFilter.getCriteriaExpression());

        /* 3) make an output */
        List<ParkbanTimeTableDto> parkbanTimeTableDtos = new ArrayList<>();
        List<Date> weekDays = CalendarUtils.getDatesBetween(previousSaturday, nextSaturday);
        for(Region region : regions){
            for(Date date : weekDays){
                ParkbanTimeTableView parkbanTimeTableView = new ParkbanTimeTableView();
                parkbanTimeTableView.setRegion(region);

            }
        }



        return null;
    }

    private ParkbanTimeTable findInsideACollection(Iterable<ParkbanTimeTable> parkbanTimeTables, Region region, Date date){

        //Arrays.stream(parkbanTimeTables)

        for(ParkbanTimeTable element : parkbanTimeTables){
            if(element.getRegion().getId().longValue() == region.getId()
                    && DateUtils.compareTwoDatesWithoutTime(element.getWorkDate(), date) == 0){
                return element;
            }
        }
        return null;
    }
}
