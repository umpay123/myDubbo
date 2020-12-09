package com.tan.数据结构算法.链表问题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/12/08/10:34
 * @Description:
 */
public class 是否有环 {
    public static void main(String[] args) {

        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
     //   System.out.println(是否有环.isLoop(是否有环.initNode()).value);
        System.out.println(是否有环.getIntersectNode(head1,head2).value);
        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }
    public static Node isLoop(Node head){
        Node res = null;
        if (head == null || head.next==null ){
            return res;
        }
        Node s = head;
        Node f = head.next;
        while (f.next!=null&&f.next.next!=null){
            if (s==f){
                while (head!=null){
                    f = f.next;
                    if (head == f){
                       // System.out.println(head.value);
                        return f;
                    }
                    head = head.next;
                }
                return res;
            }
            s = s.next;
            f = f.next.next;
        }
        return res;
    }
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
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
        f.next = d;
        return a;
    }

    public static Node initNode1(){
        Node a = new Node(11);
        Node b = new Node(22);
        Node c = new Node(33);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        a.next = b;
        b.next =c;
        c.next =d;
        d.next =e;
        e.next =f;
        //    f.next = d;
        return a;
    }

    public static Node getIntersectNode(Node head1,Node head2){
        if (head1 == null || head2 == null){
            return null;
        }
        Node loop1 = isLoop(head1);
        Node loop2 = isLoop(head2);
        if (loop1 == null && loop2 == null){
             return noLoop(head1,head2);
        }
        return bothLoop(head1,loop1,head2,loop2);
    }
    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1=null;
        Node cur2 =  null;
        if (loop1 == loop2){
            int length1 = 0;
            cur1 = head1;
            cur2 = head2;
            while (cur1.next!=loop1){
                length1 ++;
                cur1 = cur1.next;
            }
            int length2 = 0;
            while (cur2.next!=loop2){
                length2 ++;
                cur2 = cur2.next;
            }
            int n = length1 - length2;
            cur1 = n>0?head1:head2;
            cur2 = cur1==head1?head2:head1;
            n = Math.abs(n);
            while (n!=0){ //调整对齐
                n--;
                cur1=cur1.next;
            }
            while (cur1!=cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            cur1 = loop1.next;
            while (cur1!=loop1){
                if (cur1==loop2){
                    return loop2;
                }
                cur1 = cur1.next;
            }
            return null;
        }

    }
    //错误
    public static Node noLoop(Node head1,Node head2){
        int length1 = 0;
        while (head1.next!=null){
           length1 ++;
           head1 = head1.next;
       }
        int length2 = 0;
        while (head2.next!=null){
            length2 ++;
            head2 = head2.next;
        }

        if (length1>length2){
           while (head2!=null){
               if (head2 == head1){
                   return head2;
               }
               head2 = head2.next;
               head1= head1.next;
           }
        }else {
            while (head1!=null){
                if (head1 == head2){
                    return head1;
                }
                head2 = head2.next;
                head1= head1.next;
            }
        }
       return null;
    }
}
