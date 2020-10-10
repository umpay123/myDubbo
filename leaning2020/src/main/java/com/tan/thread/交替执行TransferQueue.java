package com.tan.thread;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/10/10/14:25
 * @Description:
 */
public class 交替执行TransferQueue {
    static Thread t1=null, t2=null;
    public static void main(String[] args) throws Exception {
        char[] a1 = "1234567".toCharArray();
        char[] a2 = "abcdefg".toCharArray();
        TransferQueue transferQueue = new LinkedTransferQueue();
        t1 = new Thread(() ->{
           for (char c:a1){
               try {
                   System.out.print(transferQueue.take());
                   transferQueue.transfer(c);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        },"t1");

       t2 = new Thread(()->{
          for (char c:a2){
              try {
                  transferQueue.transfer(c);
                  System.out.print(transferQueue.take());
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      },"t2");
       t1.start();
       t2.start();
    }
}
