package cn.xiaoyes.summerstudy.io.reader;


import java.io.FileReader;
import java.io.IOException;

/**
 * 字符流读取
 */
public class FileReader_ {
    public static void main(String[] args) {
//        read01();
        read02();
    }

    /**
     * 单个字符读取
     */
    public static void read01(){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("D:\\bbb.txt");
            int data = 0;
            while((data = fileReader.read()) != -1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字符数组读取
     */
    public static void read02(){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("D:\\bbb.txt");
            int len = 0;
            char[] buf = new char[8];
            while((len = fileReader.read(buf)) != -1){
                System.out.print((new String(buf,0,len)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
