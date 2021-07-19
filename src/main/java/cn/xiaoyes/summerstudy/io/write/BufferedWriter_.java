package cn.xiaoyes.summerstudy.io.write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\ccc.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        bw.write(65);
        bw.write("Hello I'm from China");
        bw.newLine();// 插入换行
        bw.write("End");
        bw.close();
    }
}
