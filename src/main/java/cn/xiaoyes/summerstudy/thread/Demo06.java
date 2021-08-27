package cn.xiaoyes.summerstudy.thread;

import java.util.concurrent.*;

/**
 * 线程创建 实现Callable接口 作为了解
 * 1、实现Callable接口，需要返回值类型
 * 2、重写call方法，需要抛出异常
 * 3、创建目标对象
 * 4、创建执行任务 ExecutorService ser = Executors.newFixedThreadPoll(1)
 * 5、提交执行 Future<Boolean> result1 = ser.submit(t1)
 * 6、获取结果 boolean r1 = result1.get()
 * 7、关闭服务 ser.shutdownNow()
 */
public class Demo06 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建线程
        SimpleCallableThread callableThread1 = new SimpleCallableThread(
                "https://c-ssl.duitang.com/uploads/blog/202106/26/20210626232900_aa28f.thumb.300_300_c.jpeg", "img_01.jpg");
        SimpleCallableThread callableThread2 = new SimpleCallableThread(
                "https://c-ssl.duitang.com/uploads/blog/202106/26/20210626232902_dddee.thumb.300_300_c.jpeg", "img_02.jpg");
        SimpleCallableThread callableThread3 = new SimpleCallableThread(
                "https://c-ssl.duitang.com/uploads/blog/202106/26/20210626232902_dddee.thumb.300_300_c.jpeg", "img_03.jpg");
        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> r1 = ser.submit(callableThread1);
        Future<Boolean> r2 = ser.submit(callableThread2);
        Future<Boolean> r3 = ser.submit(callableThread3);

        // 获取结果
        Boolean rb1 = r1.get();
        Boolean rb2 = r2.get();
        Boolean rb3 = r3.get();
        System.out.println(rb1);
        System.out.println(rb2);
        System.out.println(rb3);

        // 关闭服务
        ser.shutdownNow();
    }
}

class SimpleCallableThread implements Callable<Boolean>{

    @Override
    public Boolean call() throws Exception {
        WebDownload webDownload = new WebDownload();
        webDownload.downloader(url, name);
        System.out.println("下载完成: 地址 => " + url + " 文件名 => " + name);
        return true;
    }

    private final String url;

    private final String name;

    public SimpleCallableThread(String url, String name) {
        this.url = url;
        this.name = name;
    }

}