package cn.xiaoyes.summerstudy.aggregate.list;

import java.util.Vector;

/**
 * Vector扩容机制分析
 */
@SuppressWarnings("all")
public class VectorSource {
    public static void main(String[] args) {
        //无参构造
        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        vector.add(100);
    }
}
