package cn.xiaoyes.summerstudy.simple;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Test03 {
    public static void main(String[] args) throws IOException {

        String BASE_URL = "https://www.hetianlab.com";
        Document doc = Jsoup.connect("https://www.hetianlab.com/cour.do?w=1&c=CCID7ecf-61fc-4ba2-99b5-30633bec9191").get();
        String name = doc.getElementsByClass("courseName").attr("title");

        System.out.println(name);

        String text = doc.getElementsByClass("courseDesc").text();
        System.out.println(text);

        String coverUrl = BASE_URL + "/" + doc.getElementsByClass("course_img").attr("src");
        System.out.println(coverUrl);
    }
}
