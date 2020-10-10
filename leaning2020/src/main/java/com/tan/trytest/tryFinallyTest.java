package com.tan.trytest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/10/09/14:35
 * @Description:
 */
public class tryFinallyTest {
    public static void main(String[] args) throws Exception{
        try{
            System.out.println("开始抛出异常");

//            throw new Exception("ssssss");
            return;
        }finally {
            System.out.println("异常被执行");
        }
    }
}
