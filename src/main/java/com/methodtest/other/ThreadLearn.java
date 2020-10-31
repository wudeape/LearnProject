package com.methodtest.other;

import java.util.concurrent.*;

/**
 * @author wudeyuan
 * @date 2020/10/22 11:28
 * @description
 */
public class ThreadLearn {
    public static void main(String[] args){
        useageOfThread();
        System.out.println("edn");
    }

    /**
     * 线程的创建
     * 1 继承Thread,重写run方法
     * 2 实现runable接口
     * 3 实现callable接口
     *
     */
    public static void createThread(){
        // 1 继承Thread,重写run方法
        Thread thread = new Thread(){
            @Override
            public void run(){
                System.out.println("继承Thread");
                super.run();
            }
        };
        thread.run();

        // 2 实现runable接口
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("实现runable接口");
            }
        });
        thread1.start();

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });
        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     *  线程中的常用操作
     * 1 中断操作
     * 中断好比其他线程对该线程打了一个招呼。其他线程可以调用该线程的interrupt()方法对其进行中断操作，
     * 同时该线程可以调用 isInterrupted（）来感知其他线程对其自身的中断操作，从而做出响应
     *
     * 2
     */
    public static void useageOfThread(){
        // seelpThread 睡眠1000ms
       final Thread sleepThread = new Thread(){
           @Override
           public void run(){
               try {
                   Thread.sleep(1000);
                   System.out.println("------1000s");
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
               super.run();
           }
       };
        sleepThread.start();
       // busyThread 一直执行死循环
        Thread busyThread = new Thread(){
            @Override
            public void run(){
                while (true);
            }
        };

    }

}
