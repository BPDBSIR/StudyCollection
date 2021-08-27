package cn.xiaoyes.summerstudy.simple;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "http://www.1ppt.com/moban/jianjie/";
        String[] split = s.split("/");
        System.out.println(Arrays.toString(split));
        System.out.println(split[s.length() -1]);
    }
}
