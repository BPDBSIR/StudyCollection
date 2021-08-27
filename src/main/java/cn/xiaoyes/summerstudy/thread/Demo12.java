package cn.xiaoyes.summerstudy.thread;

/**
 * 强制执行(霸道总裁)
 * Join合并该线程，待此线程执行完成之后，在执行其他线程，其他线程阻塞
 */
public class Demo12 {
    public static void main(String[] args) {
        SimpleJoinThread joinThread = new SimpleJoinThread();
        Thread thread = new Thread(joinThread, "JoinThread");
        thread.start();

        // 主线程
        for (int i = 0; i < 1000; i++) {
            if (i == 200){
                try {
                    thread.join();// 插队
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Main " + i);
        }
    }
}

class SimpleJoinThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip来了~" + i);
        }
    }
}
