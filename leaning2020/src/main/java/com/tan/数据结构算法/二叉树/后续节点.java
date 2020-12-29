package com.tan.数据结构算法.二叉树;

import com.tan.数据结构算法.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/17/15:14
 * @Description:
 */
public class 后续节点 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(6);
        head.parent = null;
        head.left = new TreeNode(3);
        head.left.parent = head;
        head.left.left = new TreeNode(1);
        head.left.left.parent = head.left;
        head.left.left.right = new TreeNode(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new TreeNode(4);
        head.left.right.parent = head.left;
        head.left.right.right = new TreeNode(5);
        head.left.right.right.parent = head.left.right;
        head.right = new TreeNode(9);
        head.right.parent = head;
        head.right.left = new TreeNode(8);
        head.right.left.parent = head.right;
        head.right.left.left = new TreeNode(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new TreeNode(10);
        head.right.right.parent = head.right;

        TreeNode test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessNode(test).value);
    }
    /**
     * 后续节点：
     * 1.如果有右子树，往右子树出发，然后转到右子树的左子树，一直到左子树为空;
     * 2.如果没有右子树，则向上寻找父节点，直到父节点的左子树等于当前节点
     */
    public static TreeNode getSuccessNode(TreeNode node){
        if(node == null){ return null;}
        if(node.right!=null){ //有右子树
          return right(node.right);
        }else{ //无右子树
            TreeNode cur = node.parent;
            while(cur!=null && cur.left != node){
                node = cur;
                cur = cur.parent;
            }
            return cur;
        }
    }
    public static TreeNode right(TreeNode node){
        if(node == null){ return node;}
        TreeNode cur = node;
        while (cur.left != null){
            cur = cur.left;
        }
        return cur;
    }
}
