package cn.xiaoyes.summerstudy.io.output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        String sourcePath = "F:\\37124b75921435022e081c7625c8f297.jpg";
        String finalPath = "D:\\37124b75921435022e081c7625c8f297.jpg";
        byte[] buff = new byte[1024];
        int readLen = 0;
        FileInputStream fis = new FileInputStream(sourcePath);
        FileOutputStream fos = new FileOutputStream(finalPath);
        while ((readLen = fis.read(buff)) != -1){
            fos.write(buff,0,readLen);
        }
        fos.close();
        fis.close();
    }
}
