package cn.xiaoyes.summerstudy.aggregate.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 添加10个以上的元素 在2号位置插入一个元素"BPDBSIR" 获得第5个元素 删除第6个元素 修改第7个元素 在使用迭代器遍历集合
 */
public class ListExercise {

    public static void main(String[] args) {
        List<String> array = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            array.add("元素" + (i + 1));
        }
        System.out.println(array);

        array.add(2,"BPDBSIR");

        System.out.println(array);

        String s = array.get(5);
        System.out.println(s);

        array.remove(6);
        System.out.println(array);

        array.set(7,"Andrew");

        Iterator<String> iterator = array.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
