package cn.xiaoyes.summerstudy.aggregate.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 常用方法使用
 */
public class CollectionMethod {

    public static void main(String[] args) {

        List list = new ArrayList();

        /* add 添加 */
        list.add("BPDBSIR");
        list.add(19);// list.add(new Integer(19))
        list.add(99.99);

        System.out.println("list => " + list);

        /* remove 按内容删除 */
//        list.remove("BPDBSIR");
//        System.out.println("list => " + list);

        /* remove 删除索引为1的元素 */
        list.remove(1);
        System.out.println("list => " + list);

        /* contains 查找元素是否存在 */
        boolean contains = list.contains(99.99);
        System.out.println(contains ? "元素存在" : "元素不存在");

        /* size 返回元素的个数 */
        System.out.println("集合长度 => " + list.size());

        /* isEmpty 判断集合是否为空 */
        System.out.println("集合是否为空 => " + list.isEmpty());

        /* clear 清空集合 */
//        list.clear();

        /* addAll 添加多个元素 只要是实现了Collection接口的对象都可以添加 */
        ArrayList<String> books = new ArrayList<>();
        books.add("三国演义");
        books.add("西游记");
        books.add("红楼梦");
        books.add("水浒传");
        list.addAll(books);

        System.out.println("list => " + list);

        /* containsAll 查找多个元素是否都存在 */

        boolean b = list.containsAll(books);
        System.out.println("是否都存在 => " + b);

        /* removeAll 删除多个元素 */

        list.removeAll(books);

        System.out.println("list => " + list);
    }
}
