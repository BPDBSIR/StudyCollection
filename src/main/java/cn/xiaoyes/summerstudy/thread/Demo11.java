package cn.xiaoyes.summerstudy.thread;

/**
 * 线程礼让
 * 礼让线程 让当前正在执行的线程暂停 但不阻塞
 * 将线程从运行状态转换为就绪状态
 * 让cpu重新调度，礼让不一定成功，看CPU心情！
 */
public class Demo11 {
    public static void main(String[] args) {
        SimpleYieldThread yieldThread = new SimpleYieldThread();
        new Thread(yieldThread,"A").start();
        new Thread(yieldThread,"B").start();
    }
}

/**
 * 礼让线程
 */
class SimpleYieldThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}