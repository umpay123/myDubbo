package com.tan.数据结构算法.二叉树递归套路;

import com.tan.数据结构算法.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/18/11:01
 * @Description: 满足节点数= 2的层高次方
 */
public class 判断是否满二叉树 {
     public static class Info{
         public int height;
         public int nodes;
         public Info(int height,int nodes){
             this.height = height;
             this.nodes = nodes;
         }
     }
     public static boolean isFull(TreeNode head){
          if(head == null){ return true;}
          Info info = process(head);
          return ((1<<info.height)-1)==info.nodes;
     }
     public static Info process(TreeNode node){
         if(node == null){ return new Info(0,0);}
         Info l = process(node.left);
         Info r = process(node.right);
         int higth = Math.max(l.height,r.height)+1;
         int nodes = l.nodes+r.nodes+1;
         return new Info(higth,nodes);
     }

}
