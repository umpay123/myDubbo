package com.tan.数据结构算法;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/03/9:49
 * @Description:
 */
public class 堆 {
    public static void main(String[] args) {
        int value = 1000;
        int limit = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            myMaxHeap my = new myMaxHeap(curLimit);
            RightMaxHeap test = new RightMaxHeap(curLimit);
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("Oops!");
                }
                if (my.isFull() != test.isFull()) {
                    System.out.println("Oops!");
                }
                if (my.isEmpty()) {
                    int curValue = (int) (Math.random() * value);
                    my.push(curValue);
                    test.push(curValue);
                } else if (my.isFull()) {
                    if (my.pop() != test.pop()) {
                        System.out.println("Oops!");
                    }
                } else {
                    if (Math.random() < 0.5) {
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.push(curValue);
                    } else {
                        if (my.pop() != test.pop()) {
                            System.out.println("Oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");

    }
    public static class myMaxHeap{
        private int[] heap;
        private int heapSize;
        private int limit;
    public myMaxHeap(int limit){
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }
    public boolean isEmpty(){
        return heapSize == 0;
    }
    public boolean isFull(){
        return heapSize == limit;
    }
    public void push(int value){
     if (heapSize ==limit){
         throw  new RuntimeException("heap is full");
     }
     heap[heapSize] = value;
     heapInsert(heap,heapSize);
     heapSize++;
    }
    private void heapInsert(int[] arr,int index){
        while (arr[index]>arr[(index-1)/2]){
          swap(arr,index,(index-1)/2);
          index = (index-1)/2;
        }
    }
   public int pop(){
        int ans = heap[0];
        swap(heap,0,--heapSize);
        heapify(heap,0,heapSize);
        return ans;
   }
    public void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private void heapify(int[] arr,int index,int heapSize){
       int left = 2*index+1;
       while (left<heapSize){
           int largest = left+1<heapSize&& arr[left+1] > arr[left] ? left+1:left;
           largest = arr[largest] > arr[index]? largest:index;
           if (largest == index){
               break;
           }
           swap(arr,index,largest);
           index = largest;
           left = 2*largest+1;
       }
    }
    }
    public static class RightMaxHeap {
        private int[] arr;
        private final int limit;
        private int size;

        public RightMaxHeap(int limit) {
            arr = new int[limit];
            this.limit = limit;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("heap is full");
            }
            arr[size++] = value;
        }

        public int pop() {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            int ans = arr[maxIndex];
            arr[maxIndex] = arr[--size];
            return ans;
        }

    }

}
