package com.tan.数据结构算法;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/11/23/16:18
 * @Description:
 */
public class 链表实现栈和队列 {
    public void firstPush(DubboNode node){

    }
  public   static class Node<T>{
        public T value;
        public Node<T> last;
        public Node<T> next;
        public Node(T data){
            value = data;
        }
    }
    public static class DoubleEndsQueue<T>{
        public Node<T> head; //头结点
        public Node<T> tail; //w尾结点
        public void addFromHead(T value){
           Node<T> cur = new Node<>(value);
           if (head == null){
               head = cur;
               tail = cur;
           }else {
               cur.next = head;
               head.last = cur;
               head = cur;
           }
        }
        public T popFromHead(){
            if (head == null){
                return  null;
            }else if (head == tail){
                Node<T> tmp = head;
                head = null;
                tail = null;
                return tmp.value;
            }else {
                Node<T> tmp = head;
                head = head.next;
                tmp.next = null;
                head.last = null;
                return tmp.value;
            }
        }

        public void addFromBottom(T value){
           Node<T> cur = new Node<T>(value);
           if (tail == null){
               head = cur;
               tail = cur;
           }else {
               cur.last = tail;
               tail.next = cur;
               tail = cur;
           }
        }
        public T  popFromBottom(){
           if (tail == null){
               return  null;
           }else if (head == tail){
               Node<T> tmp = tail;
               head = null;
               tail = null;
               return tail.value;
           }else {
               Node<T> tmp = tail;
               tail=tail.last;
               tail.next = null;
               tmp.last = null;
               return tmp.value;
           }
        }
    }
  public   static class MyStack<T>{
        private DoubleEndsQueue<T> queue;
        public MyStack(){
            queue = new DoubleEndsQueue<>();
      }
      public void push(T value){
            queue.addFromHead(value);
      }
      public void pop(){
            queue.popFromHead();
      }
    }

    public static  class MyQueue<T>{
        private DoubleEndsQueue<T> queue ;
        public MyQueue(){
            queue = new DoubleEndsQueue<>();
        }
        public void push(T value){
            queue.addFromHead(value);
        }
        public void pop(){
            queue.popFromBottom();
        }
    }
}

