package cn.xiaoyes.summerstudy.io.output;

import java.io.*;

/**
 * 缓冲字节流拷贝文件
 */
public class BufferedCopy_ {
    public static void main(String[] args) throws IOException {
        String srcPath = "F:\\ChMkJ1bKyPCIFjdmAAQEWPp7CYEAALIIQJPdT0ABARw516.jpg";
        String destPath = "D:\\abcc.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcPath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath));
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1){
            bos.write(bytes,0,len);
        }
        bis.close();
        bos.close();
    }
}
