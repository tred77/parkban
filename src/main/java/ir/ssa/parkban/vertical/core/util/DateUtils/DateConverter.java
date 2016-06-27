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

    public static LocalDate convertDateToLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
