package com.entity;

public class Person {

    private String name;

    private String age;

    private Integer num;

    private  Integer Pageamount;

    private String sameflag;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPageamount() {
        return Pageamount;
    }

    public void setPageamount(Integer pageamount) {
        Pageamount = pageamount;
    }


    public String getSameflag() {
        return sameflag;
    }

    public void setSameflag(String sameflag) {
        this.sameflag = sameflag;
    }

    public Person(String name, String age, Integer num) {
        this.name = name;
        this.age = age;
        this.num = num;
    }

    public Person() {
    }
}
