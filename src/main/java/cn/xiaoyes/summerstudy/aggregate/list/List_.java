package cn.xiaoyes.summerstudy.aggregate.list;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Jack");
        list.add("BPDBSIR");
        list.add("Andrew");
        System.out.println(list);


        /* 取出索引为2的元素 */
        String s = list.get(2);
        System.out.println(s);
    }
}
