package ir.ssa.parkban.vertical.core.util.DateUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hadoop on 6/27/16.
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static int compareTwoDatesWithoutTime(Date date1, Date date2){
        LocalDate localDate1 = DateConverter.convertDateToLocalDate(date1);
        return localDate1.compareTo(DateConverter.convertDateToLocalDate(date2));
    }

    public static DayOfWeek getDayOfWeek(Date date){
        LocalDate localDate1 = DateConverter.convertDateToLocalDate(date);
        return localDate1.getDayOfWeek();
    }

    public static Date getNextDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return  calendar.getTime();
    }

    public static Date getPreviousDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return  calendar.getTime();
    }

    public static Date getLastDayOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();
        return lastDayOfMonth;
    }





}
