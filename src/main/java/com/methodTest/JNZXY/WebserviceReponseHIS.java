package com.methodTest.JNZXY;

import com.tools.Tools;
import org.dom4j.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author wudeyuan
 * @date 2020/7/4 16:47
 * @description
 */
public class WebserviceReponseHIS {

    private static final Integer PAGE_NUM = 1;
    private static final Integer PAGE_SIZE = 20;
    /**
     * @description 将xml字符串转换成map
     * @param xml
     * @return Map
     */


    public static void main(String[] args) {

        // 下面是需要解析的xml字符串例子

      String xmlString = "<response>" +
              "  <responseId value=\"28E9C2E13DC44404A8ABA48EF1B24AF9\"/>" +
              "  <createTime value=\"2020-07-21 10:14:46\"/>" +
              "  <requestId value=\"a8fec4042627409fb0fe74f1cac3cb55\"/>" +
              "  <ret value=\"0\"/>" +
              "  <msg value=\"成功\"/>" +
              "  <serviceCode value=\"B_PAITENT_INFO\"/>" +
              "  <serviceName value=\"患者基本信息查询服务\"/>" +
              "  <pageNum value=\"1\"/>\n" +
              "  <pageSize value=\"10\"/>\n" +
              "  <startRow value=\"1\"/>\n" +
              "  <endRow value=\"2\"/>\n" +
              "  <total value=\"2\"/>\n" +
              "  <pages value=\"1\"/>\n" +
              "  <prePage value=\"0\"/>\n" +
              "  <nextPage value=\"0\"/>\n" +
              "  <list>" +
              "    <row>" +
              "      <PATIENTPINYIN value=\"WMY\"/>" +
              "      <PATIENTNAME value=\"王美英\"/>\n" +
              "      <SEX value=\"女\"/>\n" +
              "      <ZIPCODE value=\"250000\"/>\n" +
              "      <HEIGHT value=\"\"/>\n" +
              "      <WARDBLOCK value=\"1003病区护士站\"/>\n" +
              "      <ROW_ID value=\"1\"/>\n" +
              "      <ADDRESS value=\"山东省聊城市莘县东鲁街道刘马庄村305号\"/>\n" +
              "      <IOFLAG value=\"1\"/>\n" +
              "      <TEL value=\"\"/>\n" +
              "      <FAMILYTEL value=\"13963597058\"/>\n" +
              "      <CARDTYPE value=\"0\"/>\n" +
              "      <WEIGHT value=\"\"/>\n" +
              "      <JOB value=\"其它\"/>\n" +
              "      <PATIENTID value=\"247601\"/>\n" +
              "      <FAMILYNAME value=\"房保省\"/>\n" +
              "      <CARDNO value=\"372523196205080564\"/>\n" +
              "      <WARDBEDNO value=\"0\"/>\n" +
              "    </row>\n" +
              "    <row>\n" +
              "      <PATIENTPINYIN value=\"WMY\"/>\n" +
              "      <PATIENTNAME value=\"王美英\"/>\n" +
              "      <SEX value=\"女\"/>\n" +
              "      <ZIPCODE value=\"250000\"/>\n" +
              "      <HEIGHT value=\"\"/>\n" +
              "      <WARDBLOCK value=\"1003病区护士站\"/>\n" +
              "      <ROW_ID value=\"2\"/>\n" +
              "      <ADDRESS value=\"山东省聊城市莘县东鲁街道刘马庄村305号\"/>\n" +
              "      <IOFLAG value=\"1\"/>\n" +
              "      <TEL value=\"\"/>\n" +
              "      <FAMILYTEL value=\"13963597058\"/>\n" +
              "      <CARDTYPE value=\"0\"/>\n" +
              "      <WEIGHT value=\"\"/>\n" +
              "      <JOB value=\"其它\"/>\n" +
              "      <PATIENTID value=\"247601\"/>\n" +
              "      <FAMILYNAME value=\"房保省\"/>\n" +
              "      <CARDNO value=\"372523196205080564\"/>\n" +
              "      <WARDBEDNO value=\"0\"/>\n" +
              "    </row>\n" +
              "  </list>\n" +
              "</response>";


        String requestMessage = getRequestMessage("1","2", "3");
        Map map = readStringXmlOut(xmlString);
        System.out.println(map.size());

    }

    public static Map readStringXmlOut(String xml) {
        Map map = new HashMap();
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML
            Element rootElt = doc.getRootElement();// 获取根节点
            Element retEle = rootElt.element("3243434");
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
                            Element patient= (Element) row.next();
                            String PATIENTPINYIN = getAttributeValue(patient,"PATIENTPINYIN");;
                            String PATIENTNAME = getAttributeValue(patient,"PATIENTNAME");;
                            String SEX = getAttributeValue(patient,"SEX");
                            String ZIPCODE = getAttributeValue(patient,"ZIPCODE");
                            String HEIGHT = getAttributeValue(patient,"HEIGHT");
                            String WARDBLOCK = getAttributeValue(patient,"WARDBLOCK");
                            String ROW_ID = getAttributeValue(patient,"ROW_ID");
                            String ADDRESS = getAttributeValue(patient,"ADDRESS");
                            String IOFLAG = getAttributeValue(patient,"IOFLAG");
                            String TEL = getAttributeValue(patient,"TEL");
                            String FAMILYTEL =getAttributeValue(patient,"FAMILYTEL");
                            String CARDTYPE =getAttributeValue(patient,"CARDTYPE");
                            String WEIGHT = getAttributeValue(patient,"WEIGHT");
                            String JOB = getAttributeValue(patient,"JOB");
                            String PATIENTID = getAttributeValue(patient,"PATIENTID");
                            String FAMILYNAME = getAttributeValue(patient,"FAMILYNAME");
                            String CARDNO = getAttributeValue(patient,"CARDNO");
                            String WARDBEDNO = getAttributeValue(patient,"WARDBEDNO");
                            map.put("s",PATIENTNAME);
                            return map;
                        }
                    }
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    private static String getAttributeValue(Element currentEle, String valueName){
        Element retEle = currentEle.element(valueName);
        return retEle.attributeValue("value");
    }
    private static String getRequestMessage(String requestId,String timestampStr,String sqlStr){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<request>");
        stringBuilder.append("<requestId value="+requestId+" />");
        stringBuilder.append("<createTime value="+timestampStr+"/>");
        stringBuilder.append("<condition value="+sqlStr+"/>");
        stringBuilder.append("<pageNum value="+PAGE_NUM+"/>");
        stringBuilder.append("<pageSize value="+PAGE_SIZE+"/>");
        stringBuilder.append("</request>");
        return stringBuilder.toString();
    }
}
