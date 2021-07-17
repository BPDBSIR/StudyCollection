package cn.xiaoyes.summerstudy.io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 输出数据到文件
 */
public class FileOutputStream_ {
    public static void main(String[] args) {
        writeFile01(new File("D:\\aaa.txt"));
    }

    /**
     * 使用FileOutputStream 对数据写道文件中
     * 如果文件不存在 则创建改文件
     */
    public static void writeFile01(File file){
        FileOutputStream fos = null;
        try {
            // append为true表示追加内容 为false表示覆盖内容
            fos = new FileOutputStream(file,true);
            // 写入一个字节
//            fos.write('H');
            // 写入多个字节
            String str = "Hello World";
//            fos.write(str.getBytes());
            fos.write(str.getBytes(),0,3);// 只写入字节数组中的前3个字符
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
