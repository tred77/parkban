package ir.ssa.parkban.vertical.core.util.DateUtils;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by hadoop on 6/27/16.
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static int compareTwoDatesWithoutTime(Date date1, Date date2){
        LocalDate localDate1 = DateConverter.convertDateToLocalDate(date1);
        return localDate1.compareTo(DateConverter.convertDateToLocalDate(date2));
    }

}
