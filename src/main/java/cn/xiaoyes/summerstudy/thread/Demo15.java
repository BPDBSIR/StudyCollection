package cn.xiaoyes.summerstudy.thread;

/**
 * 守护线程
 * 线程分为用户线程和守护线程
 * 虚拟机必须确保用户线程执行完毕
 * 虚拟机不用等待守护线程执行完毕
 * 如 后台记录操作日志、监控内存、垃圾回收机制等
 * <p>
 * <p>
 * 上帝守护你
 */
public class Demo15 {
    public static void main(String[] args) {
        You2 you2 = new You2();
        God god = new God();
        Thread t1 = new Thread(god);
        t1.setDaemon(true);// 默认为false表示是用户线程 true则为守护线程
        t1.start();// 上帝守护线程启动
        Thread t2 = new Thread(you2);
        t2.start();// 你用户线程启动
    }
}

class You2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("=====GoodByte World!======");
    }
}

class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑着你");
        }
    }
}