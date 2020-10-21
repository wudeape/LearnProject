package com.methodtest.hospitalSL;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.lastInMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

/**
 * @author wudeyuan
 * @date 2020/10/10 10:32
 * @description
 */
public class javadateusage {

    public static  void main(String[] args) throws ParseException {

        //1.DateFormat 可以直接使用，但其本身是一个抽象类，可以根据Locate指定的区域得到对应的日期时间格式
        //2.SimpleDateFormat 类是DateFormat 类的子类，一般情况下来讲 DateFormat 类很少会直接使用。而都使用SimpleDateFormat 类完成。
//        dateformat();
//        simpledatefomrat();

//        calcCalendar 使用
//        calcCalendar();

        updateDateUsage();

    }


    /**
     * //得到日期的DateFormat对象：
     * public static final DateFormat getDateInstance();
     *
     * //得到日期时间的DateFormat对象：
     * public static final DateFormat getDateTimeInstance();
     *
     * //使用DateFormat类格式化Date类日期
     * public final String format(Date date)
     */
    private static void dateformat(){
        // 20-10-12 上午10:52
        DateFormat dateFormat1 = DateFormat.getInstance();
        // 10:52:43
        DateFormat dateFormat2 = DateFormat.getTimeInstance();
        // 上午10时57分11秒
        DateFormat dateFormat3 = DateFormat.getTimeInstance(DateFormat.YEAR_FIELD,new Locale("zh","CN"));


        String format1 = dateFormat1.format(new Date());
        String format2 = dateFormat2.format(new Date());
        String format3 = dateFormat3.format(new Date());

        System.out.println(format1);
        System.out.println("\n");
        System.out.println(format2);
        System.out.println("\n");
        System.out.println(format3);
    }


    /**
     * //构造方法：
     * public SimpleDateFormat(String pattern)
     *
     * //转换：
     * public Date parse(String source)throws ParseException //-->此时取得的是全部时间数。
     *
     * //格式化：
     * public final String Format(Date date)   //-->将时间重新格式化成字符串显示。
     *
     * 格式化模板日期
     * y 表示年，年份是四位数，通常表示"yyyy"
     * M 表示月，月份是两位数，通常表示"MM"
     * d 表示日，日是两位数，通常使用"dd"
     * H 表示时，通常使用"HH"
     * m 表示分，通常使用"mm"
     * s 表示秒，通常使用"ss"
     * S 表示毫秒，通常使用"SSS"
     */
    private static void simpledatefomrat(){

        Date date = new Date();
        String dateString = "2020-10-19";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 日期转成字符串
        String format = simpleDateFormat.format(date);
        // 时间字符串变成日期
        try {
            Date parse = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }


    private static void calcCalendar(){
        String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        // 去年
        calendar.add(Calendar.YEAR,-1);
        // 上月
        calendar.add(Calendar.MONTH, -1);
        // 昨日
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        // 获取转归日期
        int w = calendar.get(Calendar.DAY_OF_WEEK)-1;
        if (w < 0) {
            w = 0;
        }
        System.out.println("获取日期: "+calendar.getTime());
        lineback();
        System.out.println(weekDays[w]);

    }


    // 时间比较
    private static int compareDate(Date date1,Date date2){
        if ( date1 == null) {
            return 0;
        }

        if (date2 == null) {
            return 0;
        }

        return date1.compareTo(date2);

    }

    /**
     * java8 日期使用
     * https://lw900925.github.io/java/java8-newtime-api.html
     * LocalDate 获取日期  LocalTime 获取时间
     * LocalDateTime  初始化时间  LocalTime.of();  LocalDateTime.of();等
     *
     * Instant : Instant用于表示一个时间戳，它与我们常使用的System.currentTimeMillis()有些类似，不过Instant可以精确到纳秒（Nano-Second），
     *  System.currentTimeMillis()方法只精确到毫秒（Milli-Second）
     *
     * Duration : 两者的区别是Instant用于表示一个时间戳（或者说是一个时间点），而Duration表示一个时间段，所以Duration类中不包含now()静态方法。
     * 可以通过Duration.between()方法创建Duration对象
     *
     * Period ： Period在概念上和Duration类似，区别在于Period是以年月日来衡量一个时间段，比如2年3个月6天
     */
    private static void updateDateUsage(){
        // 2020-10-13
        LocalDate localDate = LocalDate.now();
        // 11:48:59.560
        LocalTime localTime = LocalTime.now();

        LocalDateTime localDateTime = LocalDateTime.now();
        // 增减日期
        localDateTime.minusDays(1);
        localDateTime.plusYears(1);
        localDate.plus(1, ChronoUnit.DAYS);
        // 处理复杂日期
        LocalDateTime date7 = localDateTime.with(nextOrSame(DayOfWeek.SUNDAY));      // 返回下一个距离当前时间最近的星期日
        LocalDateTime date9 = localDateTime.with(lastInMonth(DayOfWeek.SATURDAY));   // 返回本月最后一个星期六

        // Instant 使用  2020-10-13T04:05:50.724Z
        Instant instant = Instant.now();
        Instant instant1 = instant.ofEpochSecond(120, 10000);

        // Duration 对象的创建
        LocalDateTime from = LocalDateTime.of(2020, Month.JANUARY, 5, 10, 7, 0);    // 2020-01-05 10:07:00
        LocalDateTime to = LocalDateTime.of(2020, Month.FEBRUARY, 5, 10, 7, 0);     // 2020-02-05 10:07:00
        Duration duration = Duration.between(from, to);

        Duration duration1 = Duration.of(5, ChronoUnit.DAYS);

        // 格式化日期
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
        dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String dateString = "2020-10-13";
        String dateTimeString = "2020-10-13 12:30:05";
        LocalDate.parse(dateString,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime.parse(dateTimeString,DateTimeFormatter.ofPattern("yyy-MM-dd hh:mm:ss"));

        lineback();
        System.out.println(instant);

    }



    private static void lineback(){
        System.out.println("\n");
    }








}
