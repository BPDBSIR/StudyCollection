package cn.xiaoyes.summerstudy.simple;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.xiaoyes.summerstudy.kotlin.B;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class Test01 {
    public static void main(String[] args) throws IOException {
        /*HttpRequest request = HttpUtil.createGet("https://www.hetianlab.com/expc.do?w=exp_ass&ec=ECID9d6c0ca797abec2016090509444000001");
        request.header("Referer","https://www.hetianlab.com/cour.do?w=1&c=CCIDda35-285b-4589-9177-3afeae6fd192");
        request.setMaxRedirectCount(-1);
        HttpResponse execute = request.execute();
        Map<String, List<String>> headers = execute.headers();
        headers.forEach(new BiConsumer<String, List<String>>() {
            @Override
            public void accept(String s, List<String> strings) {
                System.out.println(s);
            }
        });*/

        HttpRequest request = new HttpRequest("https://www.hetianlab.com/expc.do?w=exp_ass&amp;ec=ECID9d6c0ca797abec2016090509444000001");
        request.setMaxRedirectCount(0);
        HttpResponse response = request.execute();
        Map<String, List<String>> headers = response.headers();
        headers.forEach(new BiConsumer<String, List<String>>() {
            @Override
            public void accept(String s, List<String> strings) {
                System.out.println(s + " ===>");

                strings.forEach(System.out::println);
            }
        });
    }
}
