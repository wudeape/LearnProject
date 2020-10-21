package com.methodtest.ReflectInject;



/**
 * @author wudeyuan
 * @date 2020/8/19 16:33
 * @description
 */
public class Person {

    private String username;
    private String password;

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
        System.out.println("I am fine");
    }

    public Person(String username) {
        this.username = username;
        System.out.println(username);
    }

    public Person(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
