package com.tan.数据结构算法.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/09/17:54
 * @Description:
 */
public class 两数相加 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);
        ListNode tmp = addTwoNumbers(n1,n2);
        System.out.println(tmp);

    }
    /**
     * Definition for singly-linked list.
     *  */
     public static class ListNode {
         int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null || l2 == null){
            return null;
        }
        ListNode head = null;
        ListNode end = null;
        int count =0;
       while (l1!=null||l2!=null){
           int i1 = l1!=null? l1.val:0;
           int i2 = l2!=null? l2.val:0;
           int sum = count+i1+i2;
           if (head == null){
               head = new ListNode(sum%10);
               end = head;
           }else {
               end.next = new ListNode(sum%10);
               end = end.next;
           }

           count = sum/10;
           if (l1!=null) {
               l1 = l1.next;
           }
           if (l2!=null) {
               l2 = l2.next;
           }
       }
       if (count>0){
           end.next = new ListNode(count);
       }
        return head;
    }


}
