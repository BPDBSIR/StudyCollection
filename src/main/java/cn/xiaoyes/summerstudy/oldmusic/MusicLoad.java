package cn.xiaoyes.summerstudy.oldmusic;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MusicLoad {
    public static void main(String[] args) throws IOException {
        String dirPath = "E:\\Music\\";
        FileReader fr = new FileReader("oldmusic.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        // 音乐集合
        List<String> dataMusic = new ArrayList<>();
        while ((line = br.readLine()) != null){
            dataMusic.add(line);
        }
        System.out.println("总共下载数量: " + dataMusic.size());
        String name = "";
        // 遍历
        for (int i = 0; i < dataMusic.size(); i++) {
            try {
                // 请求音乐列表
                String resp = HttpUtil.get("https://3g.gljlw.com/music/kuwo/search.php?word=" + dataMusic.get(i).split("-")[1].trim());
                // 获取dom对象
                Document dom = Jsoup.parse(resp);
                // 解析我们需要的地址
                Elements domLines = dom.getElementsByClass("line1");
                String p = domLines.get(0).child(1).attr("href");
                name = domLines.get(0).child(1).text();
                // 请求音乐页面
                String respMusic = HttpUtil.get("https://3g.gljlw.com/music/kuwo/" + p);
                Document domMusic = Jsoup.parse(respMusic);
                // 音乐地址
                String musicUrl = domMusic.getElementsByClass("but").get(0).attr("href");
                // 下载
                FileUtils.copyURLToFile(new URL(musicUrl),new File(dirPath + name + ".mp3"));
                System.out.println("下载完成: => 行数: " + (i + 1) + " 歌曲: " + name);
            }catch (Exception e){
                System.err.println("下载失败 => 行数: " + (i + 1) + " 歌曲: " + name + " 异常信息: " + e.getMessage());
            }
        }
        System.out.println("所有歌曲下载完毕!");
    }
}
