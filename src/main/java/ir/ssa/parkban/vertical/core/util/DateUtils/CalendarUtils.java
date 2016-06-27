package ir.ssa.parkban.vertical.core.util.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by hadoop on 6/27/16.
 */
public class CalendarUtils {

    public static Date getPreviousSaturdayAtZeroClock(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_WEEK, -(calendar.get(Calendar.DAY_OF_WEEK)));
        return calendar.getTime();
    }

    public static Date getNextSaturdayAtZeroClock(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_WEEK, -(calendar.get(Calendar.DAY_OF_WEEK)) + 7);
        return calendar.getTime();
    }

    public static List<Date> getDatesBetween(Date date1, Date date2){
        List<Date> dates = new ArrayList<>();
        if(date2.before(date1)){
            return dates;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        while (calendar.getTime().compareTo(date2) < 0){
            dates.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_WEEK, 1);
        }
        return dates;
    }

}
