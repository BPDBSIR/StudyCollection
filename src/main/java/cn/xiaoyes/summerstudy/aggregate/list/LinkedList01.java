package cn.xiaoyes.summerstudy.aggregate.list;

/**
 * 模拟一个简单的双向链表
 */
public class LinkedList01 {


    public static void main(String[] args) {

        Node jack = new Node("jack");
        Node andrew = new Node("andrew");
        Node tom = new Node("tom");

        /* 连接三个节点 形成双向链表 */
        jack.next = andrew;
        andrew.next = tom;
        tom.pre = andrew;
        andrew.pre = jack;

        /*
        * jack -> andrew -> tom   next
        * jack <- andrew <- tom   pre
        * */

        /* 让first指引用指向jack 就是双向链表的头节点 */
        Node first = jack;
        /* 让last指引用指向tom 就是双向链表的尾节点 */
        Node last = tom;

        /* 从头到尾进行遍历 */
        System.out.println("从头到尾进行遍历");
        while (true){
            if (first == null){
                break;
            }
            /* 输出first信息 */
            System.out.println(first);
            first = first.next;
        }
        /* 从尾到到头进行遍历 */
        System.out.println("从尾到到头进行遍历");
        while (true){
            if (last == null){
                break;
            }
            /* 输出first信息 */
            System.out.println(last);
            last = last.pre;
        }

        /* 双向链表添加数据 在andrew --- tom中间插入一个节点 */
        Node jane = new Node("jane");
        jane.pre = andrew;
        jane.next = tom;

        andrew.next = jane;
        tom.pre = jane;

        /* 让first重置 */
        first = jack;
        System.out.println("从头到尾进行遍历");
        while (true){
            if (first == null){
                break;
            }
            /* 输出first信息 */
            System.out.println(first);
            first = first.next;
        }
        /* 让last重置 */
        last = tom;
        System.out.println("从头到尾进行遍历");
        while (true){
            if (last == null){
                break;
            }
            /* 输出first信息 */
            System.out.println(last);
            last = last.pre;
        }
    }
    // 定义一个Node类表示双向链表的一个节点
    static class Node{
        // 真正存放数据的地方
        public Object item;
        // 指向下一个节点
        public Node next;
        // 指向上一个节点
        public Node pre;


        public Node(Object item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "Node name => " + item;
        }
    }
}
