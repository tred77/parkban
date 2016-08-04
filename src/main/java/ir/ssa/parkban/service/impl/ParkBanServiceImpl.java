package ir.ssa.parkban.service.impl;

import com.google.common.collect.Lists;
import ir.ssa.parkban.domain.entities.*;
import ir.ssa.parkban.domain.filters.ParkbanFilter;
import ir.ssa.parkban.domain.filters.ParkbanTimeTableFilter;
import ir.ssa.parkban.domain.filters.ParkbanTrackFilter;
import ir.ssa.parkban.domain.filters.RegionFilter;
import ir.ssa.parkban.domain.views.ParkbanTimeTableView;
import ir.ssa.parkban.repository.*;
import ir.ssa.parkban.service.bean.BaseService;
import ir.ssa.parkban.service.bean.ParkBanService;
import ir.ssa.parkban.service.dto.entity.ParkFacilityDto;
import ir.ssa.parkban.service.dto.entity.ParkbanDto;
import ir.ssa.parkban.service.dto.entity.ParkbanTimeTableDto;
import ir.ssa.parkban.service.dto.entity.ParkbanTrackDto;
import ir.ssa.parkban.service.dto.view.ParkbanTimeTableViewDto;
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
    private ParkbanDAO parkbanDAO;

    @Autowired
    RegionDAO regionDAO;

    @Autowired
    ParkbanTrackDAO parkbanTrackDAO;

    @Autowired
    ParkFacilityDAO parkFacilityDAO;

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
    public void deleteParkbanTimeTable(Long id) {
        parkbanTimeTableDAO.delete(id);
    }

    @Override
    public List<ParkbanTimeTableViewDto> findAllParkbanTimeTables(ParkbanTimeTableFilter filter) {
        /* 1) finding involved week days */
        Date sourceDate = new Date();
        Date previousSaturday;
        Date nextSaturday;
        if(filter.getWorkDate() != null && filter.getWorkDate().getValues() != null){
            previousSaturday = filter.getWorkDate().getValues()[0];
            nextSaturday = filter.getWorkDate().getValues()[1];
        }else{
            previousSaturday = CalendarUtils.getPreviousSaturdayAtZeroClock(sourceDate);
            nextSaturday = CalendarUtils.getNextSaturdayAtZeroClock(sourceDate);

            DateFilter dateFilter = new DateFilter();
            Date[] dates = new Date[]{previousSaturday, nextSaturday};
            dateFilter.setMiladiValues(dates);
            dateFilter.setElementOp(DateFilterOperation.ONE_WEEK.getValue());
            filter.setWorkDate(dateFilter);
        }

        Sort orders = new Sort(Sort.Direction.ASC, "region.id").and(new Sort(Sort.Direction.ASC, "workDate"));

        filter.addGraphPath("region");
        filter.addGraphPath("parkban.user");
        BaseService.setEntityGraph(parkbanTimeTableDAO, filter, "findAll");
        Iterable<ParkbanTimeTable> parkbanTimeTables = parkbanTimeTableDAO.findAll(filter.getCriteriaExpression(), orders);

        /* 2) Querying candidate Regions*/
        RegionFilter regionFilter = new RegionFilter();
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Iterable<Region> regions = regionDAO.findAll(regionFilter.getCriteriaExpression());

        /* 3) make an output */
        List<ParkbanTimeTableView> resListOfParkbanTimes = new ArrayList<>();
        List<Date> weekDays = CalendarUtils.getDatesBetween(previousSaturday, nextSaturday);
        for(Region region : regions){
            ParkbanTimeTableView parkbanTimeTableView = new ParkbanTimeTableView();
            parkbanTimeTableView.setRegion(region);
            for(Date date : weekDays){
                ParkbanTimeTable tempTable = findInsideACollection(parkbanTimeTables, region, date);
                if(tempTable == null){
                    tempTable = new ParkbanTimeTable();
                    tempTable.setRegion(region);
                    tempTable.setWorkDate(date);
                }
                parkbanTimeTableView.setParkbanTimeTable(tempTable);
            }
            resListOfParkbanTimes.add(parkbanTimeTableView);
        }

        return ObjectMapper.map(resListOfParkbanTimes, ParkbanTimeTableViewDto.class);
    }

    private ParkbanTimeTable findInsideACollection(Iterable<ParkbanTimeTable> parkbanTimeTables, Region region, Date date){

        return  Lists.newArrayList(parkbanTimeTables).stream()
                .filter(el -> el.getRegion().getId().longValue() == region.getId().longValue()
                        && DateUtils.compareTwoDatesWithoutTime(el.getWorkDate(), date) == 0)
                .findFirst()
                .orElse(null);
    }


    /* Parkban Section*/
    public List<ParkbanDto> findAllParkbans(ParkbanFilter filter){
        BaseService.setEntityGraph(parkbanDAO, filter, "findAll");
        return ObjectMapper.map(parkbanDAO.findAll(filter.getCriteriaExpression()),ParkbanDto.class);
    }

    @Override
    public void insertParkban(ParkbanDto parkbanDto) {
        parkbanDAO.save(ObjectMapper.map(parkbanDto,Parkban.class));
    }

    @Override
    public void updateParkban(ParkbanDto parkbanDto) {
        parkbanDAO.save(ObjectMapper.map(parkbanDto,Parkban.class));
    }

    @Override
    public void deleteParkban(Long id) {
        parkbanDAO.delete(id);
    }

    /* ParkbanTrack section*/

    @Override
    public List<ParkbanTrackDto> findAllParkbanTracks(ParkbanTrackFilter parkbanTrackFilter) {
        BaseService.setEntityGraph(parkbanTrackDAO, parkbanTrackFilter, "findAll");
        return ObjectMapper.map(parkbanTrackDAO.findAll(parkbanTrackFilter.getCriteriaExpression()),ParkbanTrackDto.class);
    }

    @Override
    public void insertParkbanTrack(ParkbanTrackDto parkbanTrackDto) {
        parkbanTrackDAO.save(ObjectMapper.map(parkbanTrackDto,ParkbanTrack.class));
    }

    @Override
    public void insertParkFacilities(List<ParkFacilityDto> parkFacilities){
        parkFacilityDAO.save(ObjectMapper.map(parkFacilities, ParkFacility.class));
    }
}
