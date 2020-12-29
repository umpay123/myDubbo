package com.tan.数据结构算法.二叉树;

import com.tan.数据结构算法.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/17/10:56
 * @Description:
 */
public class 二叉树最宽的层有多少节点 {
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
        System.out.println(maxWidth1(treeNode));
    }
    public static int maxWidth(TreeNode head){
        if(head == null){ return 0;}
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode,Integer> map = new HashMap<>(); //当前节点在哪一层
        queue.add(head);
        map.put(head,1);
        int level = 1;
        int levelNodes = 0;
        int max = 0;
        while (!queue.isEmpty()){
            TreeNode cur  = queue.poll();
            int tmp = map.get(cur);
            if(cur.left!=null){
                map.put(cur.left,level+1);
                queue.add(cur.left);
            }
            if(cur.right!=null){
                map.put(cur.right,level+1);
                queue.add(cur.right);
            }
            if(tmp != level){
                max = Math.max(max,levelNodes);
                levelNodes= 1;
                level ++;
            }else {
                levelNodes++;
            }
        }
        return Math.max(max,levelNodes);
    }
    public static int maxWidth1(TreeNode head){
     if(head == null){ return 0;}
     Queue<TreeNode> queue = new LinkedList<>();
     queue.add(head);
     int levelNodes = 0;
     int max =0 ;
     TreeNode curEnd = head;
     TreeNode nextEnd = null;
     while (!queue.isEmpty()){
         head = queue.poll();
         if (head.left!=null){
             queue.add(head.left);
             nextEnd = head.left;
         }
         if (head.right!=null){
             queue.add(head.right);
             nextEnd = head.right;
         }
         levelNodes++;
         if(head == curEnd){ //当前层最后一个节点
           max = Math.max(max,levelNodes);
           levelNodes = 0;
           curEnd = nextEnd;
         }
     }
     return Math.max(max,levelNodes);
    }
}
