package cn.xiaoyes.summerstudy.simple;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        String absUrl = getAbsUrl("https://www.hetianlab.com/expc.do?w=exp_ass&ec=ECID9d6c0ca797abec2016090509444000001");
        System.out.println(absUrl);
    }

    /**
     * 处理跳转链接，获取重定向地址
     * @param url   源地址
     * @return      目标网页的绝对地址
     */
    public static String getAbsUrl(String url){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpClientContext context = HttpClientContext.create();
        HttpGet httpget = new HttpGet(url);
        httpget.setHeader("Cookie","UM_distinctid=17a6c908a76cbb-013abcc224cdef-6373264-19fa51-17a6c908a77704; pgv_pvid=5868343401; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2217bb95c3fcbb88-0116d07560e78e-c343365-1702481-17bb95c3fcce6c%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%2217bb95c3fcbb88-0116d07560e78e-c343365-1702481-17bb95c3fcce6c%22%7D; name=15346247504; email=15346247504; token=a9c9d8739b4d4d2a9caf3ce0f7a77220; JSESSIONID=23D75130E170425B24E4EFFF4B95E0CF.jvm3; noticeFlag=1a1d3896; route=601dd1baa968aa5deeaa0b868c1c716b; CNZZDATA1279677270=1908445861-1625316635-%7C1631231625; _pk_ref.60.c4fd=%5B%22%22%2C%22%22%2C1631238489%2C%22http%3A%2F%2Fwww.baimin.com%2F%22%5D; _pk_ses.60.c4fd=1; Hm_lvt_dc527c4bccb13a86a6fc7b678c5f3619=1630902435,1630980112,1631170870,1631238489; IM_notice_flag=1; __qc_wId=61; uuid=REG-94c2-5037-466f-9375-8d5909698e2f; sf9=1; sso-sid=\"q9hr0WseFsv2pgP7s/PYddF350xMrlHIIlUdKZQPkBxpXzuqITCLokMBJQdQXUmvmkNfzBlOVLU7#Adr/zfWljTgRO+Avsj9mnGbpRmO2sb6hACv9oHyRxTc6r1KvWVnJxMbbN8gIp63ByvCGz709mdfF#SRzKYgvbstzhdIxKHIg=#\"; _pk_id.60.c4fd=563f7e9275b5cc96.1625319050.24.1631239095.1631238489.; Hm_lpvt_dc527c4bccb13a86a6fc7b678c5f3619=1631239095");
        CloseableHttpResponse response = null;
        String absUrl = null;
        try {
            response = httpclient.execute(httpget, context);
            HttpHost target = context.getTargetHost();
            List<URI> redirectLocations = context.getRedirectLocations();
            URI location = URIUtils.resolve(httpget.getURI(), target, redirectLocations);
            absUrl = location.toASCIIString();
        }catch(IOException e){
            e.printStackTrace();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }finally {
            try {
                httpclient.close();
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return absUrl;
    }
}
