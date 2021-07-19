package cn.xiaoyes.summerstudy.io.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\bbb.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        // 单行读取 返回为null时表示文件读取完毕
        String line = "";
        while ((line = br.readLine()) != null){
            System.out.print(line);
        }
        // 只需要关闭处理流集合 底层会自动关闭节点流
        br.close();
    }
}
