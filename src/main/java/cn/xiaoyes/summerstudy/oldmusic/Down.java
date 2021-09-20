package cn.xiaoyes.summerstudy.oldmusic;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Down {
    public static void main(String[] args) throws IOException {
        HttpRequest request = HttpUtil.createGet("http://www.kuwo.cn/api/www/search/searchMvBykeyWord?key=%E8%AE%B8%E5%B7%8D&pn=1&rn=30&httpsStatus=1&reqId=885f6661-1959-11ec-8edb-9711144ad5c8");
        Map<String,String> headerMap = new HashMap<>();
        headerMap.put("csrf","CCVJGWS9R1G");
        headerMap.put("Cookie","_ga=GA1.2.1257735364.1632054668; _gid=GA1.2.1118126108.1632054668; Hm_lvt_cdb524f42f0ce19b169a8071123a4797=1632054667,1632063052; Hm_lpvt_cdb524f42f0ce19b169a8071123a4797=1632063090; kw_token=CCVJGWS9R1G");
        headerMap.put("Referer","http://www.kuwo.cn/search/mv?key=%E8%AE%B8%E5%B7%8D");
        headerMap.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.82 Safari/537.36");
        request.headerMap(headerMap,true);
        HttpResponse execute = request.execute();
        System.out.println(execute.body());

        Document document = Jsoup.connect("http://www.kuwo.cn/mvplay/" + JSON.parseObject(execute.body(), BaseResponse.class).data.mvlist.get(0).getId()).get();
        System.out.println(document);
    }


    static class BaseResponse implements Serializable {

        private Integer code;
        private Page data;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public Page getData() {
            return data;
        }

        public void setData(Page data) {
            this.data = data;
        }
    }

    static class MvItem implements Serializable{

        private String artist;
        private Integer artistid;
        private Integer id;
        private String name;

        public MvItem(){

        }
        public MvItem(String artist, Integer artistid, Integer id, String name) {
            this.artist = artist;
            this.artistid = artistid;
            this.id = id;
            this.name = name;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public Integer getArtistid() {
            return artistid;
        }

        public void setArtistid(Integer artistid) {
            this.artistid = artistid;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MvItem{" +
                    "artist='" + artist + '\'' +
                    ", artistid=" + artistid +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class Page{
        private String total;
        private List<MvItem> mvlist;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public List<MvItem> getMvlist() {
            return mvlist;
        }

        public void setMvlist(List<MvItem> mvlist) {
            this.mvlist = mvlist;
        }
    }
}
