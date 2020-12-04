package com.tan.数据结构算法;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/04/13:52
 * @Description:
 */
public class 桶排序计数器 {
    public static void main(String[] args) {
        int[] arr = {0,0,2,1,1,4,8,6};
        桶排序计数器.countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void countSort(int[] arr){
        if (null == arr||arr.length<2){
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        int[] help = new int[max+1];
        for (int i=0;i<arr.length;i++){
            help[arr[i]] = help[arr[i]]+1;
        }
        int j =0;
        for (int i=0;i<help.length;i++){
            int tmp = help[i];
            while (tmp>0){
              arr[j++] = i;
              tmp--;
            }
        }
    }

}
