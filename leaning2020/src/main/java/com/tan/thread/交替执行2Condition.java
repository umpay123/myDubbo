package com.tan.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/10/10/14:51
 * @Description:
 */
public class 交替执行2Condition {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition(); //队列
        Condition condition2 = lock.newCondition();
        char[] c1 = "1234567".toCharArray();
        char[] c2 = "abcdefg".toCharArray();
        new Thread(()->{
            lock.lock();
            try {
               for (char c:c1){
                   System.out.print(c);
                   condition2.signal();//唤醒condition2
                   condition1.await();// 等待condition1
               }
               condition2.signal();
           }catch (Exception e){
               e.printStackTrace();
           }finally {
                lock.unlock();
            }
        },"t1").start();
        new Thread(()->{
            lock.lock();
            try {
                for (char c:c2){
                    System.out.print(c);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t2").start();

    }
}
