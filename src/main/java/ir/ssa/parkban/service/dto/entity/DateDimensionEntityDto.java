package ir.ssa.parkban.service.dto.entity;

import ir.ssa.parkban.service.dto.enums.DateDimensionLevelDto;
import java.util.Date;

/**
 * Created by Behrouz-ZD on 8/4/2016.
 */
public class DateDimensionEntityDto extends DomainEntityDto {

    private DateDimensionLevelDto dateDimensionLevel;
    private String title;
    private Date startDate;
    private Date endDate;
    private Date startDateFa;
    private Date endDateFa;

    public DateDimensionLevelDto getDateDimensionLevel() {
        return dateDimensionLevel;
    }

    public void setDateDimensionLevel(DateDimensionLevelDto dateDimensionLevel) {
        this.dateDimensionLevel = dateDimensionLevel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDateFa() {
        return startDateFa;
    }

    public void setStartDateFa(Date startDateFa) {
        this.startDateFa = startDateFa;
    }

    public Date getEndDateFa() {
        return endDateFa;
    }

    public void setEndDateFa(Date endDateFa) {
        this.endDateFa = endDateFa;
    }
}
