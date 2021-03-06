package ir.ssa.parkban.domain.entities.warehouse;

import ir.ssa.parkban.domain.entities.DomainEntity;
import ir.ssa.parkban.domain.enums.DateDimensionLevel;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Yeganeh
 */
@Entity(name = "TBL_DATE_DIMENSION")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "DATE_DIMENSION_SEQ")
public class DateDimensionEntity extends DomainEntity{

    @Column(name = "DATE_DIM_LEVEL")
    @Enumerated(EnumType.STRING)
    private DateDimensionLevel dateDimensionLevel;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "START_DATE_FA")
    private Long startDateFa;

    @Column(name = "END_DATE_FA")
    private Long endDateFa;

    @Column(name = "YEAR")
    private Short year;

    @Column(name = "MONTH")
    private Short month;

    @Column(name = "DAY")
    private Short day;

    @Column(name = "WEEK")
    private Short week;

    public DateDimensionLevel getDateDimensionLevel() {
        return dateDimensionLevel;
    }

    public void setDateDimensionLevel(DateDimensionLevel dateDimensionLevel) {
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

    public Long getStartDateFa() {
        return startDateFa;
    }

    public void setStartDateFa(Long startDateFa) {
        this.startDateFa = startDateFa;
    }

    public Long getEndDateFa() {
        return endDateFa;
    }

    public void setEndDateFa(Long endDateFa) {
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
