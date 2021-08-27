package cn.xiaoyes.summerstudy.thread;

/**
 * 线程的优先级
 *
 */
public class Demo14 {
    public static void main(String[] args) {
        // 主线程默认优先级
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());


        SimplePriorityThread priorityThread = new SimplePriorityThread();


        Thread t1 = new Thread(priorityThread);
        Thread t2 = new Thread(priorityThread);
        Thread t3 = new Thread(priorityThread);
        Thread t4 = new Thread(priorityThread);
        Thread t5 = new Thread(priorityThread);
        Thread t6 = new Thread(priorityThread);

        t1.start();
        t2.setPriority(1);
        t2.start();
        t3.setPriority(4);
        t3.start();
        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();
        t5.start();
        t6.start();
    }
}

class SimplePriorityThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
    }
}