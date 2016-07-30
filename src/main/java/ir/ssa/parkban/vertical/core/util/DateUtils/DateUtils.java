package ir.ssa.parkban.vertical.core.util.DateUtils;

import java.time.DayOfWeek;
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

    public static DayOfWeek getDayOfWeek(Date date){
        LocalDate localDate1 = DateConverter.convertDateToLocalDate(date);
        return localDate1.getDayOfWeek();
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
        shamsyDate = sp[0]+"/"+sp[1]+"/"+"29";
        return DateConverter.convertShamsiToMiladiEndOfDay(shamsyDate);
    }

}
