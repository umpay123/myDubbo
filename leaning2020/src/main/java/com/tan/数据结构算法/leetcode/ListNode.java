package com.tan.数据结构算法.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/11/15:18
 * @Description:
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int x,ListNode node) {
        val = x;
        next = node;
    }
}
