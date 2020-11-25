package com.tan.数据结构算法;

import org.apache.dubbo.common.utils.ArrayUtils;
import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/11/25/9:40
 * @Description:
 */
public class 归并排序 {
    public static void main(String[] args) {
        int[] a ={2,4,6,3,5,4};
        归并排序.prosses(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void prosses(int[] arr,int l,int r){
        if (l == r){
            return;
        }
        int mid = l+((r-l)/2);
        prosses(arr,l,mid);
        prosses(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    public static  void merge(int[] arr,int l,int mid,int r){
      int[] help = new int[r-l+1];
      int p1 = l;
      int p2 = mid+1;
      int i = 0;
      while (p1<=mid && p2<=r){
         if (arr[p1]<=arr[p2]){
           help[i] = arr[p1];
           p1++;
         }else {
             help[i] = arr[p2];
             p2++;
         }
         i++;
         // help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
      }
      while (p1<=mid){
          help[i]=arr[p1];
          p1++;
          i++;
      }
      while (p2<=r){
          help[i]=arr[p2];
          p2++;
          i++;
      }
        for (int j = 0; j < help.length; j++) {
            arr[l+ j] = help[j];
        }
    }
}

