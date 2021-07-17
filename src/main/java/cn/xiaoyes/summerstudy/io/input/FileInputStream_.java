package cn.xiaoyes.summerstudy.io.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件字节读取
 */
public class FileInputStream_ {
    public static void main(String[] args) {
        File file = new File("D:\\hello.txt");
        readFile01(file);
    }

    /**
     * 单个字节读取
     * @param file
     */
    public static void readFile01(File file){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int read = 0;
            // 单个字节读取
            while ((read = fis.read()) != -1){
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 多字节读取
     * @param file
     */
    public static void readFile02(File file){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] buff = new byte[8];//一次读取8个字节
            int readLen = 0;
            // 从改输入流读取最多buf.length字节的数据到字节数据
            // 如果返回-1 表示读取完毕
            // 如果读取正常 返回实际读取的字节数
            while ((readLen = fis.read(buff)) != -1){
                System.out.print(new String(buff,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
