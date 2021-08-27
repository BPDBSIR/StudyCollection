package cn.xiaoyes.summerstudy.thread;

/**
 * 多个线程同时操作同一个对象(买火车票的例子)
 * <p>
 * 发现问题
 * 多个线程操作同i个资源的情况下，线程不安全，数据紊乱
 */
public class Demo04 {
    public static void main(String[] args) {

        SimpleTrainThread trainThread = new SimpleTrainThread();
        new Thread(trainThread, "小明").start();
        new Thread(trainThread, "老师").start();
        new Thread(trainThread, "黄牛党").start();
        new Thread(trainThread, "小花").start();
        new Thread(trainThread, "小黑").start();
    }
}

class SimpleTrainThread implements Runnable {

    // 票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("模拟延时" + Thread.currentThread().getName());
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums-- + "张票");
        }
    }
}