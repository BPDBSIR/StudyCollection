package cn.xiaoyes.summerstudy.thread;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * JUC安全类型的集合(CopyOnWriteArrayList)
 */
public class Demo19 {
    public static void main(String[] args) throws InterruptedException {
        // 线程安全的
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> arrayList.add(Thread.currentThread().getName())).start();
        }

        Thread.sleep(3000);
        System.out.println(arrayList.size());
    }
}
