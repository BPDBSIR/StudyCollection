package cn.xiaoyes.summerstudy.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 练习Thread，实现多个线程下载图片
 */
public class Demo02 {
    public static void main(String[] args) {
        // 创建线程
        DownloadThread downloadThread1 = new DownloadThread(
                "https://c-ssl.duitang.com/uploads/blog/202106/26/20210626232900_aa28f.thumb.300_300_c.jpeg", "img_01.jpg");
        DownloadThread downloadThread2 = new DownloadThread(
                "https://c-ssl.duitang.com/uploads/blog/202106/26/20210626232902_dddee.thumb.300_300_c.jpeg", "img_02.jpg");
        DownloadThread downloadThread3 = new DownloadThread(
                "https://c-ssl.duitang.com/uploads/blog/202106/26/20210626232902_dddee.thumb.300_300_c.jpeg", "img_03.jpg");
        // 开启线程
        downloadThread1.start();
        downloadThread2.start();
        downloadThread3.start();
    }
}

/**
 * 下载线程
 */
class DownloadThread extends Thread {

    private final String url;

    private final String name;

    public DownloadThread(String url, String name) {
        this.url = url;
        this.name = name;
    }

    /**
     * 线程执行体
     */
    @Override
    public void run() {
        WebDownload webDownload = new WebDownload();
        webDownload.downloader(url, name);
        System.out.println("下载完成: 地址 => " + url + " 文件名 => " + name);
    }
}

/**
 * 下载工具类
 */
class WebDownload {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}