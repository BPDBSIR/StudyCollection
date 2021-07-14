package cn.xiaoyes.summerstudy.aggregate.list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * LinkedList增删改查操作
 */
@SuppressWarnings("all")
public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // 添加节点
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("linkedList => " + linkedList);

        // 删除节点(第一个)
        linkedList.remove();

        System.out.println("linkedList => " + linkedList);


        // 修改某个节点对象
        linkedList.set(1,999);

        // 得到某个节点对象
        Object o = linkedList.get(1);
        System.out.println(o);


        // LinkedList实现了List接口 遍历方式可以使用迭代器
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
