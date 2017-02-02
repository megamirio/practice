package practice3.skywind;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by royalflush on 19.12.16.
 */
public class Okey {
    private static int dayToSubstractInFilterQuery=1;

    public static void main(String[] args) throws ParseException {
        System.out.println("one two three");
        System.out.println();
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, (-1) * dayToSubstractInFilterQuery);
        cal.add(Calendar.HOUR, (+1) * dayToSubstractInFilterQuery);

        System.out.println(cal.getTime());

        Calendar calendarNew = Calendar.getInstance();
        calendarNew.setTime(new Date());
        System.out.println(calendarNew.getTime());

        long startTime = cal.getTime().getTime();
        long endTime = calendarNew.getTime().getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        System.out.println(diffDays);

        DateTime dateStart = new DateTime(cal.getTime());
        DateTime dateEnd = new DateTime(calendarNew.getTime());

        Period p = new Period(startTime,endTime);
        System.out.println(p.getDays());
//        Days.daysBetween(startTime,endTime);

        DateTime oldDate = new DateTime(getBeginingOfTheDay(cal.getTime()));
        DateTime newDate = new DateTime(new Date());
        Period p2 = new Period(oldDate, newDate);
        int days = p2.getDays();
        System.out.println(days);

//        LocalDate today = LocalDate.now();
//        LocalDate yesterday = today.minusDays(1);
//        Duration oneDay = Duration.between(today, yesterday);
//        System.out.println(oneDay);

        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.MONTH));
        System.out.println(cal.get(Calendar.YEAR));


        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date today = new Date();

//        Date todayWithZeroTime = formatter.parse(formatter.format(today));
    }

    private static Date getBeginingOfTheDay(Date date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date todayWithZeroTime = formatter.parse(formatter.format(date));
        return todayWithZeroTime;
    }
}
