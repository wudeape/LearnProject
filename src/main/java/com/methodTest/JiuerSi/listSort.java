package com.methodTest.JiuerSi;

import com.entity.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wudeyuan
 * @date 2020/6/16 14:18
 * @description
 */
public class listSort {

    public static void main(String[] args){
        List<Person> tempList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("test1","12",22));
        personList.add(new Person("test1","13",22));
        personList.add(new Person("test1","12",23));
        personList.add(new Person("test1","12",21));
        personList.add(new Person("test1","11",23));
        personList.add(new Person("test1","23",21));
        personList.add(new Person("test2","12",21));
        personList.add(new Person("test2","12",21));
        personList.add(new Person("test2","12",21));
        tempList.addAll(personList);
        System.out.print(tempList + "\n");
        List<Person> personList1 = new ArrayList<>();
        personList1.add(new Person("test3","12",23));
        personList1.add(new Person("test3","11",24));
        personList1.add(new Person("test3","11",124));
        personList1.add(new Person("test4","151",25));
        personList1.add(new Person("test5","131",26));
        tempList.addAll(personList1);

        Collections.sort(tempList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int i  = o1.getName().compareTo(o2.getName());
                int j=-1;
                if(i==0){
                    j= o1.getAge().compareTo(o2.getAge());
                }
                if(i==0){
                    if(j==0){
                        return o1.getNum().compareTo(o2.getNum());
                    }
                }
                return 0;
            }
        });
        Collections.sort(tempList,(Person o1, Person o2)->{
            int i  = o1.getName().compareTo(o2.getName());
            return i;
        });
        for (int i = 0; i <tempList.size() ; i++) {
            System.out.printf(tempList.get(i).getName()+" "+ tempList.get(i).getAge()+" "+tempList.get(i).getNum()+"\n");
        }




    }


}
