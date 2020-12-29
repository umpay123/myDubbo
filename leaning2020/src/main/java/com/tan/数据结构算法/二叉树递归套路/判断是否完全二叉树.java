package com.tan.数据结构算法.二叉树递归套路;

import com.tan.数据结构算法.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/25/15:46
 * @Description:若设二叉树的深度为k，除第 k 层外，其它各层 (1～k-1) 的结点数都达到最大个数，第k 层所有的结点都连续集中在最左边，这就是完全二叉树。
 */
public class 判断是否完全二叉树 {
    public static class Info {
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean full, boolean cbt, int h) {
            isFull = full;
            isCBT = cbt;
            height = h;
        }
    }
    public static Info process(TreeNode node){
        if (node == null){ return new Info(true,true,0);}
        Info left = process(node.left);
        Info right = process(node.right);
        int height = Math.max(left.height,right.height)+1;
        boolean isFull = left.isFull&& right.isFull && left.height==right.height;
        boolean isCBT = false;
        if (isFull){
            isCBT = true;
        }else {
            if (left.isCBT && right.isCBT){
                if (left.isCBT && right.isFull && left.height == right.height+1){
                    isCBT = true;
                }
                if (left.isFull&& right.isFull && left.height==right.height+1){
                    isCBT = true;
                }
                if (left.isFull && right.isCBT && left.height==right.height+1){
                    isCBT = true;
                }
            }
        }
        return new Info(isFull,isCBT,height);
    }
}
