package cn.xiaoyes.summerstudy.io.write;

import java.io.*;

public class BufferedCopy_ {
    public static void main(String[] args) throws IOException {
        String srcPath = "F:\\debug.log";
        String destPath = "D:\\debug.log";
        BufferedReader br = new BufferedReader(new FileReader(srcPath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destPath));
        String line = "";
        while ((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
