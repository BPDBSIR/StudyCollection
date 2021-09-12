package cn.xiaoyes.summerstudy.simple;

import cn.hutool.http.HttpUtil;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Var;
import com.dtflys.forest.config.ForestConfiguration;
import com.dtflys.forest.http.ForestResponse;

import java.io.InputStream;

public class Test06 {
    public static void main(String[] args) throws Exception {

        String s = "https://www.hetianlab.com/headImg.action?guideImg=0f450aaa-2288-4804-af22-b6b35525bde5.png";
        ForestConfiguration configuration = ForestConfiguration.configuration();
        TestService service = configuration.createInstance(TestService.class);
        ForestResponse<String> resp = service.queryPictureUrl(s);
        InputStream inputStream = resp.getInputStream();

        System.out.println(inputStream);
    }

    interface TestService{

        @Get(value = "${url}")
        ForestResponse<String> queryPictureUrl(@Var("url") String url);
    }
}
