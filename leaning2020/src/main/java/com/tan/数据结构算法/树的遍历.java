package com.tan.数据结构算法;

import org.apache.dubbo.common.utils.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/15/20:23
 * @Description:
 */
public class 树的遍历 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        stackafter1(treeNode);
    }
    public static void dp(TreeNode head){
        if (head == null){
            return;
        }
       // System.out.println(head.value);  // 先序
        dp(head.left);
       // System.out.println(head.value);  //中序
        dp(head.right);
        System.out.println(head.value); //后序
    }
    //非递归 先序
   public static void stackdpPre(TreeNode head){
       if (head == null){ return;}
        Stack<TreeNode> stack = new Stack<>();
         stack.push(head);
         while (!stack.isEmpty()){
             head = stack.pop();
             System.out.println(head.value);
             if (head.right!=null){
                 stack.push(head.right);
             }
             if(head.left!=null){
                 stack.push(head.left);
             }
         }
   }
   public static void stackin(TreeNode head){
        if (head == null){ return;        }
        Stack<TreeNode> stack = new Stack<>();
         while(!stack.isEmpty() || head!=null){
             if(head!=null){
                 stack.push(head);
                 head = head.left;
             }else{
                 head = stack.pop();
                 System.out.println(head.value);
                 head = head.right;
             }
         }
   }
    public static void stackafter(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()){
            head = s1.pop();
            s2.push(head);
            if(head.left!=null){
                s1.push(head.left);
            }
            if(head.right!=null){
                s1.push(head.right);
            }
        }
        while (!s2.isEmpty()){
            System.out.println(s2.pop().value);
        }
    }
    public static void  stackafter1(TreeNode head) {
        if(head == null){return;}
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        TreeNode c = null;
        while (!stack.isEmpty()){
            c = stack.peek();
            if(c.left!=null && c.left!=head && c.right != head){
                stack.push(c.left);
            }else if(c.right != null && c.right != head){
                stack.push(c.right);
            }else{
                System.out.println(stack.pop().value);
                head = c;
            }
        }
    }
}
