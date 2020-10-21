package com.entity;

/**
 * @author wudeyuan
 * @date 2020/9/30 14:08
 * @description
 */
public class WudeParent {

    private String parentname;

    private String parentage;

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public String getParentage() {
        return parentage;
    }

    public void setParentage(String parentage) {
        this.parentage = parentage;
    }

    public void testparent1(){
        System.out.println("Parent success");
    }

    public void testparent2(String name){
        System.out.println("parent"+name);
    }
}
