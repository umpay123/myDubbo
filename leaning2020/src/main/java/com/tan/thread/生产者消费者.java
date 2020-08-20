package com.tan.thread;

import java.util.concurrent.locks.Lock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/08/18/15:04
 * @Description:
 */
public class 生产者消费者 {
    private int count = 0 ;
    private static final int FULL = 10;
    private final static String LOCK = "lock";
    public static void main(String[] args) {
        生产者消费者 sxz = new 生产者消费者();
        for (int i=0;i<5;i++) {
            Thread thread = new Thread(sxz.new product());
            thread.start();

            Thread thread1 = new Thread(sxz.new consumer());
            thread1.start();
        }
    }


class product implements Runnable{
    @Override
    public void run() {
     while (true){
         try {
             Thread.sleep(300);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         synchronized (LOCK){
             while (count==FULL){
                 System.out.println("停止生产");
                 try {
                     LOCK.wait();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
             count++;
             System.out.println("生产者"+Thread.currentThread().getName()+"总共有"+count+"资源");
             LOCK.notifyAll();
         }

     }
    }
}

class consumer implements Runnable{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LOCK){
                while (count<=0){
                    System.out.println("消费者停止消费");
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count--;
                System.out.println("消费者消费"+Thread.currentThread().getName()+"共有"+count+"资源");
                LOCK.notifyAll();
            }
        }
    }
}
}