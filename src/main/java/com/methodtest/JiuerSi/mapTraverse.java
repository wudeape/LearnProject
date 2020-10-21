package com.methodtest.JiuerSi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author wudeyuan
 * @date 2020/9/8 11:28
 * @description
 */
public class mapTraverse {
    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("2","hello");
        hashMap.put("33","sdfsdf");
        hashMap.put("34","baidu.com");


        System.out.println("~~~~ 遍历key ~~~~~~"+"\n");
        for (String entryKey:hashMap.keySet()){
            System.out.println("====this key"+entryKey+"\n");
        }
        System.out.println("~~~~ 遍历value ~~~~~~"+"\n");
        for (String value:hashMap.values()){
            System.out.println("=======this value"+value+"\n");
        }
        System.out.println("~~~~ 迭代器遍历 ~~~~~~"+"\n");
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println("the key is"+next.getKey()+"and the value is"+next.getValue()+"\n");
        }
        System.out.println("~~~~ entry 遍历 ~~~~~~"+"\n");
        for(Map.Entry<String,String> map:hashMap.entrySet()){
            System.out.println("the key :"+map.getKey()+"the value:"+map.getValue()+"\n");
        }
        Stream<Map.Entry<String, String>> stream = hashMap.entrySet().stream();

    }


}
