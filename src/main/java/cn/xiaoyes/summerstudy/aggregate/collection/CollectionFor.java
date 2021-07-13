package cn.xiaoyes.summerstudy.aggregate.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 增强for循环遍历集合
 */
public class CollectionFor {
    public static void main(String[] args) {


        List<CollectionIterator.Book> data = new ArrayList<>();
        data.add(new CollectionIterator.Book("三国演义", "罗贯中", 99.99));
        data.add(new CollectionIterator.Book("西游记", "吴承恩", 89.99));
        data.add(new CollectionIterator.Book("水浒传", "施耐庵", 100.99));
        data.add(new CollectionIterator.Book("红楼梦", "曹雪芹", 79.99));

        for (CollectionIterator.Book book : data) {

            System.out.println(book);
        }
    }

}
