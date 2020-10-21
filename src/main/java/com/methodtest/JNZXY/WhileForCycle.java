package com.methodtest.JNZXY;

import com.methodtest.tools.Tools;

import java.util.Arrays;
import java.util.List;

/**
 * @author wudeyuan
 * @date 2020/6/24 14:26
 * @description
 */
public class WhileForCycle {
    public static void main(String[] args) {

        Integer NumCoung = 0;
        String messageServerMQ = getLisDataByWebservice(NumCoung);
        if (Tools.isNotBlank(messageServerMQ)) {
            String nextPage = "";
            nextPage = messageServerMQ;
            while (!Tools.equals("0", nextPage)) {
                try {
                    String lisDataByWebservice = getLisDataByWebservice(NumCoung++);
                    nextPage =lisDataByWebservice;
                    System.out.println(nextPage);

                } catch (Exception e) {

                }
            }
        }

    }
    private static String getLisDataByWebservice(Integer curNum){
        List<String> stringList = Arrays.asList("1", "2", "3","0");
        return stringList.get(curNum);

    }





}
