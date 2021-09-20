package cn.xiaoyes.summerstudy.oldmusic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 爬取歌曲名称
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Document dom = Jsoup.connect("https://www.kugou.com/yy/special/single/3922979.html").get();
        Elements text = dom.getElementsByClass("text");
        FileWriter fw = new FileWriter("oldmusic.txt",true);
        text.forEach(element -> {
            try {
                fw.write(element.child(0).text().trim() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println(text.size());
        fw.close();
    }
}
