package com.methodTest.JiuerSi;

import com.entity.wude;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @author wudeyuan
 * @date 2020/8/4 14:03
 * @description 反射
 */
public class reflectionAboutInvoke {

    private final static String NUM_TEST = "I";

    public static void main(String[] args){
        // TODO Auto-generated method stub
        String str = "abc";
        Class cls1 = str.getClass();
        Class cls2 = String.class;
        Class cls3 = null;//必须要加上null
        try {
            cls3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(int.class.isPrimitive());//判定指定的 Class 对象是否表示一个基本类型。
        System.out.println(int.class == Integer.class);
        System.out.println(int.class == Integer.TYPE);

    }


//    public static void main(String[] args) throws ClassNotFoundException {
//        test1();
//
//    }


    public static void test1() throws ClassNotFoundException {

        wude wude = new wude();
        Class<? extends com.entity.wude> aClass = wude.getClass();
        // 获取属性
        Field[] Fields = aClass.getDeclaredFields();
        for (Field field:Fields){
            Type genericType = field.getGenericType();
            System.out.println(genericType);
            System.out.println("\n");
            System.out.println(field.getType());
        }
        


    }


}
