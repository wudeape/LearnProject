package com.methodtest.other;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author wudeyuan
 * @date 2020/10/22 11:28
 * @description
 */
public class ThreadLearn {
    public static void main(String[] args){
        // 线程创建
        //createThread();
        // 线程中断操作
        //interruptOfThread();
        // 守护线程
        daemonOfThread();
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
     */
    public static void interruptOfThread(){
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
//        sleepThread.start();
        busyThread.start();
        System.out.println(new Date()+"sleepThread isInterrupted:"+" "+sleepThread.isInterrupted());
        System.out.println(new Date()+"busyThread isInterrupted"+" "+busyThread.isInterrupted());
        //对线程进行终端操作
        sleepThread.interrupt();  // java.lang.InterruptedException: sleep interrupted
        busyThread.interrupt();
        while (sleepThread.isInterrupted());
        System.out.println(new Date()+"sleepThread isInterrupted:"+" "+sleepThread.isInterrupted());
        System.out.println(new Date()+"busyThread isInterrupted"+" "+busyThread.isInterrupted());

        // 打印结果java.lang.InterruptedException: sleep interrupted
        //Mon Nov 02 14:05:33 CST 2020sleepThread isInterrupted: false
        //	at java.lang.Thread.sleep(Native Method)
        //	at com.methodtest.other.ThreadLearn$4.run(ThreadLearn.java:75)
        //Mon Nov 02 14:05:33 CST 2020busyThread isInterrupted false
        //Mon Nov 02 14:05:33 CST 2020sleepThread isInterrupted: false
        //Mon Nov 02 14:05:33 CST 2020busyThread isInterrupted true

        //while (sleepThread.isInterrupted()) 表示在Main中会持续监测sleepThread，一旦sleepThread的中断标志位清零
        //即sleepThread.isInterrupted()返回为false时才会继续Main线程才会继续往下执行。

    }

    /**
     * join操作，线程间协作方式
     * 一个线程实例A执行了threadB.join(),其含义是：当前线程A会等待threadB线程终止后threadA才会继续执行
     *
     */
    public static void joinOfThread(){
        Thread previousThread = Thread.currentThread();
        for (int i = 0; i <= 10 ; i++) {
            Thread curThread = new JoinThread(previousThread);
            curThread.start();
            previousThread = curThread;
        }

    }

    /**
     * 1.sleep()方法是Thread的静态方法，而wait是Object实例方法
     * 2.wait()方法必须要在同步方法或者同步块中调用，也就是必须已经获得对象锁。
     * 而sleep()方法没有这个限制可以在任何地方种使用。另外，wait()方法会释放占有的对象锁，
     * 使得该线程进入等待池中，等待下一次获取资源。而sleep()方法只是会让出CPU并不会释放掉对象锁；
     * 3.sleep()方法在休眠时间达到后如果再次获得CPU时间片就会继续执行，
     * 而wait()方法必须等待Object.notift/Object.notifyAll通知后，才会离开等待池，
     * 并且再次获得CPU时间片才会继续执行。
     */
    public static void sleepOfThread(){

    }

    /**
     * 一旦执行，它会是当前线程让出CPU，但是，需要注意的是，让出的CPU并不是代表当前线程不再运行了，
     * 如果在下一次竞争中，又获得了CPU时间片当前线程依然会继续运行
     *
     * sleep()和yield()方法，同样都是当前线程会交出处理器资源，而它们不同的是，
     * sleep()交出来的时间片其他线程都可以去竞争，也就是说都有机会获得当前线程让出的时间片。
     * 而yield()方法只允许与当前线程具有相同优先级的线程能够获得释放出来的CPU时间片
     */
    public static void yeildOfThread(){

    }

    /**
     * 守护线程的使用
     * 用户线程完全结束后就意味着整个系统的业务任务全部结束了，因此系统就没有对象需要守护的了，守护线程自然而然就会退
     *
     * i am alive finally block i am alive
     * 紧接着main 线程结束后，daemonThread退出，这个时候只打印了"i am alive"并没有打印finnal块中的
     * 守护线程在退出的时候并不会执行finnaly块中的代码，所以将释放资源等操作不要放在finnaly块中执行，这种操作是不安全的
     */
    public static void daemonOfThread(){
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        System.out.println("i am alive");
                        Thread.sleep(500);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    } finally {
                        System.out.println("finally block");
                    }
                }
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
        // 确保main线程结束前能给daemonThread分到时间片
        try {
            Thread.sleep(800);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }



    /**
     * thread连接类
     */
    static class JoinThread extends Thread{

        private Thread thread;

        public JoinThread(Thread thread){
            this.thread = thread;
        }

        @Override
        public void run(){
            try {
                thread.join();
                System.out.println(thread.getName() + "terminaed.");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
