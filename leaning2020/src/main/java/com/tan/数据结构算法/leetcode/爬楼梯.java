package com.tan.数据结构算法.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/14/14:45
 * @Description:
 */
public class 爬楼梯 {
    public static void main(String[] args) {
        System.out.println( climbStairs1(45));
    }
    public static int climbStairs(int n) {
        if (n ==0 ){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return climbStairs(n-2)+climbStairs(n-1);
    }
    public static int climbStairs1(int n) {
        int pre =0,q=0,res =1;
        for (int i=1;i<=n;i++){
            pre = q;
            q = res;
            res = pre+q;
        }
        return  res;
    }
}
