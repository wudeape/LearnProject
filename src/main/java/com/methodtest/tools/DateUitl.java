package com.methodtest.tools;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * @author wudeyuan
 * @date 2020/8/28 14:54
 * @description
 */
public class DateUitl {

    public static void main(String[] args) {
//        String time = addHour(getCurrentDateSTime(), new BigDecimal("-0.5"));
//        System.out.println(time);
        Date dateOfHour = getDateOfHour(0);

    }

    public static String getFormatDate(Date date){
        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("YYYY-MM-dd");
        String format = simpleDateFormat.format(date);
        return format;
    }

    public static String addHour(String date, BigDecimal addHour) {
        long addSecond = addHour.multiply(new BigDecimal(60 * 60 * 1000)).longValue();
        long time = 0;
        try {
            time = convertStringToDateTime8(date).getTime() + addSecond;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat(DateConstants.DATE_TIME_PATTERN).format(time);
    }

    public static Date convertStringToDateTime8(String strDate) {
        DateFormat f = new SimpleDateFormat(DateConstants.DATE_TIME_HHMM);
        try {
            return f.parse(strDate);
        } catch (ParseException e) {
        }
        return null;
    }

    public static String getCurrentDateSTime() {
        return getDateFormat(new Date(), DateConstants.DATE_TIME_PATTERN);
    }

    public static String getDateFormat(Date dt, String pattern) {
        SimpleDateFormat formater = new SimpleDateFormat(pattern, Locale.getDefault());
        return formater.format(dt);
    }
    public static String getCalendar(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        Date time = calendar.getTime();
        String formatDate = getFormatDate(time);
        return formatDate;
    }

    public static Date getDateOfHour(int hour){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        Date date = c.getTime();
        return date;

//        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        return myFmt.format(date);
    }

    



}
