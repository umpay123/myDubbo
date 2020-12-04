package com.tan.数据结构算法;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/11/26/17:26
 * @Description:
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] a={3,4,9,2,6,8,9,5,5};
//        快速排序.partition2(a,8);
      //  快速排序.hlgq(a,0,a.length-1); //[3, 4, 2, 5, 5, 9, 6, 9, 8]
         快速排序.quickSort3(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void quickSort(int[] arr,int L,int R){
        if (L >= R){return;}
        int mid = partition(arr,L,R);
        quickSort(arr,L,mid-1);
        quickSort(arr,mid+1,R);
    }
    public static void quickSort2(int[] arr,int L,int R){
        if (L >= R){return;}
        int[] mid = hlgq(arr,L,R);
        quickSort2(arr,L,mid[0]-1);
        quickSort2(arr,mid[1]+1,R);
    }
    public static void quickSort3(int[] arr,int L,int R){
        if (L >= R){return;}
        swap(arr,(int)(L+Math.random()*(R-L+1)),R);
        int[] mid = hlgq(arr,L,R);
        quickSort2(arr,L,mid[0]-1);
        quickSort2(arr,mid[1]+1,R);
    }

    public static int partition(int[] arr,int L,int R){
        if (L > R){return -1;}
        if (L== R){return L;}
        int tager = arr[R];
        int left = -1;
        int cur = 0;
        while (cur < R){
            if (arr[cur] <= tager){
                swap(arr,cur,++left);
            }
            cur++;
        }
        swap(arr,++left,R);
        return left;
    }
    public static int partition1(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }
    public static void partition(int[] arr,int target){
        if (null == arr||arr.length<2){ return;}
        int left = -1;
        int right = arr.length-1;
        int cur =0;
        while (cur<=right){
           if (arr[cur]<=target){
               swap(arr,cur,left+1);
               left++;
               cur++;
           }else if (arr[cur]>target){
//               swap(arr,cur,right);
//               right--;
               cur++;
           }
        }
        //swap(arr,left+1,right);
    }
    public static void partition2(int[] arr,int target)  {
        if (null == arr||arr.length < 2){
            return;
        }
        int right = arr.length-1;
        int cur = 0;
        while (cur < right){
            //10,7,1,7,3,9,5,7,10,10
            if(target > arr[cur]) {
                cur++;
            } else {
                while(target < arr[right]){
                    right --;
                }
                swap(arr,cur,right);
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] hlgq(int[] arr,int L,int R){
        if (L>R){return new int[] {-1,-1};}
        if (L == R){return new int[] {L,R};}
        int left = L-1; //左边区
        int right = R; //右边区
        int cur = L;
        while (cur<right){
            if (arr[cur]<arr[R]){
                left++;
                swap(arr,cur,left);
                cur++;
            }else
            if (arr[cur]== arr[R]){
                cur++;
            }else
            if (arr[cur]>arr[R]){
                right--;
                swap(arr,cur,right);
            }
        }
        swap(arr, right, R);
        return new int[]{left+1,right};
    }

    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[] { -1, -1 };
        }
        if (L == R) {
            return new int[] { L, R };
        }
        int less = L - 1; // < 区 右边界
        int more = R;     // > 区 左边界
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else { // >
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[] { less + 1, more };
    }
}
