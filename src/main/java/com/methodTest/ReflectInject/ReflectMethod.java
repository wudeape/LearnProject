package com.methodTest.ReflectInject;

import com.methodTest.UUID;

/**
 * @author wudeyuan
 * @date 2020/8/19 16:49
 * @description
 *
 * java中创建对象的几种方式
 * 1 使用new创建对象
 * 2 使用Clone的方法：无论何时我们调用一个对象的clone方法，JVM就会创建一个新的对象，将前面的对象的内容全部拷贝进去
 * 3 反序列化：当我们序列化和反序列化一个对象，JVM会给我们创建一个单独的对象
 * 4 反射就是把Java类中的各个部分，映射成一个个的Java对象 利用反射可以将成员变量，方法，构造方法，等信息 映射成对象
 */
public class ReflectMethod {

    /**
     * 三种获取字节码的方式
     *  Class.forName("com.cj.test.Person");
     * 对象.getClass();
     * 类名.class;
     * @throws Exception
     */

    public void getObjectClass()throws Exception{
        //TODO class.forNam() 两种不同的传参，以下这种方式默认会初始化
        Class<?> aClass = Class.forName("com.methodTest.ReflectInject.Person");
        // getMethods 返回公有方法，getDeclaredMethods 返回所有方法
        aClass.getDeclaredMethods();
        // 构造方法
        aClass.getDeclaredConstructors();
        // 字段
        aClass.getDeclaredFields();
        Person person = new Person();
        Class<? extends Person> aClass1 = person.getClass();
        Class<Person> personClass = Person.class;
    }


    public void testMethods(){
        UUID uuid = new UUID();
        String s = uuid.toString();
        System.out.println(s);
    }




}
