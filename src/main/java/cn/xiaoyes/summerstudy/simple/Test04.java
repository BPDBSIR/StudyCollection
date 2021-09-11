package cn.xiaoyes.summerstudy.simple;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test04 {
    public static void main(String[] args) {
        String BASE_URL = "https://www.hetianlab.com/";
        Document document = Jsoup.parse("<p><font size=\\\"3\\\" face=\\\"微软雅黑\\\"><strong>我们将要学习PT的一大特色功能，模拟模式。了解如何进入模拟模式，并且如何使用它进行分析</strong></font></p><p><font size=\\\"3\\\" face=\\\"微软雅黑\\\">1.我们可以看到界面的右下角有个“实时”两字，这代表我们现在是实施模式，在他的旁边，我们就能开启模拟模式。</font></p><p><img src=\\\"headImg.action?guideImg=/8d994a25-7a0e-4f87-af33-a2e2d0da39c1.png\\\" style=\\\"max-width:100%;\\\"></p><p><font size=\\\"3\\\" face=\\\"微软雅黑\\\">点击旁边的“模拟模式”，界面就变成这样了：</font></p><p><img src=\\\"headImg.action?guideImg=/1f66df85-4da0-4090-b74d-7a67c449b155.png\\\" style=\\\"max-width:100%;\\\"></p><p><font size=\\\"3\\\" face=\\\"微软雅黑\\\">2. 我们为了方便，重新创建一个新的拓扑图，大家趁这个机会可以在熟悉一下设备的链接和配置，如下：</font></p><p><img src=\\\"headImg.action?guideImg=/edc1f065-edb9-4276-af9e-82263284cfd2.png\\\" style=\\\"max-width:100%;\\\"></p><p><font size=\\\"3\\\" face=\\\"微软雅黑\\\">3. 两个PC的IP地址不变，我们打开<strong>模拟模式。</strong>模拟模式就像监控控制一样，可以看到发出的包的一举一动，并且我们可以控制让包何时发出。</font></p><p><img src=\\\"headImg.action?guideImg=/ac379da3-baf3-4839-8b54-5e58d74546c0.png\\\" style=\\\"max-width:100%;\\\"></p><p><font size=\\\"3\\\" face=\\\"微软雅黑\\\">底下的过滤器是只捕获那些我们需要的包，其余的忽略。</font></p><p><img src=\\\"headImg.action?guideImg=/d0fd0621-70b2-4663-a076-2c9f959a3270.png\\\" style=\\\"max-width:100%;\\\"></p><p><font size=\\\"3\\\" face=\\\"微软雅黑\\\">4. 接下来，我们用PC1去ping PC2，可以看到界面发生了变化：</font></p><p><img src=\\\"headImg.action?guideImg=/58163454-2942-483a-8657-e35485e48554.png\\\" style=\\\"max-width:100%;\\\"></p><p><font size=\\\"3\\\" face=\\\"微软雅黑\\\">我们可以看到PC1发出的包，在右面的模拟面板中能看到包的祥细内容，每个颜色对应的是什么类型的包：</font></p><p><img src=\\\"headImg.action?guideImg=/0cf591ac-22a8-4fb7-bb94-34a9b9745730.png\\\" style=\\\"max-width:100%;\\\"></p><p><font size=\\\"3\\\" face=\\\"微软雅黑\\\">我们进行的ping操作，所以发出的是ICMP包，我们通过点击“捕获/转发”，让包转发。</font></p><p><img src=\\\"headImg.action?guideImg=/45b98c92-ed83-4c59-983e-87fccc36c15e.png\\\" style=\\\"max-width:100%;\\\"></p><p><font size=\\\"3\\\" face=\\\"微软雅黑\\\">我们可以看到包转发的一个动态过程，这样我们就知道这个包去哪里了，被那台设备解析了，方便我们分析网络中的问题或者是出现的疑难杂症。</font></p><p><img src=\\\"headImg.action?guideImg=/248e959c-0513-452b-9a7c-c731d7c956c7.png\\\" style=\\\"max-width:100%;\\\"></p><p><font size=\\\"3\\\" face=\\\"微软雅黑\\\">模拟面板也随之发生变化：</font></p><p><img src=\\\"headImg.action?guideImg=/3f7bd943-2cb3-4066-9da1-8ca87e607c4f.png\\\" style=\\\"max-width:100%;\\\"></p><p><font size=\\\"3\\\" face=\\\"微软雅黑\\\">直观的告诉我们ARP包从PC1发送到了Switch3。</font></p><p><font size=\\\"3\\\" face=\\\"微软雅黑\\\">通过模拟模式，我们学习了整个包的传播过程。</font></p>");
        Elements elements = document.getElementsByTag("img");
        for (Element e : elements) {
            String s = BASE_URL + e.attr("src").replaceAll("\\\\", "").replaceAll("\"", "");
            e.attr("src", s);
        }
        elements.forEach(System.out::println);


    }
}
