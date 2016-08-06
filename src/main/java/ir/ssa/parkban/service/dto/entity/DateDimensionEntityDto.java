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
    private Short year;
    private Short month;
    private Short day;
    private Short week;

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

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public Short getMonth() {
        return month;
    }

    public void setMonth(Short month) {
        this.month = month;
    }

    public Short getDay() {
        return day;
    }

    public void setDay(Short day) {
        this.day = day;
    }

    public Short getWeek() {
        return week;
    }

    public void setWeek(Short week) {
        this.week = week;
    }
}
