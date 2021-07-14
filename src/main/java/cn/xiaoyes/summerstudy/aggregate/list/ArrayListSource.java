package cn.xiaoyes.summerstudy.aggregate.list;

import java.util.ArrayList;

/**
 * ArrayList底层源码分析
 */
@SuppressWarnings("all")
public class ArrayListSource {
    public static void main(String[] args) {
        // 使用无参构造器创建对象
//        ArrayList list = new ArrayList();
        ArrayList list = new ArrayList(8);
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);
        System.out.println(list);

    }
}
