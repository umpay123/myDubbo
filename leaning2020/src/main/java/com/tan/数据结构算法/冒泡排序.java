package com.tan.数据结构算法;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/11/18/17:53
 * @Description:
 */
public class 冒泡排序 {
    public static void main(String[] args) {
         int[] arr ={5,3,1,4,6,2,8,9};
        冒泡排序.sort(arr);
    }
    public static  int[] sort(int[] arr){
        if (arr==null || arr.length<2){
            return arr;
        }
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-1;j++){
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        for (int i:arr){
            System.out.printf(i+" ");
        }
        return arr;
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
