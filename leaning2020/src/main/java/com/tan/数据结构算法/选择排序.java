package com.tan.数据结构算法;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/11/18/18:22
 * @Description:
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] arr ={5,3,1,4,6,2,8,9,-1}; //4,6,2,8,9
        int[] arr1 = 选择排序.sort(arr);
        for (int i:arr1){
            System.out.printf(i+" ");
        }
       // System.out.println(ArryList);
    }
    public static int[] sort(int[] arr){
        if (arr==null || arr.length<2){
            return arr;
        }
        for (int i=0;i<arr.length;i++){
            int index = i;
            for (int j=i+1;j<arr.length;j++){
               if (arr[index]>arr[j]){
                   index = j;
               }
            }
            swap(arr,i,index);
        }
        return arr;
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
