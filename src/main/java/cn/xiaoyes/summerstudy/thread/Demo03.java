package cn.xiaoyes.summerstudy.thread;

/**
 * 创建线程 实现Runnable接口 推荐使用
 */
public class Demo03 {

    public static void main(String[] args) {
        // 创建Runnable接口的实现类对象
        SimpleRunnableThread runnableThread  = new SimpleRunnableThread();
        // 创建线程对象
        Thread thread = new Thread(runnableThread);
        thread.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程----" + i);
        }
    }
}

/**
 * 实现Runnbale接口
 */
class SimpleRunnableThread implements Runnable{

    /**
     * 实现抽象方法
     */
    @Override
    public void run() {

        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码---" + i);
        }
    }
}
