package cn.xiaoyes.summerstudy.thread;

/**
 * 线程状态观测
 * Thread.State
 * NEW  尚未启动的线程处于此状态
 * RUNNABLE 在Java虚拟机中执行的线程处于此状态
 * BLOCKED 被阻塞等待监视器锁定的线程处于此状态
 * WAITING 在等待另外一个线程执行特定动作的线程处于此状态
 * TIMED_WAITING 在等待另外一个线程执行动作达到指定等待时间的线程处于此状态
 * TERMINATED 已经退出的线程处于此状态
 */
public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("/////////////////");
        });
        // 获取状态
        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();
        state = thread.getState();
        System.out.println(state);

        // 只要线程不停止就一直输出状态
        while (state != Thread.State.TERMINATED){
            Thread.sleep(100);

            state = thread.getState();
            System.out.println(state);
        }
    }
}