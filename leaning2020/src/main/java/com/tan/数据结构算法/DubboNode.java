package com.tan.数据结构算法;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/11/20/13:56
 * @Description:
 */
public class DubboNode {
    public int value;
    public DubboNode pre;
    public DubboNode next;
    public DubboNode initDate(){
        DubboNode node1 = new DubboNode();
        DubboNode node2 = new DubboNode();
        DubboNode node3 = new DubboNode();
        DubboNode node4 = new DubboNode();
        DubboNode node5 = new DubboNode();
        DubboNode node6 = new DubboNode();
        DubboNode node7 = new DubboNode();
        node7.value=7; node7.pre=null;node7.next=node6;
        node6.value=6; node6.pre=node7;node6.next=node5;
        node5.value=5; node5.pre=node6;node5.next=node4;
        node4.value=4; node4.pre=node5;node4.next=node3;
        node3.value=3; node3.pre=node4;node3.next=node2;
        node2.value=2; node2.pre=node3;node2.next=node1;
        node1.value=1; node1.pre=node2;node1.next=null;
        return node7;
    }

    public DubboNode(int value, DubboNode pre, DubboNode next) {
        this.value = value;
        this.pre = pre;
        this.next = next;
    }

    public DubboNode() {
    }
}
