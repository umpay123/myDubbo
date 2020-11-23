package com.tan.数据结构算法;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/11/18/18:22
 * @Description:
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] arr ={5,3,1,4,6,2,8,9}; //4,6,2,8,9
        int[] arr1 = 插入排序.sort(arr);
        for (int i:arr1){
            System.out.printf(i+" ");
        }
    }
    public static int[] sort(int[] arr){
        if (arr==null || arr.length<2){
            return arr;
        }
        for (int i=0;i<arr.length;i++){
            for (int j=i-1;j>=0;j--){
               if (arr[j]>arr[j+1]){
                   swap(arr,j,j+1);
               }
            }
        }
        return arr;
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
