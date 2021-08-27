package cn.xiaoyes.summerstudy.thread;

/**
 * 线程创建 继承Thread
 * <p>
 * 线程的三种创建方式：
 * <p>
 * Thread(class)
 * <p>
 * Runnable(接口)
 * <p>
 * Callable(接口)
 */
public class Demo01 {
    public static void main(String[] args) {
        // CPU来调度线程的执行
        // 创建线程对象
        SimpleExtendsThread simpleThread = new SimpleExtendsThread();
        // 线程开始执行
        simpleThread.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程----" + i);
        }
    }
}

/**
 * 继承Thread类 重写run() 调用start()执行线程
 */
class SimpleExtendsThread extends Thread {

    /**
     * 线程入口点(线程体都在此)
     */
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码---" + i);
        }
    }
}


