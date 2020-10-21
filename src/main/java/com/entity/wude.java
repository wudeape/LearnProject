package com.entity;

/**
 * @author wudeyuan
 * @date 2020/9/11 10:00
 * @description
 */
public class wude {
    private String name;
    private String age;

    @Override
    public String toString() {
        return "wude{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String invokeTest(){
        return "hello wude";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public void test1(){
        System.out.println("success");
    }

    public void test2(String namee){
        System.out.println(namee);
    }

    // 构造方法
    public wude(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public wude() {
    }
}
