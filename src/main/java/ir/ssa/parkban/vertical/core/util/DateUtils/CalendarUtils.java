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

    public static Date shiftShamsyToBeginningOfMonth(Date dt){
        String shamsyDate = DateConverter.convertMiladiToShamsiWithoutTime(dt);
        String[] sp = shamsyDate.split("/");
        shamsyDate = sp[0]+"/"+sp[1]+"/"+"1";
        return DateConverter.convertShamsiToMiladiBeginningOfDay(shamsyDate);
    }

    public static Date shiftShamsyToEndOfMonth(Date dt){
        String shamsyDate = DateConverter.convertMiladiToShamsiWithoutTime(dt);
        String[] sp = shamsyDate.split("/");
        int year=Integer.parseInt(sp[0]);
        int month=Integer.parseInt(sp[1]);
        if(month == 12){
            month = 1;
            year=year+1;
        }
        else{
            month=month+1;
        }
        shamsyDate = year+"/"+month+"/"+"1";
        Date end = DateConverter.convertShamsiToMiladiEndOfDay(shamsyDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(end);
        calendar.add(Calendar.DATE, -1);

        return calendar.getTime();
    }

    public static int getLastDayOfShamsiMonth(int year,int month){
        String startShamsiDate = year+"/"+month+"/01";
        Date dt = CalendarUtils.shiftShamsyToEndOfMonth(DateConverter.convertShamsiToMiladiBeginningOfDay(startShamsiDate));
        String[] sm = DateConverter.convertMiladiToShamsiWithoutTime(dt).split("/");
        return new Integer(sm[2]);
    }


    public static Date getBeginningOfShamsiMonth(int year, int month){
        String startShamsiDate = year+"/"+month+"/01";
        return DateConverter.convertShamsiToMiladiBeginningOfDay(startShamsiDate);
    }

    public static short getDayOfShamsiDate(Date date){
        String shamsyDate = DateConverter.convertMiladiToShamsiWithoutTime(date);
        String[] sp = shamsyDate.split("/");
        return Short.parseShort(sp[2]);
    }

    public static short getYearOfShamsiDate(Date date){
        String shamsyDate = DateConverter.convertMiladiToShamsiWithoutTime(date);
        String[] sp = shamsyDate.split("/");
        return Short.parseShort(sp[0]);
    }

    public static short getMonthOfShamsiDate(Date date){
        String shamsyDate = DateConverter.convertMiladiToShamsiWithoutTime(date);
        String[] sp = shamsyDate.split("/");
        return Short.parseShort(sp[1]);
    }



}
