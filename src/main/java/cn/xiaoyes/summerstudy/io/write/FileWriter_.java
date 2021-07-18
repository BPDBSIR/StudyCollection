package cn.xiaoyes.summerstudy.io.write;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字节流读取
 */
public class FileWriter_ {
    public static void main(String[] args) {
        String fileName = "D:\\ccc.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            // 写入单个字符
            fileWriter.write('中');
            char[] chars = {'华','人','民'};
            // 写入字符数组
            fileWriter.write(chars);
            // 写入字符串
            fileWriter.write("共和国");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileWriter != null){
                    // 必须要调用close()或者flush()否则文件内容不会写出
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
