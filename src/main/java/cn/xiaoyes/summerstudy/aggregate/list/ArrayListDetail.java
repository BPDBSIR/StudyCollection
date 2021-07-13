package cn.xiaoyes.summerstudy.aggregate.list;

import java.util.ArrayList;

/**
 * ArrayList注意事项
 */
public class ArrayListDetail {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        arrayList.add("Andrew");
        arrayList.add(null);

        System.out.println(arrayList);
    }
}
