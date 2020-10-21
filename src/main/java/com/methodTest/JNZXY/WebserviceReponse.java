package com.methodTest.JNZXY;

import com.entity.IResultsResultForm;
import com.tools.Tools;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wudeyuan
 * @date 2020/7/27 11:44
 * @description
 */
public class WebserviceReponse {
    public static  void main(String[] args){
        String xml = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><ns2:HIPMessageServerMQResponse xmlns:ns2=\"http://messageServer.jcfw.zhanhong.com/\"><return>&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt;\n" +
                "\n" +
                "&lt;response&gt;\n" +
                "  &lt;responseId value=\"D355F15DCDA542F4BBF47D9BBD66D428\"/&gt;\n" +
                "  &lt;createTime value=\"2020-07-27 12:44:30\"/&gt;\n" +
                "  &lt;requestId value=\"a6b38c2e8e484fe\"/&gt;\n" +
                "  &lt;ret value=\"0\"/&gt;\n" +
                "  &lt;msg value=\"成功\"/&gt;\n" +
                "  &lt;serviceCode value=\"B_LIS_RESULT\"/&gt;\n" +
                "  &lt;serviceName value=\"患者检验检查结果查询服务\"/&gt;\n" +
                "  &lt;pageNum value=\"2\"/&gt;\n" +
                "  &lt;pageSize value=\"20\"/&gt;\n" +
                "  &lt;startRow value=\"21\"/&gt;\n" +
                "  &lt;endRow value=\"37\"/&gt;\n" +
                "  &lt;total value=\"37\"/&gt;\n" +
                "  &lt;pages value=\"2\"/&gt;\n" +
                "  &lt;prePage value=\"1\"/&gt;\n" +
                "  &lt;nextPage value=\"0\"/&gt;\n" +
                "  &lt;list&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"21\"/&gt;\n" +
                "      &lt;ItemCode value=\"1083\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"0.00-0.06\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"0.00\"/&gt;\n" +
                "      &lt;unitname value=\"10^9/L\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"血细胞分析(急诊）\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"30220\"/&gt;\n" +
                "      &lt;SubName value=\"嗜碱细胞绝对数\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 09:02:58\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"22\"/&gt;\n" +
                "      &lt;ItemCode value=\"1083\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"0.160-0.263\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"0.042\"/&gt;\n" +
                "      &lt;unitname value=\"%\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"↓\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"血细胞分析(急诊）\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"30240\"/&gt;\n" +
                "      &lt;SubName value=\"血小板比积\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 09:02:58\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"23\"/&gt;\n" +
                "      &lt;ItemCode value=\"1117\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"2.10-2.60\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"1.98\"/&gt;\n" +
                "      &lt;unitname value=\"mmol/L\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"↓\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"血离子分析(急诊)\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"10421\"/&gt;\n" +
                "      &lt;SubName value=\"钙\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 09:44:08\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"24\"/&gt;\n" +
                "      &lt;ItemCode value=\"1117\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"0.72-1.34\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"2.20\"/&gt;\n" +
                "      &lt;unitname value=\"mmol/L\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"↑\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"血离子分析(急诊)\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"10430\"/&gt;\n" +
                "      &lt;SubName value=\"磷\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 09:44:08\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"25\"/&gt;\n" +
                "      &lt;ItemCode value=\"1117\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"0.70-1.00\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"1.10\"/&gt;\n" +
                "      &lt;unitname value=\"mmol/L\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"↑\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"血离子分析(急诊)\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"10450\"/&gt;\n" +
                "      &lt;SubName value=\"镁\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 09:44:08\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"26\"/&gt;\n" +
                "      &lt;ItemCode value=\"1117\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"3.50-5.30\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"5.80\"/&gt;\n" +
                "      &lt;unitname value=\"mmol/L\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"↑\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"血离子分析(急诊)\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"10460\"/&gt;\n" +
                "      &lt;SubName value=\"钾\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 09:44:08\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"27\"/&gt;\n" +
                "      &lt;ItemCode value=\"1117\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"137.0-147.0\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"137.0\"/&gt;\n" +
                "      &lt;unitname value=\"mmol/L\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"血离子分析(急诊)\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"10470\"/&gt;\n" +
                "      &lt;SubName value=\"钠\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 09:44:08\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"28\"/&gt;\n" +
                "      &lt;ItemCode value=\"1117\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"99.0-110.0\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"102.0\"/&gt;\n" +
                "      &lt;unitname value=\"mmol/L\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"血离子分析(急诊)\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"10480\"/&gt;\n" +
                "      &lt;SubName value=\"氯\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 09:44:08\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"29\"/&gt;\n" +
                "      &lt;ItemCode value=\"1117\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"19.0-29.0\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"20.0\"/&gt;\n" +
                "      &lt;unitname value=\"mmol/L\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"血离子分析(急诊)\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"10570\"/&gt;\n" +
                "      &lt;SubName value=\"二氧化碳\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 09:44:08\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"30\"/&gt;\n" +
                "      &lt;ItemCode value=\"1548\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"阴性-\"/&gt;\n" +
                "      &lt;unitname value=\"\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"（血净专用）乙肝五项定性（金标法）\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"100011\"/&gt;\n" +
                "      &lt;SubName value=\"乙型肝炎病毒表面抗原\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 11:55:17\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"31\"/&gt;\n" +
                "      &lt;ItemCode value=\"1548\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"阴性(-)\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"阴性-\"/&gt;\n" +
                "      &lt;unitname value=\"\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"（血净专用）乙肝五项定性（金标法）\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"100021\"/&gt;\n" +
                "      &lt;SubName value=\"乙型肝炎病毒表面抗体\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 11:55:17\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"32\"/&gt;\n" +
                "      &lt;ItemCode value=\"1548\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"阴性(-)\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"阴性-\"/&gt;\n" +
                "      &lt;unitname value=\"\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"（血净专用）乙肝五项定性（金标法）\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"100031\"/&gt;\n" +
                "      &lt;SubName value=\"乙型肝炎病毒e抗原\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 11:55:17\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"33\"/&gt;\n" +
                "      &lt;ItemCode value=\"1548\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"阴性(-)\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"阴性-\"/&gt;\n" +
                "      &lt;unitname value=\"\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"（血净专用）乙肝五项定性（金标法）\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"100041\"/&gt;\n" +
                "      &lt;SubName value=\"乙型肝炎病毒e抗体\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 11:55:17\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"34\"/&gt;\n" +
                "      &lt;ItemCode value=\"1548\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"阴性(-)\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"阴性-\"/&gt;\n" +
                "      &lt;unitname value=\"\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"（血净专用）乙肝五项定性（金标法）\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"100051\"/&gt;\n" +
                "      &lt;SubName value=\"乙型肝炎病毒核心抗体\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 11:55:17\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"35\"/&gt;\n" +
                "      &lt;ItemCode value=\"1547\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"阴性(-)\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"阴性-\"/&gt;\n" +
                "      &lt;unitname value=\"\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"（血净专用）丙型肝炎抗体测定（金标法）\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"100100\"/&gt;\n" +
                "      &lt;SubName value=\"丙型肝炎病毒抗体\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 11:55:17\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"36\"/&gt;\n" +
                "      &lt;ItemCode value=\"1545\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"阴性(-)\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"阴性-\"/&gt;\n" +
                "      &lt;unitname value=\"\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"（血净专用）梅毒螺旋体特异抗体测定（金标法）\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"100116\"/&gt;\n" +
                "      &lt;SubName value=\"梅毒螺旋体特异性抗体\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 11:55:17\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "    &lt;row&gt;\n" +
                "      &lt;PAGE_ROW_NUMBER value=\"37\"/&gt;\n" +
                "      &lt;ItemCode value=\"1161\"/&gt;\n" +
                "      &lt;PACSDetail value=\"\"/&gt;\n" +
                "      &lt;range value=\"&amp;lt;1\"/&gt;\n" +
                "      &lt;InspectDate value=\"2020-05-26 00:00:00\"/&gt;\n" +
                "      &lt;PicturePath value=\"\"/&gt;\n" +
                "      &lt;Type value=\"0\"/&gt;\n" +
                "      &lt;LabResult value=\"0.05\"/&gt;\n" +
                "      &lt;unitname value=\"C.O.I\"/&gt;\n" +
                "      &lt;PatientID value=\"247601\"/&gt;\n" +
                "      &lt;Alarm value=\"\"/&gt;\n" +
                "      &lt;Note value=\"\"/&gt;\n" +
                "      &lt;ItemName value=\"人免疫缺陷病毒抗体测定(化学发光法)免疫学实验室\"/&gt;\n" +
                "      &lt;PACSResults value=\"\"/&gt;\n" +
                "      &lt;SubCode value=\"100147\"/&gt;\n" +
                "      &lt;SubName value=\"HIV抗体/抗原\"/&gt;\n" +
                "      &lt;ResultDate value=\"2020-05-26 11:55:17\"/&gt;\n" +
                "    &lt;/row&gt;\n" +
                "  &lt;/list&gt;\n" +
                "&lt;/response&gt;\n" +
                "</return></ns2:HIPMessageServerMQResponse></soap:Body></soap:Envelope>";
        String s = handleResponseString(xml);
        List<IResultsResultForm> iResultsResultForms = readStringXmlOutLis(s);
        System.out.println("1");

    }



    private static String handleResponseString(String responString){
        Document soapRes = Jsoup.parse(responString);
        Elements returnEle = soapRes.getElementsByTag("return");
        String s = returnEle.text().replaceAll("&amp;", "~");
        s = returnEle.text().replaceAll("&lt;", "~");
        //String s1 = s.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        return s;

    }

    private static List<IResultsResultForm> readStringXmlOutLis(String xml){
//        logger.info("需要解析的Lis的xml值为=={}",xml);
        List<IResultsResultForm> resultsResultForms = new ArrayList<>();
        org.dom4j.Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML
            Element rootElt = doc.getRootElement();// 获取根节点
            Element retEle = rootElt.element("ret");
            if(Tools.isNotBlank(retEle)){
                String retString = getAttributeValue(rootElt,"ret");
                String msgString =  getAttributeValue(rootElt,"msg");
                if(Tools.equals("0",retString)) {
                    Iterator iter = rootElt.elementIterator("list");
                    // 遍历head节点
                    while (iter.hasNext()) {
                        Element recordEle = (Element) iter.next();
                        Iterator row = recordEle.elementIterator("row");
                        while (row.hasNext()){
                            IResultsResultForm iResultsResultForm = new IResultsResultForm();
                            Element patient= (Element) row.next();
                            String PAGE_ROW_NUMBER = getAttributeValue(patient,"PAGE_ROW_NUMBER");
                            String ItemCode = getAttributeValue(patient,"ItemCode");;
                            iResultsResultForm.setItemcode(ItemCode);
                            String PACSDetail = getAttributeValue(patient,"PACSDetail");
                            if(Tools.isNotBlank(PACSDetail)){
                                iResultsResultForm.setPacsdetail(PACSDetail);
                            }
                            String range = getAttributeValue(patient,"range");
                            if(Tools.isNotBlank(range)){
                                iResultsResultForm.setRange(range);
                            }
                            String InspectDate = getAttributeValue(patient,"InspectDate");
                            iResultsResultForm.setInspectdate(InspectDate);
                            String PicturePath = getAttributeValue(patient,"PicturePath");
                            if(Tools.isNotBlank(PicturePath)){
                                iResultsResultForm.setPicturepath(PicturePath);
                            }
                            String Type = getAttributeValue(patient,"Type");
                            if(Tools.isNotBlank(Type)){
                                iResultsResultForm.setType(Type);
                            }
                            String LabResult = getAttributeValue(patient,"LabResult");
                            if(Tools.isNotBlank(LabResult)){
                                iResultsResultForm.setLabresult(LabResult);
                            }
                            String unitname = getAttributeValue(patient,"unitname");
                            if(Tools.isNotBlank(unitname)){
                                iResultsResultForm.setUnitname(unitname);
                            }
                            // 这里是关联号 并非患者id
                            String PatientID =getAttributeValue(patient,"PatientID");
                            if(Tools.isNotBlank(PatientID)){
                                iResultsResultForm.setPatientcardno(PatientID);

                            }
                            String Alarm =getAttributeValue(patient,"Alarm");
                            if(Tools.isNotBlank(Alarm)){
                                iResultsResultForm.setAlarm(Alarm);
                            }
                            String Note = getAttributeValue(patient,"Note");
                            if(Tools.isNotBlank(Note)){
                                iResultsResultForm.setNote(Note);
                            }
                            String ItemName = getAttributeValue(patient,"ItemName");
                            if(Tools.isNotBlank(ItemName)){
                                iResultsResultForm.setItemname(ItemName);
                            }
                            String PACSResults = getAttributeValue(patient,"PACSResults");
                            if(Tools.isNotBlank(PACSResults)){
                                iResultsResultForm.setPacsresults(PACSResults);
                            }
                            String SubCode = getAttributeValue(patient,"SubCode");
                            if(Tools.isNotBlank(SubCode)){
                                iResultsResultForm.setSubcode(SubCode);
                            }
                            String SubName = getAttributeValue(patient,"SubName");
                            if(Tools.isNotBlank(SubName)){
                                iResultsResultForm.setSubname(SubName);
                            }
                            String ResultDate = getAttributeValue(patient,"ResultDate");
                            if(Tools.isNotBlank(ResultDate)){
                                iResultsResultForm.setResultdate(ResultDate);
                            }

                            resultsResultForms.add(iResultsResultForm);
                        }
                    }
                }else{

                }
            }else{

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultsResultForms;

    }

    private static String getAttributeValue(Element currentEle, String valueName){
        Element retEle = currentEle.element(valueName);
        return retEle.attributeValue("value");
    }

    private static String getNextPage(String resonpseXml){
        String nextPage = "";
        org.dom4j.Document doc = null;
        try {
            doc = DocumentHelper.parseText(resonpseXml); // 将字符串转为XML
            Element rootElt = doc.getRootElement();// 获取根节点
            Element retEle = rootElt.element("nextPage");
            if(Tools.isNotBlank(retEle)){
                nextPage = getAttributeValue(rootElt,"nextPage");
            }
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
        return nextPage;
    }
}
