package com.davidoladeji.park.service.util;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/*@Column(name = "DATE_FIELD") @Temporal(TemporalType.DATE) private java.util.Calendar dateField; @Column(name = "TIME_FIELD") @Temporal(TemporalType.TIME) private java.util.Calendar timeField; @Column(name = "DATETIME_FIELD") @Temporal(TemporalType.TIMESTAMP) private java.util.Calendar datetimeField; @Column(name = "TIMESTAMP_FIELD") @Temporal(TemporalType.TIMESTAMP) private java.util.Calendar timestampField; - See more at: http://www.developerscrappad.com/228/java/java-ee/ejb3-jpa-dealing-with-date-time-and-timestamp/#sthash.MPEvDf6H.dpuf*/

/**
 * Created by Daveola on 17-Dec-14.
 * Using a Mix of Joda Time and java Util Date cause
 * of the various methods each provides
 */
public class MyTimeDateUtil {

    String currentdate;
    String currenttime;
    String datetime;

    Locale locale = new Locale(Locale.UK.toString());

    public String getCurrentDate() {
        // Get current date

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        currentdate = dateFormat.format(date);

        return currentdate;
    }

    public String getCurrentDateAndDayOfWeek() {
        // Get current date

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd - MMMM - yyyy");
        currentdate = dateFormat.format(date);

        return currentdate;
    }

    public String getCurrentTime() {
        // Get current time

        Date time = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

        currenttime = timeFormat.format(time);

        return currenttime;
    }


    public String getCurrentDateTime() {
        // Get current date and time

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        /*DateFormat dateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT, DateFormat.SHORT, locale);*/

        datetime = dateFormat.format(date);

        return datetime;
    }

    /**
     * Convert String to Date
     */


    public Date convertStringtoDate(String string) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {

            date = formatter.parse(string);

            return date;

        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }

    }


    public Date convertStringtoTime(String string) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        try {

            date = formatter.parse(string);

            return date;

        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }

    }

    /**
     * Converts a Date (java.util.Date) to LocalDate (JodaTime)
     *
     * @param date
     * @return
     */
    public LocalDate convertUtilDateToLocalDate(Date date) {
        if (date == null) return null;
        DateTime dt = new DateTime(date);
        return dt.toLocalDate();
    }


    public LocalTime convertUtilStringToLocalTime(String time) {


        LocalTime localTime = LocalTime.parse(time, DateTimeFormat.forPattern("HH:mm:ss"));

        return localTime;
    }


}
