package ir.ssa.parkban.vertical.core.util.DateUtils;

import ir.aka.utils.shamsidate.DateTimeHelper;
import ir.aka.utils.shamsidate.ShamsyDate;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hadoop on 6/24/16.
 */
public class DateConverter {


    public static Date convertShamsiToMiladiBeginningOfDay(String shamsiDate){
        try {
            String[] ymd = shamsiDate.split("/");
            ShamsyDate shamsyDate = new ShamsyDate(Integer.valueOf(ymd[0]),Integer.valueOf(ymd[1])
                    ,Integer.valueOf(ymd[2]),0,0,0);
            Calendar cal = DateTimeHelper.ShamsyToMilady(shamsyDate);
            return cal.getTime();
        } catch (Exception e) {
            return null;
        }
    }

    public static Date convertShamsiToMiladiEndOfDay(String shamsiDate){
        try {
            String[] ymd = shamsiDate.split("/");
            ShamsyDate shamsyDate = new ShamsyDate(Integer.valueOf(ymd[0]),Integer.valueOf(ymd[1])
                    ,Integer.valueOf(ymd[2]),23,59,59);
            Calendar cal = DateTimeHelper.ShamsyToMilady(shamsyDate);
            return cal.getTime();
        } catch (Exception e) {
            return null;
        }
    }

    public static Date getMiladiDateEndOfDay(Date miladiDate){
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(miladiDate);
            cal.set(Calendar.HOUR,23);
            cal.set(Calendar.MINUTE,59);
            cal.set(Calendar.SECOND,59);
            return cal.getTime();
        } catch (Exception e) {
            return null;
        }
    }

    public static LocalDate convertDateToLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static String convertMiladiToShamsiWithoutTime(Date miladiDate){
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(miladiDate);
            ShamsyDate shamsyDate = DateTimeHelper.MiladyToShamsy(calendar);
            return shamsyDate.toString();
        } catch (Exception e) {
            return null;
        }
    }

}
