package com.tan.数据结构算法;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/03/11:11
 * @Description:
 */
public class 堆排序 {
    public static void main(String[] args) {
        int[] arr ={2,4,5,1,9,6,3,2};
        堆排序.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapinset(arr, i);
        }
        int size = arr.length - 1;
        swap(arr, 0, arr.length - 1);
        while (size > 0) {
            heapify(arr, 0,size);
            swap(arr,0,--size);
        }
    }

    public static void heapinset(int[] arr, int i) {
        while (arr[i] > arr[((i - 1) / 2)]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int i,int heapSize) {
        int left = 2 * i + 1;
        while (left < heapSize) {
            int large = left+1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            large = arr[large] > arr[i] ? large : i;
            if (large == i) {
                break;
            }
            swap(arr, large, i);
            i = large;
            left = 2 * i + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
