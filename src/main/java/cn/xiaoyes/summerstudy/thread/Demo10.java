package cn.xiaoyes.summerstudy.thread;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程休眠
 * sleep(时间)指定当前线程阻塞的毫秒数
 * sleep时间达到之后就进入就绪状态
 * sleep可以模拟网络延迟，倒计时等
 * 每个对象都有一个锁，sleep不会释放锁
 */
public class Demo10 {
    public static void main(String[] args) {
        /*SimpleSleepThread sleepThread = new SimpleSleepThread();
        new Thread(sleepThread, "小花").start();
        new Thread(sleepThread, "小黑").start();
        new Thread(sleepThread, "小黄").start();*/
//        new SimpleSleep().tenDown();
        new CurrentTime().run();
    }
}

class SimpleSleepThread implements Runnable {

    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums-- + "张票");
        }
    }
}

// 模拟倒计时
class SimpleSleep {

    public void tenDown() {
        int num = 10;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num--);
            if (num <= 0) {
                break;
            }
        }
    }
}

class CurrentTime {

    Date startTime = new Date(System.currentTimeMillis());// 获取系统当前时间

    void run(){
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));// 打印时间
            startTime = new Date(System.currentTimeMillis());// 更新当前时间
        }
    }
}