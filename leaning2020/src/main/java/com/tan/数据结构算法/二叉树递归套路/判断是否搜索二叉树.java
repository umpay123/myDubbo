package com.tan.数据结构算法.二叉树递归套路;

import com.tan.数据结构算法.TreeNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/25/10:53
 * @Description:  若它的左子树上左子树不空，则所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 */
public class 判断是否搜索二叉树 {
    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = generateRandomBST(maxLevel, maxValue);
            if (isBST1(head) != isBst(head)) {
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
    public static class Info{
        public int max;
        public int min;
        public boolean isBST;
        public Info(boolean isBST,int max,int min){
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }
    public static boolean isBst(TreeNode head){
        if (head == null){
            return true;
        }
         Info info = process(head);
         return info.isBST;
    }
    public static Info process(TreeNode node){
        if (node == null){ return  null;}
        Info left = process(node.left);
        Info right = process(node.right);
        int max = node.value;
        int min = node.value;
        if (left!=null){
           max = Math.max(max,left.max);
           min = Math.min(min,left.min);
        }
        if (right!=null){
            max = Math.max(max,right.max);
            min = Math.min(min,right.min);
        }
        boolean isBst = false;
        if(
                (left == null?true:(left.isBST&&left.max<node.value))
          &&
                        (right == null?true:(right.isBST&& right.min>node.value))
         ){
            isBst = true;
        }
        return new Info(isBst,max,min);
    }

    public static boolean isBST1(TreeNode head) {
        if (head == null) {
            return true;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return false;
            }
        }
        return true;
    }

    public static void in(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

}
