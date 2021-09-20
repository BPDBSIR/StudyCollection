package cn.xiaoyes.summerstudy.oldmusic;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 数据过滤
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        String fileName = "oldmusic.txt";
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        Set<String> strings = new HashSet<>();
        while ((line = br.readLine()) != null){
            strings.add(line);
        }
        fr.close();
        FileWriter fw = new FileWriter(fileName,false);
        strings.forEach(s -> {
            try {
                fw.write(s + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        fw.close();
    }
}
