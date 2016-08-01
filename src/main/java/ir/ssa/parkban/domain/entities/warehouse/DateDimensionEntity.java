package ir.ssa.parkban.domain.entities.warehouse;

import ir.ssa.parkban.domain.enums.DateDimensionLevel;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Yeganeh
 */
@Entity(name = "TBL_DATE_DIMENSION")
@SequenceGenerator(initialValue = 1, name = "base_seq", sequenceName = "DATE_DIMENSION_SEQ")
public class DateDimensionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "base_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "DATE_DIM_LEVEL")
    @Enumerated(EnumType.STRING)
    private DateDimensionLevel dateDimensionLevel;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
