package com.tan.数据结构算法.二叉树递归套路;

import com.tan.数据结构算法.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/25/14:35
 * @Description:
 */
public class 最大二叉搜索子树大小 {
    public static class Info{
        public int max;
        public int min;
        public boolean isBST;
        public int maxSubBSTSize;
        public Info(int maxSubBSTSize, boolean isBST,int max,int min){
            this.max = max;
            this.min = min;
            this.isBST = isBST;
            this.maxSubBSTSize = maxSubBSTSize;
        }
    }
    public static int maxSubBSTSize2(TreeNode head){
       if (head == null){ return 0;}
       return process(head).maxSubBSTSize;
    }
    public static Info process(TreeNode node){
        if (node == null){ return  null;}
        Info left = process(node.left);
        Info right = process(node.right);
        int max = node.value;
        int min = node.value;
        int maxSubBSTSize=0;
        if (left!=null){
            max = Math.max(max,left.max);
            min = Math.max(min,left.min);
            maxSubBSTSize = Math.max(maxSubBSTSize,left.maxSubBSTSize);
        }
        if (right!=null){
            max = Math.max(max,right.max);
            min = Math.max(min,right.min);
            maxSubBSTSize = Math.max(maxSubBSTSize,right.maxSubBSTSize);
        }
        boolean isBST = false;

        if ((left==null?true:(left.isBST&&left.max<node.value))
        && (right==null?true:(right.isBST&&right.min>node.value))
        ){
            isBST = true;
            maxSubBSTSize = (left==null?0:left.maxSubBSTSize)+(right==null?0:right.maxSubBSTSize)+1;
        }
        return new Info(maxSubBSTSize,isBST,max,min);
    }

}
