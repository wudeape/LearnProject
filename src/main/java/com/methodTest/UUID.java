package com.methodTest;

import com.tools.Tools;

import java.io.UnsupportedEncodingException;

/**
 * @author wudeyuan
 * @date 2020/6/23 14:02
 * @description
 */
public class UUID {
  public static void main(String[] args) throws UnsupportedEncodingException {
      String temp = Tools.getFifteenUUID();
      String temps = "50%GS静推";
      final int length = temp.getBytes("UTF-8").length;
      final  int length1 = temps.getBytes("UTF-8").length;
      System.out.print(length+"\n"+length1);

  }

}
