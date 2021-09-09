package cn.xiaoyes.summerstudy.thread;

/**
 * 死锁
 * 多线程各自占有一些共享资源，并且互相等待其他线程占有的资源才能运行，二导致两个或者多个线程都在等待对方
 * 释放资源，都停止执行的情况，某一个同步块同时拥有“两个以上对象的锁”，时，就可能会发生死锁的问题
 * <p>
 * <p>
 * 多个线程互相抱着对方需要的资源，然后形成僵持
 */
public class Demo20 {
    public static void main(String[] args) {
        Markup markup1 = new Markup(0, "小红");
        Markup markup2 = new Markup(0, "小花");
        markup1.start();
        markup2.start();
    }
}

// 口红
class Lipstick {

}

// 镜子
class Mirror {

}


class Markup extends Thread {

    // 需要的资源只有一份，用static来保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    // 选择
    int choice;

    // 使用化妆品的人
    String girlName;

    public Markup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    /**
     *
     */
    @Override
    public void run() {

        // 化妆

        makeup();
    }

    // 化妆，互相持有对象的锁，就是需要拿到对象的资源
    private void makeup() {
        if (choice == 0) {
            // 获得口红的锁
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror) {
                    // 一秒钟后获得镜子
                    System.out.println(this.girlName + "获得镜子的锁");
                }
            }
        } else {

            // 获得镜子的锁
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子的锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick) {
                    // 获得口红的锁
                    System.out.println(this.girlName + "获得口红的锁");
                }
            }
        }
    }
}