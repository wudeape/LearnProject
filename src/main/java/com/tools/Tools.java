package com.tools;

import java.util.List;
import java.util.UUID;

public class Tools {

    public static boolean equals(String str1, String str2) {
        if (str1==str2) {
            return true;
        }
        // null 和 空串在系统中认为相等
        str1 = (str1 == null?"":str1.trim());
        str2 = (str2 == null?"":str2.trim());
        return str1.equals(str2);
    }

    public static boolean listisblank(List list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    public static boolean isblank(Object param) {
        if (null == param || "".equals(param.toString().trim())) {
            return true;
        }
        return false;
    }
    public static boolean isNotBlank(Object param) {
        boolean flag = !isblank(param);
        return flag;
    }

    public static String trim(String str) {
        if (null == str) {
            return "";
        }
        return str.trim();
    }

    public static String getFifteenUUID() {
        String s = getNoSpUUID().toString();
        // 去掉“-”符号
        return s.substring(0, 15);
    }

    public static String getNoSpUUID() {
        UUID uuid = UUID.randomUUID();
        String uid = uuid.toString();
        uid = uid.replace("-", "");
        return uid;
    }

}
