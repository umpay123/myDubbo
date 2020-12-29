package com.tan.数据结构算法.二叉树递归套路;

import com.tan.数据结构算法.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/17/17:03
 * @Description:
 * 平衡二叉树它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1
 */
public class 判断是否平衡二叉树 {
    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = generateRandomBST(maxLevel, maxValue);
            if (isBalanced1(head) != isBalanced2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
    // for test
    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static class nodeInfo{
       public int level; //高度
       public boolean isBal; //是否平衡二叉树
        public nodeInfo(int level,boolean isBal){
            this.level = level;
            this.isBal = isBal;
        }
    }
    public static boolean isBalanced2(TreeNode head) {
        return process(head).isBal;
    }
    public static nodeInfo process(TreeNode node){
        if(node == null){  return new nodeInfo(0,true);}

        nodeInfo l = process(node.left);
        nodeInfo r = process(node.right);

        int height = Math.max(l.level,r.level)+1;
        boolean isBal = true;
        if (!l.isBal || !r.isBal || Math.abs(l.level-r.level)>1){
            isBal = false;
        }
        return new nodeInfo(height,isBal);
    }

    public static boolean isBalanced1(TreeNode head) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process1(head, ans);
        return ans[0];
    }

    public static int process1(TreeNode head, boolean[] ans) {
        if (!ans[0] || head == null) {
            return -1;
        }
        int leftHeight = process1(head.left, ans);
        int rightHeight = process1(head.right, ans);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
