package com.tan.数据结构算法;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/11/23/17:25
 * @Description:
 */
public class 数组实现队列 {
   private int[] arr;
   private int pushi;
   private int polli;
   private int size;
   private int limit;
   public 数组实现队列(int limit){
       arr = new int[limit];
       this.limit = limit;
       pushi =0 ;
       polli =0;
       size = 0;
   }
   public void push(int value){
       if (size>limit){ throw  new RuntimeException("超过了最大容量");       }
       arr[pushi] = value;
       size++;
       pushi = nextIndex(pushi);
   }
   public int pop(){
       if (arr.length<1){ throw new RuntimeException("队列为空的");}
       size--;
       int ans = arr[polli];
       polli = nextIndex(polli);
       return ans;
   }
   private int nextIndex(int i){
       return i<limit-1 ? i+1:0;
   }
}
