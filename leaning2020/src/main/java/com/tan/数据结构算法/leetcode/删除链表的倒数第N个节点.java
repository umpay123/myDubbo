package com.tan.数据结构算法.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/11/15:17
 * @Description:
 */
public class 删除链表的倒数第N个节点 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        removeNthFromEnd(listNode,2);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode pre = new ListNode(0,head);
      int length = getLength(head);
      ListNode cur = pre;
      for (int i=0;i<length-n;i++){
          cur = cur.next;
      }
      cur.next = cur.next.next;
      return pre.next;
    }

    public static int getLength(ListNode head){
        int length =0 ;
        while (head!=null){
            length++;
            head = head.next;
        }
        return length;
    }
}
