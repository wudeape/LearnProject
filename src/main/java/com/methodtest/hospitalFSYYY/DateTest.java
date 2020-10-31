package com.methodtest.hospitalFSYYY;

import com.methodtest.tools.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wudeyuan
 * @date 2020/10/22 15:38
 * @description
 */
public class DateTest {

    public static void main(String[] args){
        String date1 = DateUtil.addDay(DateUtil.getCurrentDate(), -2) + " 00:00:00";
        String date2 = DateUtil.addDay(DateUtil.getCurrentDate(), -1) + " 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startdate = null;
        Date enddate = null;
        Date startdate1 = null;
        Date enddate1 = null;
        try {
            startdate = sdf.parse(date1);
            enddate = sdf.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("");

    }
}
