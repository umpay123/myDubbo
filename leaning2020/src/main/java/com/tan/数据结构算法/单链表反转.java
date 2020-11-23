package com.tan.数据结构算法;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/11/20/10:33
 * @Description:
 */
public class 单链表反转 {
    public static void main(String[] args) {
        Node head = new Node().initNode();
        Node reverNode = 单链表反转.reverNode(head);
        while (reverNode!=null){
            System.out.printf(reverNode.getValue()+"");
            reverNode = reverNode.getNextNode();
        }
    }
    public static Node reverNode(Node head){
        if (head == null || head.getNextNode()==null){
            return head;
        }

        Node cur = head;
        Node pre = null;
        while (cur !=null){
            Node tmp = cur.getNextNode();
            cur.setNextNode(pre);
            pre = cur;
            cur = tmp;
        }
         return pre;
    }
}
