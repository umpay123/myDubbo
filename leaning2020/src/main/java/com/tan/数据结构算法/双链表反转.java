package com.tan.数据结构算法;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/11/20/14:15
 * @Description:
 */
public class 双链表反转 {
    public static void main(String[] args) {
        DubboNode dubboNode = new DubboNode().initDate();
//        while (dubboNode!=null){
//            System.out.print(dubboNode.value);
//            dubboNode = dubboNode.next;
//        }
        DubboNode dubboNode1 = 双链表反转.reverDubboNode(dubboNode);
        while (dubboNode1 != null){
            System.out.println(dubboNode1.value);
            dubboNode1 = dubboNode1.next;
        }
    }
    private static DubboNode reverDubboNode(DubboNode head){
        DubboNode pre = null;
        DubboNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
