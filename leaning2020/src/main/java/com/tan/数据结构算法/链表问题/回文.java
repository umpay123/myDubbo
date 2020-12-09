package com.tan.数据结构算法.链表问题;

import org.apache.dubbo.common.utils.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/07/17:28
 * @Description:
 */
public class 回文 {
    public static void main(String[] args) {
        System.out.println(回文.getMid(回文.initNode()).value);
        System.out.println(回文.isHuiwen("123321"));
    }
    public static boolean isHuiwen(String s){
        boolean res = true;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c:chars){
            stack.push(c);
        }
        for (char c:chars){
            char tmp = stack.pop();
           if (tmp != c){
               return false;
           }
        }
        return res;
    }
    public static boolean isHuiwen1(String s){
           return false;
    }
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public static Node getMid(Node head){
        if (head.next == null|| head.next.next==null){
            return head;
        }
      Node s = head.next;
      Node f = head.next;
      while (f.next!=null && f.next.next!=null){
          s = s.next;
          f= f.next.next;
      }
      return s;
    }
    public static Node initNode(){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        a.next = b;
        b.next =c;
        c.next =d;
        d.next =e;
        e.next =f;
        return a;
    }
}
