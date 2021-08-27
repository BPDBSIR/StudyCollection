package cn.xiaoyes.summerstudy.thread;

/**
 * 线程的状态
 * Thread t = new Thread() 线程对象一旦创建就进入到了新生状态 当调用start()方法，线程立即进入就绪状态，但不意味着立即调度执行
 * <p>
 * 就绪状态 等待CPU的调度 CPU调度之后进入运行状态
 * <p>
 * 运行状态 进入运行状态，线程才真正执行县城提的代码块
 * <p>
 * 阻塞状态 当调用sleep函数，wait或者同步锁定时，线程进去阻塞状态就是代码不往下执行，阻塞时间解除后，重新进入就绪状态，等待CPU调度执行
 * <p>
 * dead 线程中断或者结束，一旦进入死亡状态，就不能再次启动
 * <p>
 * setPriority(int newPriority) 更改线程的优先级
 * static void sleep(long millis) 在指定的毫秒数内让当前正在执行的线程休眠
 * void join() 等待该线程终止
 * static void yield() 暂停当前正在执行的线程对象 并执行其他线程
 * void interrupt() 中断线程 别用这个方式
 * boolean isAlive() 测试线程是否处于活动状态
 * <p>
 * 线程停止
 */
public class Demo09 {
    public static void main(String[] args) {
        SimpleStopThread runn = new SimpleStopThread();
        Thread t = new Thread(runn);
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("Main" + i);

            if (i == 900) {
                runn.customStop();
                System.out.println("线程停止了");
            }
        }
    }
}

/**
 * 停止线程
 * 建议线程正常停止 利用次数不建议是循环
 * 建议适合用标志位 设置一个标志位
 * 不要使用stop以及destroy等果实或者JDK不建议使用的方法
 */
class SimpleStopThread implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run...Thread" + i++);
        }

    }

    public void customStop() {
        flag = false;
    }
}