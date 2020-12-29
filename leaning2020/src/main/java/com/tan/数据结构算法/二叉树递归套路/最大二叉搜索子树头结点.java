package com.tan.数据结构算法.二叉树递归套路;

import com.tan.数据结构算法.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/25/14:35
 * @Description:
 */
public class 最大二叉搜索子树头结点 {
    public static class Info{
        public int max;
        public int min;
        public boolean isBST;
        public int maxSubBSTSize;
        public TreeNode maxHead;
        public Info(int maxSubBSTSize, boolean isBST,int max,int min,TreeNode maxHead){
            this.max = max;
            this.min = min;
            this.isBST = isBST;
            this.maxSubBSTSize = maxSubBSTSize;
            this.maxHead = maxHead;
        }
    }
    public static TreeNode maxSubBSTSize2(TreeNode head){
       if (head == null){ return null;}
       return process(head).maxHead;
    }
    public static Info process(TreeNode node){
        if (node == null){ return  null;}
        Info left = process(node.left);
        Info right = process(node.right);
        int max = node.value;
        int min = node.value;
        int maxSubBSTSize=0;
        TreeNode maxHaed = null;
        if (left!=null){
            max = Math.max(max,left.max);
            min = Math.max(min,left.min);
            maxSubBSTSize = Math.max(maxSubBSTSize,left.maxSubBSTSize);
            maxHaed = left.maxHead;
        }
        if (right!=null){
            max = Math.max(max,right.max);
            min = Math.max(min,right.min);
            if (right.maxSubBSTSize>maxSubBSTSize){
                maxSubBSTSize=right.maxSubBSTSize;
                maxHaed = right.maxHead;
            }

        }
        boolean isBST = false;
        if ((left==null?true:(left.isBST&&left.max<node.value))
        && (right==null?true:(right.isBST&&right.min>node.value))
        ){
            isBST = true;
            maxSubBSTSize = (left==null?0:left.maxSubBSTSize)+(right==null?0:right.maxSubBSTSize)+1;
            maxHaed = node;
        }
        return new Info(maxSubBSTSize,isBST,max,min,node);
    }

}
