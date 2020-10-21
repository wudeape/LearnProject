package com.methodtest.other;

import java.io.UnsupportedEncodingException;

/**
 *  \* User: wudeyuan
 *  \* Date: 2020/6/1 Time: 14:12
 *  \* Description: 
 *  \
 */

public class ObjectTest {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String tempString = "\tmIU/   ml";
        String tempString1 = "123456789";
        String tempString2 = "sssssssss";
//        String finalString = " mIU/ML";
//        if(com.methodtest.tools.Tools.equals(tempString.toLowerCase().replace(" ",""),finalString.toLowerCase().replace(" ",""))){
//            System.out.printf("first one  success");
//        }
//        Object tempObject = new Object();
//        byte[] bytes = tempString1.getBytes();
//        for (int i = 0; i <tempString1.length() ; i++) {
//            System.out.print(bytes[i]+"\n");
//        }
//        if (tempString instanceof String){
//            System.out.printf("success");
//        }

       int a = tempString1.getBytes("utf-8").length;
        int length = tempString1.length();
        int b = tempString2.getBytes("utf-8").length;
        System.out.printf(a+"\n"+b+"\n");
        System.out.print(length);





    }


}
