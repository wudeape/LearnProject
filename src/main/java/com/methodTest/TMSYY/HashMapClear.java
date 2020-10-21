package com.methodTest.TMSYY;

import java.util.HashMap;

/**
 * @author wudeyuan
 * @date 2020/8/17 19:00
 * @description
 */
public class HashMapClear {
    public static void main(String[] args){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("1","1");
        hashMap.put("2","3");
        System.out.println(hashMap.size()+"\n");
        hashMap.clear();
        System.out.println(hashMap.size());
    }
}
