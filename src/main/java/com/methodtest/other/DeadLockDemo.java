package com.methodtest.other;

/**
 * @author wudeyuan
 * @date 2020/10/22 11:05
 * @description
 */
public class DeadLockDemo {

    private static String resource_a = "A";
    private static String resource_b = "B";

    public static void main(String[] args){
        deadLock();
    }

    public static void deadLock(){
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource_a){
                    System.out.println(" get resource a");
                    try {
                        Thread.sleep(3000);
                        synchronized (resource_b){
                            System.out.println("get resourece b");
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource_b){
                    System.out.println("get resource b");
                    synchronized (resource_a){
                        System.out.println("get resorece a");
                    }
                }
            }
        });
        threadA.start();
        threadB.start();

    }
}
