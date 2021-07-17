package cn.xiaoyes.summerstudy.io.file;

import java.io.File;
import java.io.IOException;

/**
 * 创建文件
 */
public class FileCreate {
    public static void main(String[] args) {
//        create01();
//        create02();
        create03();;
    }

    /**
     * public File(String pathname)
     */
    public static void create01() {
        String filePath = "D:\\news1.txt";
        File file = new File(filePath);
        try {
            boolean result = file.createNewFile();// 只有执行createNewFile()才会真正创建对象
            if (result) System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * public File(File parent, String child)
     */
    public static void create02(){
        File file = new File("D:\\");
        String fileName = "news2.txt";
        File newFile = new File(file, fileName);
        try {
            boolean result = newFile.createNewFile();
            if (result) System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * public File(String parent, String child)
     */
    public static void create03(){
        String parent = "D:\\";
        String child = "news3.txt";
        File file = new File(parent,child);
        try {
            boolean result = file.createNewFile();
            if (result) System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
