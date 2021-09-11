package cn.xiaoyes.summerstudy.simple;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.FormBody;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.config.ForestConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTLab {
    public static void main(String[] args) {
        ForestConfiguration configuration = ForestConfiguration.configuration();
        ApiService service = configuration.createInstance(ApiService.class);
        HashMap<String, String> params = new HashMap<>();
        params.put("directId", "CCIDda35-285b-4589-9177-3afeae6fd192");
//         三大章节
        List<Chapter> chapters = service.querySystemChapter(params).message;
        for (Chapter chapter : chapters) {
            System.out.println(chapter);
            params.put("directId", chapter.chapterId);
            List<Chapter> message = service.querySystemChapter(params).message;
            for (Chapter son : message) {
                System.out.println("\r\r==" + son);
                /*Map<String, String> sectionParams = new HashMap<>();
                sectionParams.put("chapterId", son.getChapterId());
                List<Section> sections = service.querySection(sectionParams).message;
                for (Section section : sections) {
                    System.out.println("\r\r====" + section);
                }*/
            }
        }
//
//        System.out.println("asdddddddddddd");
//        params.put("directId", chapter.message.get(0).chapterId);
////         每一章中得所有节
//        List<Chapter> chapters = service.querySystemChapter(params).message;
//        for (Chapter chapter1 : chapters) {
//            System.out.println(chapter1);
//        }
//
//        Map<String, String> sectionParams = new HashMap<>();
//        sectionParams.put("chapterId", chapters.get(0).chapterId);
//        List<Section> sections = service.querySection(sectionParams).message;
////        sections.forEach(System.out::println);
//
//        List<Fragment> fragments = service.queryGuideFragment("", sections.get(0).getEcid()).message;
//        fragments.forEach(System.out::println);
//        System.out.println(service.requestLocation());


    }

    interface ApiService {

        /**
         * 查询章节
         * @param params
         * @return
         */
        @Post(url = "https://www.hetianlab.com/systemManageAction!querySystemChapter.action")
        BaseResponse<Chapter> querySystemChapter(@FormBody Map<String, String> params);

        /**
         * 查询一个章节下所有的小节
         * @param params
         * @return
         */
        @Post(url = "https://www.hetianlab.com/newExp!queryExpByCcid.action")
        BaseResponse<Section> querySection(@FormBody Map<String, String> params);


        /**
         * 详细教程查询
         * @param ceid
         * @param ecid
         * @return
         */
        @Post(url = "https://www.hetianlab.com/newExp!queryGuideByCeid.action")
        BaseResponse<Fragment> queryGuideFragment(@Body("ceid") String ceid, @Body("ecid") String ecid);

        //

        @Get(
                url = "https://www.hetianlab.com/expc.do?w=exp_ass&amp;ec=ECID9d6c0ca797abec2016090509444000001",
                headers = {
                        "Cookie:JSESSIONID=F43B7D30EB61C7DC1F590E75F9297126.jvm4; noticeFlag=1a1d3896; route=7540e1a012ba4a6c76e26d0c63f7fd9c; UM_distinctid=17bc9a035bf170-009967fa1fe38a-4c3e247b-19a100-17bc9a035c0176; CNZZDATA1279677270=190461385-1631174453-%7C1631170029; Hm_lvt_dc527c4bccb13a86a6fc7b678c5f3619=1631175326; Hm_lpvt_dc527c4bccb13a86a6fc7b678c5f3619=1631175917; _pk_id.60.c4fd=434f5bc8a940b3f1.1631175326.1.1631175918.1631175326.; _pk_ses.60.c4fd=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2217bc9a03c590-065055faf5464c8-4c3e247b-1679616-17bc9a03c5b112f%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%2217bc9a03c590-065055faf5464c8-4c3e247b-1679616-17bc9a03c5b112f%22%7D; sajssdk_2015_cross_new_user=1; __qc_wId=230; pgv_pvid=2647904224; uuid=REG-94c2-5037-466f-9375-8d5909698e2f; sf9=1; token=a9c9d8739b4d4d2a9caf3ce0f7a77220; sso-sid=\"JC7Ehdfl0/ppqbZ8b4ZR5PPS1pv5/7R6tAf02mh9Tj89vd9SqVG3P/5njXNVzFf1onJa9z3p8KFk#EzWa7tchUQHDTAc7mTr/j7uLOu8ECtynCGrItHcCauE5i7b2cvPcrtGGaHf9vxV9yswinqJg9Kwm#2khA5/vrraQ/lHo1i54=#\""
                }
        )
        String requestLocation();
    }

    /**
     * 基础响应实体
     *
     * @param <T>
     */
    static class BaseResponse<T> {

        private String result;

        private List<T> message;

        public BaseResponse() {

        }

        public BaseResponse(String result, List<T> message) {
            this.result = result;
            this.message = message;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public List<T> getMessage() {
            return message;
        }

        public void setMessage(List<T> message) {
            this.message = message;
        }
    }

    /**
     * 章节
     */
    static class Chapter {
        private String chapterId;
        private String chapterName;
        private int courseNum;
        private String description;
        private int expNum;
        private boolean newFlag;
        private int orderNo;

        public String getChapterId() {
            return chapterId;
        }

        public void setChapterId(String chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public int getCourseNum() {
            return courseNum;
        }

        public void setCourseNum(int courseNum) {
            this.courseNum = courseNum;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getExpNum() {
            return expNum;
        }

        public void setExpNum(int expNum) {
            this.expNum = expNum;
        }

        public boolean isNewFlag() {
            return newFlag;
        }

        public void setNewFlag(boolean newFlag) {
            this.newFlag = newFlag;
        }

        public int getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(int orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public String toString() {
            return "章节Id :" + getChapterId() + " 名称: " + getChapterName() + " 课程数: " + getCourseNum() + " 描述: " + getDescription() + " 订单号: " + getOrderNo();
        }
    }


    /**
     * 节
     */
    static class Section {
        private String description;
        private String difficulty;
        private String ecid;
        private String ecname;
        private String picture;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(String difficulty) {
            this.difficulty = difficulty;
        }

        public String getEcid() {
            return ecid;
        }

        public void setEcid(String ecid) {
            this.ecid = ecid;
        }

        public String getEcname() {
            return ecname;
        }

        public void setEcname(String ecname) {
            this.ecname = ecname;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        @Override
        public String toString() {
            return "描述: " + getDescription() + " 等级: " + getDifficulty() + " ID: " + getEcid() + " 标题: " + getEcname();
        }
    }

    /**
     * 文章片段
     */
    static class Fragment {
        private String sectionName;
        private String sectionId;
        private int orderNo;
        private String description;
        private String sectionText;
        private String sectionType;

        public String getSectionName() {
            return sectionName;
        }

        public void setSectionName(String sectionName) {
            this.sectionName = sectionName;
        }

        public String getSectionId() {
            return sectionId;
        }

        public void setSectionId(String sectionId) {
            this.sectionId = sectionId;
        }

        public int getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(int orderNo) {
            this.orderNo = orderNo;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSectionText() {
            return sectionText;
        }

        public void setSectionText(String sectionText) {
            this.sectionText = sectionText;
        }

        public String getSectionType() {
            return sectionType;
        }

        public void setSectionType(String sectionType) {
            this.sectionType = sectionType;
        }

        @Override
        public String toString() {
            return "片段: " + getDescription() + " 标题: " + getSectionName() + " 内容: " + getSectionText();
        }
    }
}
