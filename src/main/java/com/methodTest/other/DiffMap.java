package com.methodTest.other;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wudeyuan
 * @date 2020/9/14 14:04
 * @description
 */
public class DiffMap {
    int[] temp = new int[3];
    HashMap hashMap = new HashMap();
    Map<String,Class> map = new ConcurrentHashMap<>();

    public static final Map<String, Class> CLASS_MAP;
    static {
        Map<String, Class> classMap=new ConcurrentHashMap<>(16);
        classMap.put("VARCHAR", String.class);
        // 返回指定映射的不可修改视图
        CLASS_MAP= Collections.unmodifiableMap(classMap);
    }

}
