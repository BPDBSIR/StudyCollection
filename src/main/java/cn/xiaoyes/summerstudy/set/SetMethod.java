package cn.xiaoyes.summerstudy.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set常用方法
 */
@SuppressWarnings("all")
public class SetMethod {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("Tom");
        set.add("Andrew");
        set.add("Jane");
        set.add("Jack");
        set.add(null);
        set.add(null);

        /* 迭代器遍历 */
        System.out.println("------------迭代器遍历");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        /* 增强for循环遍历 */
        System.out.println("------------增强for循环遍历");
        for (Object o : set) {
            System.out.println(o);
        }
    }
}
