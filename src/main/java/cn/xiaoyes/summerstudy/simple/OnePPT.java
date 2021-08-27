package cn.xiaoyes.summerstudy.simple;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 分类
 */
class Category {
    private final String name;
    private final String url;

    public Category(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "分类名称: " + getName() + "\t\t" + "分类地址: " + getUrl();
    }
}

/**
 * PPT
 */
class PPT {
    private final String imgUrl;
    private final String name;
    private final String url;

    public PPT(String imgUrl, String name, String url) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.url = url;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "名称: " + getName() + "\t\t" + "图片地址: " + getImgUrl() + "\t\t" + "内容地址: " + getUrl();
    }
}

/**
 * 下载地址
 */
class DownloadUrl {
    private final String one;
    private final String two;

    public DownloadUrl(String one, String two) {
        this.one = one;
        this.two = two;
    }

    public String getOne() {
        return one;
    }

    public String getTwo() {
        return two;
    }

    @Override
    public String toString() {
        return "下载地址一: " + getOne() + "\t\t" + "下载地址二: " + getTwo();
    }
}

public class OnePPT {

    private static final String SERVER_URL = "http://www.1ppt.com";

    private static final String ROOT_DIR = "F:\\OnePPT\\";


    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Category> categories = requestCategory();
        for (Category category : categories) {
            System.out.println(category);
            File file = new File(ROOT_DIR + category.getName());
            if (!file.exists()) {
                file.mkdir();
            }
            String[] strings = category.getUrl().split("/");
            List<PPT> pptList = requestCategoryAll(category.getUrl(), strings[strings.length - 1]);
            for (PPT ppt : pptList) {
                System.out.println(ppt);
                DownloadUrl downloadUrl = requestDownloadUrls(requestDownloadPageUrl(ppt.getUrl()));
                System.out.println(downloadUrl);
                String filePath = ROOT_DIR + category.getName() + "\\" + ppt.getName() + ".zip";
                FileUtils.copyURLToFile(new URL(downloadUrl.getOne()), new File(filePath));
                System.out.println("下载完成 => " + filePath);
                System.out.println();
            }
        }
//        List<PPT> ppts = requestByCategory("http://www.1ppt.com/moban/jianjie/");
//        for (PPT ppt : ppts) {
//            System.out.println(ppt);
//        }

//        List<String> list = requestDownloadPageUrl("http://www.1ppt.com/article/83520.html");
//
//        DownloadUrl downloadUrl = requestDownloadUrls("http://www.1ppt.com/plus/download.php?open=0&aid=83520&cid=3");
//        FileUtils.copyURLToFile(new URL(downloadUrl.getOne()), new File(ROOT_DIR + "1.zip"));
//        System.out.println(downloadUrl);

//        String s = requestNextPageUrl("http://www.1ppt.com/moban/jianjie/ppt_jianjie_24.html", "jianjie");
//        System.out.println(s);
//        List<PPT> pptList = requestCategoryAll("http://www.1ppt.com/moban/jianjie/", "jianjie");
//        for (PPT ppt : pptList) {
//            System.out.println(ppt);
//            DownloadUrl downloadUrl = requestDownloadUrls(requestDownloadPageUrl(ppt.getUrl()));
//            System.out.println(downloadUrl);
//            String filePath = ROOT_DIR + ppt.getName() + ".zip";
//            FileUtils.copyURLToFile(new URL(downloadUrl.getOne()), new File(filePath));
//            System.out.println("下载完 => " + filePath);
//            System.out.println();
//        }

    }

    /**
     * 获取分类列表
     *
     * @return
     * @throws IOException
     */
    public static List<Category> requestCategory() throws IOException {
        Document root = Jsoup.connect(SERVER_URL).get();
        Elements nav = root.getElementsByClass("col_nav i_nav clearfix");
        Elements list = nav.select("ul li a");
        List<Category> categories = new ArrayList<>();
        list.forEach(element -> categories.add(new Category(element.attr("title"), SERVER_URL + element.attr("href"))));
        return categories;
    }

    /**
     * 获取分类中的PPT
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static List<PPT> requestByCategory(String url) throws IOException {
        Document root = Jsoup.connect(url).get();
        Elements list = root.getElementsByClass("tplist").select("li");
        List<PPT> data = new ArrayList<>();
        list.forEach(element -> data.add(new PPT(element.select("img").attr("src"), element.select("img").attr("alt"), SERVER_URL + element.select("a").attr("href"))));
        return data;
    }

    /**
     * 获取下载页面地址
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String requestDownloadPageUrl(String url) throws IOException {
        Document root = Jsoup.connect(url).get();
        return SERVER_URL + root.getElementsByClass("downurllist").get(0).select("li a").attr("href");
    }

    /**
     * 获取下载地址
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static DownloadUrl requestDownloadUrls(String url) throws IOException {
        Document root = Jsoup.connect(url).get();
        Elements list = root.getElementsByClass("downloadlist");
        Elements li = list.get(0).select("li a");
        return new DownloadUrl(li.get(0).select("a").attr("href"), li.get(1).select("a").attr("href"));
    }

    /**
     * 获取下一页地址
     *
     * @param url 当前页面地址
     * @return
     * @throws IOException
     */
    public static String requestNextPageUrl(String url, String category) throws IOException {
        Document root = Jsoup.connect(url).get();
        Elements pageLi = root.getElementsByClass("pages").select("li");
        Element element = pageLi.get(pageLi.size() - 2);
        if (element.select("a").text().equals("下一页")) {
            return SERVER_URL + "/moban/" + category + "/" + pageLi.get(pageLi.size() - 2).select("a").attr("href");
        }
        return null;
    }

    /**
     * 获取某分类下所有的PPT
     *
     * @return
     */
    public static List<PPT> requestCategoryAll(String url, String category) throws IOException {
        List<PPT> data = new ArrayList<>(requestByCategory(url));
        String currentUrl = url;
        while ((currentUrl = requestNextPageUrl(currentUrl, category)) != null) {
            data.addAll(requestByCategory(currentUrl));
        }
        return data;
    }
}
