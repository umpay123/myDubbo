package com.tan.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/10/10/14:25
 * @Description:
 */
public class 交替执行LockSupport {
    static Thread t1=null, t2=null;
    public static void main(String[] args) {
        char[] a1 = "1234567".toCharArray();
        char[] a2 = "abcdefg".toCharArray();

        t1 = new Thread(() ->{
           for (char c:a1){
               System.out.print(c);
               LockSupport.unpark(t2); //叫醒T2
               LockSupport.park(); //阻塞t1
           }
        },"t1");

       t2 = new Thread(()->{
          for (char c:a2){
              LockSupport.park(); //阻塞
              System.out.print(c); //打印
              LockSupport.unpark(t1); //阻塞T1
          }
      },"t2");
       t1.start();
       t2.start();
    }
}
