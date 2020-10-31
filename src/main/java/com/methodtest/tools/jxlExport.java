package com.methodtest.tools;


import com.methodtest.entity.WaterMaintenanceRecordCondForm;
import com.methodtest.entity.WaterMaintenanceRecordResultForm;
import jxl.format.*;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wudeyuan
 * @date 2020/10/31 9:05
 * @description
 */
public class jxlExport {
    public static void main(String[] args){
        WaterMaintenanceRecordCondForm waterMaintenanceRecordCondForm = new WaterMaintenanceRecordCondForm();
    }

    /**
     * jxl 创建工作簿对象并设置属性
     * @param response
     */
    public void jxlExportService(WaterMaintenanceRecordCondForm form, HttpServletResponse response){
        String excelName = "Test";
        String fileName = "";
        try {
            // 用时间名命名名称
            String dateFormate = new java.text.SimpleDateFormat("yyyyMMdd").format(new Date());
            fileName = excelName + dateFormate + ".xls";

            OutputStream os = null;
            WritableWorkbook book = null;
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
            os = response.getOutputStream();

            // 创建文档工作簿
            book = jxl.Workbook.createWorkbook(os);
            // 设置单元格的文字格式
            WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
            // 创建标题单元格格式
            WritableCellFormat twcf = new WritableCellFormat(wf);
            twcf.setBorder(Border.ALL, BorderLineStyle.THIN);
            twcf.setVerticalAlignment(VerticalAlignment.CENTRE);
            // 设置居中
            twcf.setAlignment(Alignment.CENTRE);
            // 创建普通单元格格式
            WritableCellFormat wcf = new WritableCellFormat();
            // 设置单元格的文字格式
            WritableFont wf1 = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
            wcf.setFont(wf1);
            // 设置居中
            wcf.setAlignment(Alignment.CENTRE);
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
            //设置边框
            wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
            export(form, book, twcf, wcf);
            // 写入数据
            book.write();
            // 关闭文件
            book.close();
            os.flush();
            os.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void export(WaterMaintenanceRecordCondForm form, WritableWorkbook book, WritableCellFormat twcf, WritableCellFormat wcf) {
        exportformList(form, book, twcf, wcf);
    }

    private void exportformList(WaterMaintenanceRecordCondForm form, WritableWorkbook book, WritableCellFormat twcf, WritableCellFormat wcf) {
        // 根据form 请求获取对应的数据
        List<WaterMaintenanceRecordResultForm> list = new ArrayList<>();
        //开始和结束时间的年份、月份，以及开始位置（0,：上半月，1：下半月）
        String startYear="";
        String startMonth="";
        String startPoisition="";
        String endYear="";
        String endMonth="";
        String endPoisition="";
        //excel的页数，最少一页
        int sheetnum = 1;
        //不会出现没有数据的情况，因为导出之前做了导出数据是否为空的check，如果没数据则提示没数据，不会继续导出
        if(!Tools.isblank(form.getStartDate())) {
            startYear = form.getStartDate().substring(0, 4);
            startMonth = form.getStartDate().substring(5, 7);
            String day = form.getStartDate().substring(8, form.getStartDate().length());
            //判断开始时间是在上半月还是在下半月，15号之前都为上半月
            if(day.compareTo("15")<= 0) {
                startPoisition = "0";
            }else {
                startPoisition = "1";
            }
        }else {
            //如果未传开始时间，则去第一条数据的录入时间作为开始时间
            if(!Tools.listisblank(list)) {
                String date = list.get(0).getInspectdate();
                startYear = date.substring(0, 4);
                startMonth = date.substring(5, 7);
                String day = date.substring(8, date.length());
                //判断开始时间是在上半月还是在下半月，15号之前都为上半月
                if(day.compareTo("15")<= 0) {
                    startPoisition = "0";
                }else {
                    startPoisition = "1";
                }
            }
        }

        if(!Tools.isblank(form.getEndDate())) {
            endYear = form.getEndDate().substring(0, 4);
            endMonth = form.getEndDate().substring(5, 7);
            String day = form.getEndDate().substring(8, form.getEndDate().length());
            //判断开始时间是在上半月还是在下半月，15号之前都为上半月
            if(day.compareTo("15")<= 0) {
                endPoisition = "0";
            }else {
                endPoisition = "1";
            }
        }else {
            //如果未传开始时间，则去第一条数据的录入时间作为开始时间
            if(!Tools.listisblank(list)) {
                int last = list.size()-1;
                String date = list.get(last).getInspectdate();
                endYear = date.substring(0, 4);
                endMonth = date.substring(5, 7);
                String day = date.substring(8, date.length());
                //判断开始时间是在上半月还是在下半月，15号之前都为上半月
                if(day.compareTo("15")<= 0) {
                    endPoisition = "0";
                }else {
                    endPoisition = "1";
                }
            }
        }

        //计算总共有多少sheet
        sheetnum = calsheetnum(startYear,startMonth,startPoisition,endYear,endMonth,endPoisition);

        String sheetname = "";
        int year = Integer.parseInt(startYear);
        int month = Integer.parseInt(startMonth);;
        int position = Integer.parseInt(startPoisition);;
        for(int i = 1; i<=sheetnum ;i++) {
            if("0".equals(form.getTypechoose())) {
                sheetname = "水处理维护检测记录单级";
            }else {
                sheetname = "水处理维护检测记录双级";
            }
            //获取这个月有多少天
            int daynum = getmonthday(year,month);
            String start;
            String end;
            List<WaterMaintenanceRecordResultForm> sheetlist = new ArrayList<>();
            List<Integer> nextsheettime = null;
            //上半月
            if(position == 0) {
                //月份小于10，前面补0
                if(month<10) {
                    start = ""+year+"-0"+ month +"-01";
                    end = ""+year+"-0"+ month +"-15";
                }else {
                    start = ""+year+"-"+ month +"-01";
                    end = ""+year+"-"+ month +"-15";
                }

                for(WaterMaintenanceRecordResultForm temp : list) {
                    if(temp.getInspectdate().compareTo(start)>=0 && temp.getInspectdate().compareTo(end)<=0) {
                        sheetlist.add(temp);
                    }
                }
                sheetname =sheetname + year + "年" + month +"月上半月" ;
                writeExcel924(sheetname, i, book, twcf, wcf, sheetlist, year, month,position,daynum,form.getTypechoose());
            }else {
                //月份小于10，前面补0
                if(month<10) {
                    start = ""+year+"-0"+ month +"-16";
                    end = ""+year+"-0"+ month +"-" + daynum ;
                }else {
                    start = ""+year+"-"+ month +"-16";
                    end = ""+year+"-"+ month +"-" + daynum ;
                }
                for(WaterMaintenanceRecordResultForm temp : list) {
                    if(temp.getInspectdate().compareTo(start)>=0 && temp.getInspectdate().compareTo(end)<=0) {
                        sheetlist.add(temp);
                    }
                }
                sheetname = sheetname + year + "年" + month +"月下半月" ;
                writeExcel924(sheetname, i, book, twcf, wcf, sheetlist, year, month,position,daynum,form.getTypechoose());
            }

            nextsheettime = next(year,month,position);
            //获取下一页的时间点
            year = nextsheettime.get(0);
            month = nextsheettime.get(1);
            position = nextsheettime.get(2);
            sheetname = "";
        }
    }

    /**
     * @task 10568 设备一览-水处理系统，点击维护记录迁移页面
     * @author wudeyuan 2020/10/30
     * 根据 writeExcel2 方法修改
     */
    public static void writeExcel924(String titleName, int sheetIndex, WritableWorkbook book, WritableCellFormat twcf, WritableCellFormat wcf, List<WaterMaintenanceRecordResultForm> sheetlist, int year, int month, int position, int daynum, String level) {
        try {
            // 生成名为“XXX”的工作表，参数0表示这是第一页 创建工作表
            WritableSheet sheet = book.createSheet(titleName, sheetIndex);

            // 写入标题
            sheet = setHeader1(twcf,sheet,year,month,position,daynum,level);

            //列数
            int colnum = 0;
            if(position == 0) {
                colnum = 15;
            }
            else {
                colnum = daynum -15;
            }

            // 循环写入内容,列从第3列开始
            for (int i = 2; i < colnum+2; i++) {
                WaterMaintenanceRecordResultForm entity = null;
                for(WaterMaintenanceRecordResultForm temp : sheetlist ) {
                    int day1 = Integer.parseInt(temp.getInspectdate().substring(8, temp.getInspectdate().length()));
                    int day2 = Integer.parseInt((String) sheet.getCell(i, 2).getContents());
                    if(day1 == day2) {
                        entity = temp;
                        break;
                    }
                }
                WritableCell cell1;
                WritableCell cell2;
                WritableCell cell3;
                WritableCell cell4;
                WritableCell cell5;
                WritableCell cell6;
                WritableCell cell7;
                WritableCell cell8;
                WritableCell cell9;
                WritableCell cell10;
                WritableCell cell11;
                WritableCell cell12;
                WritableCell cell13;
                WritableCell cell14;
                WritableCell cell15;
                WritableCell cell16;
                WritableCell cell17;
                WritableCell cell18;
                WritableCell cell19;
                WritableCell cell20;
                WritableCell cell21;
                WritableCell cell22;
                WritableCell cell23;
                WritableCell cell24;
                WritableCell cell25;
                //当天有数据
                if(!Tools.isblank(entity)) {
                    // 进水压力（bar）
                    if(!Tools.isblank(entity.getPrecisioninletpressur())) {
                        cell1 = new jxl.write.Number(i, 4, entity.getPrecisioninletpressur().doubleValue(), wcf);
                    }
                    else {
                        cell1 = new jxl.write.Label(i, 4, "", wcf);
                    }
                    sheet.addCell(cell1);
                    // 控制器状态
                    if(!Tools.isblank(entity.getControllerstate())) {
                        String status = "";
                        if (Tools.equals("0",entity.getControllerstate())) {
                            status = "正常";
                        }else{
                            status = "不正常";
                        }
                        cell2 = new jxl.write.Label(i, 5, status, wcf);
                    }
                    else {
                        cell2 = new jxl.write.Label(i, 5, "", wcf);
                    }
                    sheet.addCell(cell2);
                    // 砂滤罐压差
                    if(!Tools.isblank(entity.getSandleachinletpressur())) {
                        cell3 = new jxl.write.Number(i, 6, entity.getSandleachinletpressur().doubleValue(), wcf);
                    }
                    else {
                        cell3 = new jxl.write.Label(i, 6, "", wcf);
                    }
                    sheet.addCell(cell3);
                    // 砂滤罐反冲
                    if(!Tools.isblank(entity.getSandleachrecoil())) {
                        String flag="";
                        if("0".equals(entity.getSandleachrecoil())) {
                            flag = "√";
                        }
                        else {
                            flag = "×";
                        }
                        cell4 = new jxl.write.Label(i, 7, flag, wcf);
                    }
                    else {
                        cell4 = new jxl.write.Label(i, 7, "", wcf);
                    }
                    sheet.addCell(cell4);
                    // 活性炭罐压差
                    if(!Tools.isblank(entity.getCarbonfiltrationchlorine())) {
                        cell5 = new jxl.write.Number(i, 8,  entity.getCarbonfiltrationchlorine().doubleValue(), wcf);
                    }
                    else {
                        cell5 = new jxl.write.Label(i, 8, "", wcf);
                    }
                    sheet.addCell(cell5);
                    // 活性炭罐反冲
                    if(!Tools.isblank(entity.getCarbonfiltrationrecoil())) {
                        String flag="";
                        if("0".equals(entity.getCarbonfiltrationrecoil())) {
                            flag = "√";
                        }
                        else {
                            flag = "×";
                        }
                        cell6 = new jxl.write.Label(i, 9, flag, wcf);
                    }
                    else {
                        cell6 = new jxl.write.Label(i, 9, "", wcf);
                    }
                    sheet.addCell(cell6);
                    // 残余氯
                    if(!Tools.isblank(entity.getRemnantcl())) {
                        cell7 = new jxl.write.Number(i, 10, entity.getRemnantcl().doubleValue(), wcf);
                    }
                    else {
                        cell7 = new jxl.write.Label(i, 10, "", wcf);
                    }
                    sheet.addCell(cell7);
                    // 树脂罐压差
                    if(!Tools.isblank(entity.getSoftwaterhardness())) {
                        cell8 = new jxl.write.Number(i, 11, entity.getSoftwaterhardness().doubleValue(), wcf);
                    }
                    else {
                        cell8 = new jxl.write.Label(i, 11, "", wcf);
                    }
                    sheet.addCell(cell8);

                    // 树脂罐反冲
                    if(!Tools.isblank(entity.getSoftwaterreproduce())) {
                        String flag="";
                        if("0".equals(entity.getSoftwaterreproduce())) {
                            flag = "√";
                        }
                        else {
                            flag = "×";
                        }
                        cell9 = new jxl.write.Label(i, 12, flag, wcf);
                    }
                    else {
                        cell9 = new jxl.write.Label(i, 12, "", wcf);
                    }
                    sheet.addCell(cell9);
                    // 硬度
                    if(!Tools.isblank(entity.getHardness())) {
                        cell10 = new jxl.write.Number(i, 13,entity.getHardness().doubleValue(), wcf);
                    }
                    else {
                        cell10 = new jxl.write.Label(i, 13, "", wcf);
                    }
                    sheet.addCell(cell10);
                    // 过滤器
                    if(!Tools.isblank(entity.getFilter())) {
                        cell11 = new jxl.write.Label(i, 14, entity.getFilter(), wcf);
                    }
                    else {
                        cell11 = new jxl.write.Label(i, 14, "", wcf);
                    }
                    sheet.addCell(cell11);
                    // 数量
                    if(!Tools.isblank(entity.getAmount())) {
                        cell12 = new jxl.write.Label(i, 15, entity.getAmount(), wcf);
                    }
                    else {
                        cell12 = new jxl.write.Label(i, 15, "", wcf);
                    }
                    sheet.addCell(cell12);

                    // 水机进水压力
                    if(!Tools.isblank(entity.getPremembranepressure())) {
                        cell13 = new jxl.write.Number(i, 16, entity.getPremembranepressure().doubleValue(), wcf);
                    }
                    else {
                        cell13 = new jxl.write.Label(i, 16, "", wcf);
                    }
                    sheet.addCell(cell13);
                    // 反渗膜/1级膜进水压力
                    if(!Tools.isblank(entity.getPostmembranepressure())) {
                        cell14 = new jxl.write.Number(i, 17, entity.getPostmembranepressure().doubleValue(), wcf);
                    }
                    else {
                        cell14 = new jxl.write.Label(i, 17, "", wcf);
                    }
                    sheet.addCell(cell14);
                    // 反渗膜/1级膜排水压力
                    if(!Tools.isblank(entity.getWatersupplypressure())) {
                        cell15 = new jxl.write.Number(i, 18, entity.getWatersupplypressure().doubleValue(), wcf);
                    }
                    else {
                        cell15 = new jxl.write.Label(i, 18, "", wcf);
                    }
                    sheet.addCell(cell15);
                    //反渗膜/1级膜产水压力
                    if(!Tools.isblank(entity.getBackwaterpressure())) {
                        cell16 = new jxl.write.Number(i, 19, entity.getBackwaterpressure().doubleValue(), wcf);
                    }
                    else {
                        cell16 = new jxl.write.Label(i, 19, "", wcf);
                    }
                    sheet.addCell(cell16);

                    if("1".equals(level)){
                        // 2级膜进水压力
                        if(!Tools.isblank(entity.getPremembranepressure2())) {
                            cell17 = new jxl.write.Number(i, 20, entity.getPremembranepressure2().doubleValue(), wcf);
                        }
                        else {
                            cell17 = new jxl.write.Label(i, 20, "", wcf);
                        }
                        sheet.addCell(cell17);
                        // 2级膜排水压力
                        if(!Tools.isblank(entity.getPostmembranepressure2())) {
                            cell18 = new jxl.write.Number(i, 21, entity.getPostmembranepressure2().doubleValue(), wcf);
                        }
                        else {
                            cell18 = new jxl.write.Label(i, 21, "", wcf);
                        }
                        sheet.addCell(cell18);
                        // 2级膜产水压力
                        if(!Tools.isblank(entity.getWatersupplypressure2())) {
                            cell19 = new jxl.write.Number(i, 22, entity.getWatersupplypressure2().doubleValue(), wcf);
                        }
                        else {
                            cell19 = new jxl.write.Label(i, 22, "", wcf);
                        }
                        sheet.addCell(cell19);
                        // 纯水回水压力
                        if(!Tools.isblank(entity.getWaterproduction())) {
                            cell20 = new jxl.write.Number(i, 23, entity.getWaterproduction().doubleValue(), wcf);
                        }
                        else {
                            cell20 = new jxl.write.Label(i, 23, "", wcf);
                        }
                        sheet.addCell(cell20);
                        // 1级膜产水电导率
                        if(!Tools.isblank(entity.getConductivity())) {
                            cell21 = new jxl.write.Number(i, 24, entity.getConductivity().doubleValue(), wcf);
                        }
                        else {
                            cell21 = new jxl.write.Label(i, 24, "", wcf);
                        }
                        sheet.addCell(cell21);
                        // 2级膜产水电导率
                        if(!Tools.isblank(entity.getConductivity())) {
                            cell22 = new jxl.write.Number(i, 25, entity.getConductivity().doubleValue(), wcf);
                        }
                        else {
                            cell22 = new jxl.write.Label(i, 25, "", wcf);
                        }
                        sheet.addCell(cell22);
                        // 产水量
                        if(!Tools.isblank(entity.getWaterproductionamount())) {
                            cell23 = new jxl.write.Number(i, 26, entity.getWaterproductionamount().doubleValue(), wcf);
                        }
                        else {
                            cell23 = new jxl.write.Label(i, 26, "", wcf);
                        }
                        sheet.addCell(cell23);
                        // 回水量
                        if(!Tools.isblank(entity.getBackwatervolume())) {
                            cell24 = new jxl.write.Number(i, 27, entity.getBackwatervolume().doubleValue(), wcf);
                        }
                        else {
                            cell24 = new jxl.write.Label(i, 27, "", wcf);
                        }
                        sheet.addCell(cell24);
                        // 废水量
                        if(!Tools.isblank(entity.getWastewateramount())) {
                            cell25 = new jxl.write.Number(i, 28, entity.getWastewateramount().doubleValue(), wcf);
                        }
                        else {
                            cell25 = new jxl.write.Label(i, 28, "", wcf);
                        }
                        sheet.addCell(cell25);
                    }else{
                        // 纯水回水压力
                        if(!Tools.isblank(entity.getWaterproduction())) {
                            cell17 = new jxl.write.Number(i, 20, entity.getWaterproduction().doubleValue(), wcf);
                        }
                        else {
                            cell17 = new jxl.write.Label(i, 20, "", wcf);
                        }
                        sheet.addCell(cell17);
                        // 进水电导率
                        if(!Tools.isblank(entity.getConductivity())) {
                            cell18 = new jxl.write.Number(i, 21, entity.getConductivity().doubleValue(), wcf);
                        }
                        else {
                            cell18 = new jxl.write.Label(i, 21, "", wcf);
                        }
                        sheet.addCell(cell18);
                        // 产水量
                        if(!Tools.isblank(entity.getWaterproductionamount())) {
                            cell19 = new jxl.write.Number(i, 22, entity.getWaterproductionamount().doubleValue(), wcf);
                        }
                        else {
                            cell19 = new jxl.write.Label(i, 22, "", wcf);
                        }
                        sheet.addCell(cell19);
                        // 回水量
                        if(!Tools.isblank(entity.getBackwatervolume())) {
                            cell20 = new jxl.write.Number(i, 23, entity.getBackwatervolume().doubleValue(), wcf);
                        }
                        else {
                            cell20 = new jxl.write.Label(i, 23, "", wcf);
                        }
                        sheet.addCell(cell20);
                        // 废水量
                        if(!Tools.isblank(entity.getWastewateramount())) {
                            cell21 = new jxl.write.Number(i, 24, entity.getWastewateramount().doubleValue(), wcf);
                        }
                        else {
                            cell21 = new jxl.write.Label(i, 24, "", wcf);
                        }
                        sheet.addCell(cell21);
                        // 产水电导率
                        if(!Tools.isblank(entity.getGradetwoconductivity())) {
                            cell22 = new jxl.write.Number(i, 25, entity.getGradetwoconductivity().doubleValue(), wcf);
                        }
                        else {
                            cell22 = new jxl.write.Label(i, 25, "", wcf);
                        }
                        sheet.addCell(cell22);
                        // 水温
                        if(!Tools.isblank(entity.getTemperature())) {
                            cell23 = new jxl.write.Number(i, 26, entity.getTemperature().doubleValue(), wcf);
                        }
                        else {
                            cell23 = new jxl.write.Label(i, 26, "", wcf);
                        }
                        sheet.addCell(cell23);
                    }

                }
                //当天没数据
                else {
                    cell1 = new jxl.write.Label(i, 4, "", wcf);
                    cell2 = new jxl.write.Label(i, 5, "", wcf);
                    cell3 = new jxl.write.Label(i, 6, "", wcf);
                    cell4 = new jxl.write.Label(i, 7, "", wcf);
                    cell5 = new jxl.write.Label(i, 8, "", wcf);
                    cell6 = new jxl.write.Label(i, 9, "", wcf);
                    cell7 = new jxl.write.Label(i, 10, "", wcf);
                    cell8 = new jxl.write.Label(i, 11, "", wcf);
                    cell9 = new jxl.write.Label(i, 12, "", wcf);
                    cell10 = new jxl.write.Label(i, 13, "", wcf);
                    cell11 = new jxl.write.Label(i, 14, "", wcf);
                    cell12 = new jxl.write.Label(i, 15, "", wcf);
                    cell13 = new jxl.write.Label(i, 16, "", wcf);
                    cell14 = new jxl.write.Label(i, 17, "", wcf);
                    cell15 = new jxl.write.Label(i, 18, "", wcf);
                    cell16 = new jxl.write.Label(i, 19, "", wcf);
                    cell17 = new jxl.write.Label(i, 20, "", wcf);
                    cell18 = new jxl.write.Label(i, 21, "", wcf);
                    cell19 = new jxl.write.Label(i, 22, "", wcf);
                    cell20 = new jxl.write.Label(i, 23, "", wcf);
                    cell21 = new jxl.write.Label(i, 24, "", wcf);
                    cell22 = new jxl.write.Label(i, 25, "", wcf);
                    cell23 = new jxl.write.Label(i, 26, "", wcf);
                    sheet.addCell(cell1);
                    sheet.addCell(cell2);
                    sheet.addCell(cell3);
                    sheet.addCell(cell4);
                    sheet.addCell(cell5);
                    sheet.addCell(cell6);
                    sheet.addCell(cell7);
                    sheet.addCell(cell8);
                    sheet.addCell(cell9);
                    sheet.addCell(cell10);
                    sheet.addCell(cell11);
                    sheet.addCell(cell12);
                    sheet.addCell(cell13);
                    sheet.addCell(cell14);
                    sheet.addCell(cell15);
                    sheet.addCell(cell16);
                    sheet.addCell(cell17);
                    sheet.addCell(cell18);
                    sheet.addCell(cell19);
                    sheet.addCell(cell20);
                    sheet.addCell(cell21);
                    sheet.addCell(cell22);
                    sheet.addCell(cell23);
                    if("1".equals(level)) {
                        cell24 = new jxl.write.Label(i, 27, "", wcf);
                        cell25 = new jxl.write.Label(i, 28, "", wcf);
                        sheet.addCell(cell24);
                        sheet.addCell(cell25);
                    }
                }
            }
            //给空白处添加格式
            for(int i=colnum+2; i<20 ;i++) {
                WritableCell cell1;
                WritableCell cell2;
                WritableCell cell3;
                WritableCell cell4;
                WritableCell cell5;
                WritableCell cell6;
                WritableCell cell7;
                WritableCell cell8;
                WritableCell cell9;
                WritableCell cell10;
                WritableCell cell11;
                WritableCell cell12;
                WritableCell cell13;
                WritableCell cell14;
                WritableCell cell15;
                WritableCell cell16;
                WritableCell cell17;
                WritableCell cell18;
                WritableCell cell19;
                WritableCell cell20;
                WritableCell cell21;
                WritableCell cell22;
                WritableCell cell23;
                WritableCell cell24;
                WritableCell cell25;
                WritableCell cell26;
                WritableCell cell27;
                cell1 = new jxl.write.Label(i, 2, "", wcf);
                cell2 = new jxl.write.Label(i, 3, "", wcf);
                cell3 = new jxl.write.Label(i, 4, "", wcf);
                cell4 = new jxl.write.Label(i, 5, "", wcf);
                cell5 = new jxl.write.Label(i, 6, "", wcf);
                cell6 = new jxl.write.Label(i, 7, "", wcf);
                cell7 = new jxl.write.Label(i, 8, "", wcf);
                cell8 = new jxl.write.Label(i, 9, "", wcf);
                cell9 = new jxl.write.Label(i, 10, "", wcf);
                cell10 = new jxl.write.Label(i, 11, "", wcf);
                cell11 = new jxl.write.Label(i, 12, "", wcf);
                cell12 = new jxl.write.Label(i, 13, "", wcf);
                cell13 = new jxl.write.Label(i, 14, "", wcf);
                cell14 = new jxl.write.Label(i, 15, "", wcf);
                cell15 = new jxl.write.Label(i, 16, "", wcf);
                cell16 = new jxl.write.Label(i, 17, "", wcf);
                cell17 = new jxl.write.Label(i, 18, "", wcf);
                cell18 = new jxl.write.Label(i, 19, "", wcf);
                cell19 = new jxl.write.Label(i, 20, "", wcf);
                cell20 = new jxl.write.Label(i, 21, "", wcf);
                cell21 = new jxl.write.Label(i, 22, "", wcf);
                cell22 = new jxl.write.Label(i, 23, "", wcf);
                cell23 = new jxl.write.Label(i, 24, "", wcf);
                cell24 = new jxl.write.Label(i, 25, "", wcf);
                cell25 = new jxl.write.Label(i, 26, "", wcf);
                sheet.addCell(cell1);
                sheet.addCell(cell2);
                sheet.addCell(cell3);
                sheet.addCell(cell4);
                sheet.addCell(cell5);
                sheet.addCell(cell6);
                sheet.addCell(cell7);
                sheet.addCell(cell8);
                sheet.addCell(cell9);
                sheet.addCell(cell10);
                sheet.addCell(cell11);
                sheet.addCell(cell12);
                sheet.addCell(cell13);
                sheet.addCell(cell14);
                sheet.addCell(cell15);
                sheet.addCell(cell16);
                sheet.addCell(cell17);
                sheet.addCell(cell18);
                sheet.addCell(cell19);
                sheet.addCell(cell20);
                sheet.addCell(cell21);
                sheet.addCell(cell22);
                sheet.addCell(cell23);
                sheet.addCell(cell24);
                sheet.addCell(cell25);
                if("1".equals(level)) {
                    cell26 = new jxl.write.Label(i, 27, "", wcf);
                    cell27 = new jxl.write.Label(i, 28, "", wcf);
                    sheet.addCell(cell26);
                    sheet.addCell(cell27);
                }
            }

            //写入维护记录和工程师
            if(!Tools.listisblank(sheetlist)) {
                WritableCell cell19;
                WritableCell cell20;
                WaterMaintenanceRecordResultForm entity = sheetlist.get(0);
                if("0".equals(level)) {
                    cell19 = new jxl.write.Label(1, 27, entity.getMaintenancerecord(), wcf);
                    cell20 = new jxl.write.Label(18, 27, entity.getEngineer(), wcf);
                    sheet.addCell(cell19);
                    sheet.addCell(cell20);
                    sheet.mergeCells(1, 27, 15, 30);
                    sheet.mergeCells(18, 27, 19, 30);

                }
                else {
                    cell19 = new jxl.write.Label(1, 29, entity.getMaintenancerecord(), wcf);
                    cell20 = new jxl.write.Label(18, 29, entity.getEngineer(), wcf);
                    sheet.addCell(cell19);
                    sheet.addCell(cell20);
                    sheet.mergeCells(1, 29, 15, 32);
                    sheet.mergeCells(18, 29, 19, 32);
                }
            }
            else {
                WritableCell cell19;
                WritableCell cell20;
                if("0".equals(level)) {
                    cell19 = new jxl.write.Label(1, 27,"", wcf);
                    cell20 = new jxl.write.Label(18, 27,"", wcf);
                    sheet.addCell(cell19);
                    sheet.addCell(cell20);
                    sheet.mergeCells(1, 27, 15, 30);
                    sheet.mergeCells(18, 27, 19, 30);
                }
                else {
                    cell19 = new jxl.write.Label(1, 29,"", wcf);
                    cell20 = new jxl.write.Label(18, 29,"", wcf);
                    sheet.addCell(cell19);
                    sheet.addCell(cell20);
                    sheet.mergeCells(1, 29, 15, 32);
                    sheet.mergeCells(18, 29, 19, 32);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static WritableSheet setHeader1(WritableCellFormat twcf, WritableSheet sheet,int year,int month,int position,int daynum,String level) {
        //单级
        if("0".equals(level)) {
            //总共20列
            sheet.setColumnView(0, 15);
            sheet.setColumnView(1, 17);
            sheet.setColumnView(2, 10);
            sheet.setColumnView(3, 10);
            sheet.setColumnView(4, 10);
            sheet.setColumnView(5, 10);
            sheet.setColumnView(6, 10);
            sheet.setColumnView(7, 10);
            sheet.setColumnView(8, 10);
            sheet.setColumnView(9, 10);
            sheet.setColumnView(10, 10);
            sheet.setColumnView(11, 10);
            sheet.setColumnView(12, 10);
            sheet.setColumnView(13, 10);
            sheet.setColumnView(14, 10);
            sheet.setColumnView(15, 10);
            sheet.setColumnView(16, 10);
            sheet.setColumnView(17, 10);
            sheet.setColumnView(18, 10);
            sheet.setColumnView(19, 10);

            Label title=new Label(0,0,"水处理系统维护检测记录",twcf);
            //拼接日期
            String str = year + "年" +month + "月";
            Label time=new Label(16,0,str,twcf);

            Label jmglq = new Label(0,4,"精密过滤器",twcf);
            Label sl = new Label(0,6,"砂滤",twcf);
            Label tl = new Label(0,8,"碳滤",twcf);
            Label szg = new Label(0,11,"树脂罐",twcf);
            Label rs = new Label(0,13,"软水",twcf);
            Label ghglq = new Label(0,14,"更换过滤器",twcf);
            Label jq = new Label(0,16,"DWA单级反渗机",twcf);
            Label whjl = new Label(0,27,"维护记录",twcf);

            Label date = new Label(1,2,"日期",twcf);
            Label week = new Label(1,3,"星期",twcf);
            Label waterInletPressure = new Label(1,4,"进水压力(bar)",twcf);
            Label controllerStatus = new Label(1,5,"控制器状态",twcf);
            Label sandFilterTankPressureDifference = new Label(1,6,"砂滤罐压差(bar)",twcf);
            Label sandFilteTankRecoil = new Label(1,7,"砂滤罐反冲(bar)",twcf);
            Label activatedCarbonTankPressureDifference = new Label(1,8,"活性炭罐压差(bar)",twcf);
            Label activatedCarbonTankRecoil = new Label(1,9,"活性炭罐反冲",twcf);
            Label residualChlorine = new Label(1,10,"残余氯(mg/L)",twcf);
            Label resinTankPressureDifference = new Label(1,11,"树脂罐压差(bar)",twcf);
            Label resinTankRecoil = new Label(1,12,"树脂罐反冲",twcf);
            Label hardness = new Label(1,13,"硬度(mg/L)",twcf);
            Label filter = new Label(1,14,"过滤器",twcf);
            Label quantity = new Label(1,15,"数量",twcf);
            Label waterMachineInletPressure = new Label(1,16,"水机进水压力(bar)",twcf);
            Label waterPressureOfReverseOsmosisMembrane = new Label(1,17,"反渗膜进水压力(bar)",twcf);
            Label reverseOsmosisMembraneDrainagePressure = new Label(1,18,"反渗膜排水压力(bar)",twcf);
            Label waterPressureOfROMembrane = new Label(1,19,"反渗膜产水压力(bar)",twcf);
            Label pureWaterBackwaterPressure = new Label(1,20,"纯水回水压力(bar)",twcf);
            Label influentConductivity = new Label(1,21,"进水电导率(um/cm)",twcf);
            Label waterProduction = new Label(1,22,"产水量(L/H)",twcf);
            Label backwater = new Label(1,23,"回水量(L/H)",twcf);
            Label wasteWaterVolumec = new Label(1,24,"废水量(L/H)",twcf);
            Label productWaterConductivity = new Label(1,25,"产水电导率(um/cm)",twcf);
            Label waterTemperature = new Label(1,26,"水温(℃)",twcf);
            Label engineer=new Label(16,27,"工程师",twcf);

            try {
                sheet.addCell(title);
                sheet.addCell(time);
                sheet.addCell(jmglq);
                sheet.addCell(szg);
                sheet.addCell(sl);
                sheet.addCell(tl);
                sheet.addCell(ghglq);
                sheet.addCell(rs);
                sheet.addCell(jq);
                sheet.addCell(whjl);
                sheet.addCell(date);
                sheet.addCell(week);
                sheet.addCell(waterInletPressure);
                sheet.addCell(controllerStatus);
                sheet.addCell(sandFilterTankPressureDifference);
                sheet.addCell(sandFilteTankRecoil);
                sheet.addCell(activatedCarbonTankPressureDifference);
                sheet.addCell(activatedCarbonTankRecoil);
                sheet.addCell(residualChlorine);
                sheet.addCell(filter);
                sheet.addCell(resinTankPressureDifference);
                sheet.addCell(resinTankRecoil);
                sheet.addCell(hardness);
                sheet.addCell(quantity);
                sheet.addCell(waterMachineInletPressure);
                sheet.addCell(waterPressureOfReverseOsmosisMembrane);
                sheet.addCell(reverseOsmosisMembraneDrainagePressure);
                sheet.addCell(waterPressureOfROMembrane);
                sheet.addCell(waterProduction);
                sheet.addCell(pureWaterBackwaterPressure);
                sheet.addCell(influentConductivity);
                sheet.addCell(backwater);
                sheet.addCell(wasteWaterVolumec);
                sheet.addCell(productWaterConductivity);
                sheet.addCell(waterTemperature);
                sheet.addCell(engineer);

                //标题合并单元格 0~15 标题 0~1行 列1，行1，列2，行2
                sheet.mergeCells(0, 0, 15, 1);
                //日期合并单元格
                sheet.mergeCells(16, 0, 19, 1);
                //合并空白
                sheet.mergeCells(0, 2, 0, 3);
                //合并左侧列标题
                sheet.mergeCells(0, 4, 0, 5);
                sheet.mergeCells(0, 6, 0, 7);
                sheet.mergeCells(0, 8, 0, 10);
                sheet.mergeCells(0, 11, 0, 12);
                sheet.mergeCells(0, 13, 0, 13);
                sheet.mergeCells(0, 14, 0, 15);
                sheet.mergeCells(0, 16, 0, 26);
                sheet.mergeCells(0, 27, 0, 30);
                //合并维护记录和工程师单元格
                sheet.mergeCells(16, 27, 17, 30);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }

            //上半月情况
            if(position == 0) {
                for(int i=1;i<=15;i++) {
                    try {
                        sheet.addCell(new Label(i+1,2,i+"",twcf));
                        sheet.addCell(new Label(i+1,3,GetWeek(year,month,i),twcf));
                    } catch (RowsExceededException e) {
                        e.printStackTrace();
                    } catch (WriteException e) {
                        e.printStackTrace();
                    }
                }
            }
            //下半月情况
            else {
                for(int i=16,k=2;i<=daynum;i++,k++) {
                    try {
                        sheet.addCell(new Label(k,2,i+"",twcf));
                        sheet.addCell(new Label(k,3,GetWeek(year,month,i),twcf));
                    } catch (RowsExceededException e) {
                        e.printStackTrace();
                    } catch (WriteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //双极
        else {
            // setColumnView(int col, int width) 列和对应宽度
            sheet.setColumnView(0, 17);
            sheet.setColumnView(1, 18);
            sheet.setColumnView(2, 10);
            sheet.setColumnView(3, 10);
            sheet.setColumnView(4, 10);
            sheet.setColumnView(5, 10);
            sheet.setColumnView(6, 10);
            sheet.setColumnView(7, 10);
            sheet.setColumnView(8, 10);
            sheet.setColumnView(9, 10);
            sheet.setColumnView(10, 10);
            sheet.setColumnView(11, 10);
            sheet.setColumnView(12, 10);
            sheet.setColumnView(13, 10);
            sheet.setColumnView(14, 10);
            sheet.setColumnView(15, 10);
            sheet.setColumnView(16, 10);
            sheet.setColumnView(17, 10);
            sheet.setColumnView(18, 10);
            sheet.setColumnView(19, 10);

            // Label(int c, int r, String cont, CellFormat st)  列， 行，title内容 ，format
            Label title=new Label(0,0,"水处理系统维护检测记录",twcf);
            //拼接日期
            String str = year + "年" +month + "月";
            Label time=new Label(16,0,str,twcf);

            Label jmglq = new Label(0,4,"精密过滤器",twcf);
            Label sl = new Label(0,6,"砂滤",twcf);
            Label tl = new Label(0,8,"碳滤",twcf);
            Label szg = new Label(0,11,"树脂罐",twcf);
            Label rs = new Label(0,13,"软水",twcf);
            Label ghglq = new Label(0,14,"更换过滤器",twcf);
            Label jq = new Label(0,16,"ME4|750双级反渗机",twcf);
            Label whjl = new Label(0,29,"维护记录",twcf);

            Label date = new Label(1,2,"日期",twcf);
            Label week = new Label(1,3,"星期",twcf);
            Label waterInletPressure = new Label(1,4,"进水压力(bar)",twcf);
            Label controllerStatus = new Label(1,5,"控制器状态",twcf);
            Label sandFilterTankPressureDifference = new Label(1,6,"砂滤罐压差(bar)",twcf);
            Label sandFilteTankRecoil = new Label(1,7,"砂滤罐反冲(bar)",twcf);
            Label activatedCarbonTankPressureDifference = new Label(1,8,"活性炭罐压差(bar)",twcf);
            Label activatedCarbonTankRecoil = new Label(1,9,"活性炭罐反冲",twcf);
            Label residualChlorine = new Label(1,10,"残余氯(mg/L)",twcf);
            Label resinTankPressureDifference = new Label(1,11,"树脂罐压差(bar)",twcf);
            Label resinTankRecoil = new Label(1,12,"树脂罐反冲",twcf);
            Label hardness = new Label(1,13,"硬度(mg/L)",twcf);
            Label filter = new Label(1,14,"过滤器",twcf);
            Label quantity = new Label(1,15,"数量",twcf);
            Label waterMachineInletPressure = new Label(1,16,"水机进水压力(bar)",twcf);
            Label waterInletPressure1 = new Label(1,17,"1级膜进水压力(bar)",twcf);
            Label drainagePressure1 = new Label(1,18,"1级膜排水压力(bar)",twcf);
            Label waterPressure1 = new Label(1,19,"1级膜产水压力(bar)",twcf);
            Label waterInletPressure2 = new Label(1,20,"2级膜进水压力(bar)",twcf);
            Label drainagePressure2 = new Label(1,21,"2级膜排水压力(bar)",twcf);
            Label waterPressure2 = new Label(1,22,"2级膜产水压力(bar)",twcf);
            Label pureWaterBackwaterPressure = new Label(1,23,"纯水回水压力(bar)",twcf);
            Label productWaterConductivity1 = new Label(1,24,"1级产水电导率(um/cm)",twcf);
            Label productWaterConductivity2 = new Label(1,25,"2级产水电导率(um/cm)",twcf);
            Label waterProduction = new Label(1,26,"产水量(L/h)",twcf);
            Label backwater = new Label(1,27,"回水量(L/h)",twcf);
            Label wasteWaterVolumec = new Label(1,28,"废水量(L/h)",twcf);
            Label engineer=new Label(16,29,"工程师",twcf);

            try {
                sheet.addCell(title);
                sheet.addCell(time);
                sheet.addCell(jmglq);
                sheet.addCell(szg);
                sheet.addCell(sl);
                sheet.addCell(tl);
                sheet.addCell(ghglq);
                sheet.addCell(rs);
                sheet.addCell(jq);
                sheet.addCell(whjl);
                sheet.addCell(date);
                sheet.addCell(week);
                sheet.addCell(waterInletPressure);
                sheet.addCell(controllerStatus);
                sheet.addCell(sandFilterTankPressureDifference);
                sheet.addCell(sandFilteTankRecoil);
                sheet.addCell(activatedCarbonTankPressureDifference);
                sheet.addCell(activatedCarbonTankRecoil);
                sheet.addCell(residualChlorine);
                sheet.addCell(resinTankPressureDifference);
                sheet.addCell(resinTankRecoil);
                sheet.addCell(hardness);
                sheet.addCell(filter);
                sheet.addCell(quantity);
                sheet.addCell(waterMachineInletPressure);
                sheet.addCell(waterInletPressure1);
                sheet.addCell(drainagePressure1);
                sheet.addCell(waterPressure1);
                sheet.addCell(waterInletPressure2);
                sheet.addCell(drainagePressure2);
                sheet.addCell(waterPressure2);
                sheet.addCell(pureWaterBackwaterPressure);
                sheet.addCell(productWaterConductivity1);
                sheet.addCell(productWaterConductivity2);
                sheet.addCell(waterProduction);
                sheet.addCell(backwater);
                sheet.addCell(wasteWaterVolumec);
                sheet.addCell(engineer);

                //标题合并单元格
                sheet.mergeCells(0, 0, 15, 1);
                //日期合并单元格
                sheet.mergeCells(16, 0, 19, 1);
                //合并空白
                sheet.mergeCells(0, 2, 0, 3);
                //合并左侧列标题
                sheet.mergeCells(0, 4, 0, 5);
                sheet.mergeCells(0, 6, 0, 7);
                sheet.mergeCells(0, 8, 0, 10);
                sheet.mergeCells(0, 11, 0, 12);
                sheet.mergeCells(0, 13, 0, 13);
                sheet.mergeCells(0, 14, 0, 15);
                sheet.mergeCells(0, 16, 0, 28);
                sheet.mergeCells(0, 29, 0, 32);
                //合并维护记录和工程师单元格
                //sheet.mergeCells(1, 22, 15, 25);
                sheet.mergeCells(16, 29, 17, 32);
                //sheet.mergeCells(18, 22, 19, 25);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }

            //上半月情况
            if(position == 0) {
                for(int i=1;i<=15;i++) {
                    try {
                        sheet.addCell(new Label(i+1,2,i+"",twcf));
                        sheet.addCell(new Label(i+1,3,GetWeek(year,month,i),twcf));
                    } catch (RowsExceededException e) {
                        e.printStackTrace();
                    } catch (WriteException e) {
                        e.printStackTrace();
                    }
                }
            }
            //下半月情况
            else {
                for(int i=16,k=2;i<=daynum;i++,k++) {
                    try {
                        sheet.addCell(new Label(k,2,i+"",twcf));
                        sheet.addCell(new Label(k,3,GetWeek(year,month,i),twcf));
                    } catch (RowsExceededException e) {
                        e.printStackTrace();
                    } catch (WriteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sheet;
    }

    //计算总共的页数
    private int calsheetnum(String startYear,String startMonth,String startPoisition,String endYear,String endMonth,String endPoisition) {
        int result = 0;
        int startY = Integer.parseInt(startYear);
        int startM = Integer.parseInt(startMonth);
        int endY = Integer.parseInt(endYear);
        int endM = Integer.parseInt(endMonth);
        result = ((endY - startY) *12 + endM - startM - 1)*2;
        //开始时间在上半月，则加两页；如果在下半月，则加一页
        if("0".equals(startPoisition)) {
            result = result + 2;
        }else {
            result = result + 1;
        }
        //结束时间在上半月，则加一页；如果在下半月，则加两页
        if("0".equals(endPoisition)) {
            result = result + 1;
        }else {
            result = result + 2;
        }

        return result;
    }

    private List<Integer> next(int startYear,int startMonth,int startPoisition) {
        List<Integer> result = new ArrayList<>();
        if(startPoisition == 0) {
            result.add(startYear);
            result.add(startMonth);
            result.add(1);
        }else {
            if(startMonth == 12) {
                result.add(startYear+1);
                result.add(1);
                result.add(0);
            }else {
                result.add(startYear);
                result.add(startMonth+1);
                result.add(0);
            }
        }
        return result;
    }

    private int getmonthday(int year,int month) {
        //闰年标识，false：平年，true：闰年
        int daynum = 0;
        boolean flag = false;
        if(year % 4==0 && year % 100 !=0 || year % 400 ==0) {
            flag = true;
        }else {
            flag = false;
        }
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:daynum=31;break;
            case 2:daynum = flag?29:28;break;
            case 4:
            case 6:
            case 9:
            case 11:daynum=30;break;
        }
        return daynum;
    }
    //判断某一天是星期几
    private static String GetWeek(int y, int m, int d) {
        String result="";
        if(m < 3) {
            m += 12;
            --y;
        }
        int w = (d + 1 + 2 * m + 3 * (m + 1) / 5 + y + (y >> 2) - y / 100 + y / 400) % 7;
        switch(w) {
            case 0:result="日";break;
            case 1:result="一";break;
            case 2:result="二";break;
            case 3:result="三";break;
            case 4:result="四";break;
            case 5:result="五";break;
            case 6:result="六";break;
        }
        return result;
    }

}
