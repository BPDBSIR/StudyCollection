package cn.xiaoyes.summerstudy.oldmusic;

import java.io.File;

/**
 * 删除后缀不是mp3的文件
 */
public class Demo2 {
    public static void main(String[] args) {
        File file = new File("E:\\Music");
        File[] files = file.listFiles();
        int count = 0;
        for (File f : files) {
            if (!f.getName().endsWith("mp3")){
                System.out.println(f.getName());
                f.delete();
                count++;
            }
        }
        System.out.println("一共成功删除: " + count + "个无用文件");
    }
}
