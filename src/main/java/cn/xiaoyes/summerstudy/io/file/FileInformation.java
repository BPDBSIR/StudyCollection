package cn.xiaoyes.summerstudy.io.file;

import java.io.File;

/**
 * 获取文件信息
 */
public class FileInformation {
    public static void main(String[] args) {
        fileInfo();
    }

    public static void fileInfo(){
        File file = new File("D:\\news1.txt");

        System.out.println("文件名称 => " + file.getName());

        System.out.println("绝对路径 => " + file.getAbsolutePath());

        System.out.println("父目录 => " + file.getParent());

        System.out.println("文件大小 => " + file.length());

        System.out.println("是否存在 => " + file.exists());

        System.out.println("是否为文件 =>" + file.isFile());

        System.out.println("是否为目录 => " + file.isDirectory());
    }
}
