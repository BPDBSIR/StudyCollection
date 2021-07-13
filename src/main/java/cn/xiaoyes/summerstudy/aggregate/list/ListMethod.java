package cn.xiaoyes.summerstudy.aggregate.list;

import java.util.ArrayList;
import java.util.List;

/**
 * List常用方法介绍
 */
public class ListMethod {

    @SuppressWarnings("all")
    public static void main(String[] args) {

        List data = new ArrayList();
        data.add("喜羊羊与灰太狼");
        data.add("咯咯历险记");
        data.add("果宝特攻");
        data.add("猪猪侠GGBoy");
        System.out.println(data);
//        void add(int index,Object ele) 在index位置插入ele元素
        data.add(1,"星际精灵蓝多多");
        System.out.println(data);
//        boolean addAll(int index,Object eles) 从index位置开始将ele中的u偶有元素添加进来
        List lis2 = new ArrayList();
        lis2.add("Jack");
        lis2.add("Tom");
        data.addAll(2,lis2);
        System.out.println(data);
//        Object get(int index) 获取指定index位置的元素
        Object o = data.get(1);
        System.out.println(o);
//        int indexOf(Object obj) 返回obj在集合中首次出现的位置
        System.out.println(data.indexOf("果宝特攻"));
//        int lastIndexOf(Object obj) 返回obj在当前集合中最后一次出现的位置
        System.out.println(data.lastIndexOf("Jack"));
//        Object remove(int index) 移除指定index位置的元素 并返回此元素
        data.remove(1);
        System.out.println(data);
//        Object set(int index,Object ele) 设置指定index位置的元素为ele 相当于是替换
        data.set(1,"大角牛");
        System.out.println(data);
//        List subList(int fromIndex,int toIndex) 返回从fromIndex到toIndex位置的子集合
        List list = data.subList(3, data.size());
        System.out.println(list);
    }
}
