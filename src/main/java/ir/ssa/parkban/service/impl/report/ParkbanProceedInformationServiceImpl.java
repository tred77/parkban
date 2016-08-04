package ir.ssa.parkban.service.impl.report;

import ir.ssa.parkban.domain.filters.warehouse.ParkbanProceedInformationFilter;
import ir.ssa.parkban.repository.warehouse.ParkbanProceedInformationDAO;
import ir.ssa.parkban.service.bean.report.ParkbanProceedInformationService;
import ir.ssa.parkban.service.dto.entity.ParkbanProceedInformationDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Behrouz-ZD on 8/4/2016.
 */
public class ParkbanProceedInformationServiceImpl implements ParkbanProceedInformationService{


    @Autowired
    ParkbanProceedInformationDAO parkbanProceedInformationDAO;

    @Override
    public List<ParkbanProceedInformationDto> getParkbanProceedInformation(ParkbanProceedInformationFilter filter) {
        return null;
    }
}
