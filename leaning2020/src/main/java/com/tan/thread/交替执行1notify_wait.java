package com.tan.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/10/10/14:51
 * @Description:
 */
public class 交替执行1notify_wait {
    private static CountDownLatch latch = new CountDownLatch(1);//门栓
    public static void main(String[] args) {
        final  Object o = new Object();
        char[] c1 = "1234567".toCharArray();
        char[] c2 = "abcdefg".toCharArray();

        new Thread(()->{
            try {
                latch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (o) {
                for (char c : c1) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                o.notify();// 必须，否则无法停止程序
            }
        }).start();

        new  Thread(()->{
          synchronized (o) {
              for (char c : c2) {
                  try {
                      latch.await();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.print(c);
                  try {
                      o.notify();
                      o.wait();
                  }catch (Exception e){
                      e.printStackTrace();
                  }
              }
              o.notify();
          }
        }).start();

    }
}
