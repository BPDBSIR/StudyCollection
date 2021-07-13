package cn.xiaoyes.summerstudy.aggregate.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代器使用
 */
public class CollectionIterator {
    public static void main(String[] args) {


        List<Book> data = new ArrayList<>();
        data.add(new Book("三国演义", "罗贯中", 99.99));
        data.add(new Book("西游记", "吴承恩", 89.99));
        data.add(new Book("水浒传", "施耐庵", 100.99));
        data.add(new Book("红楼梦", "曹雪芹", 79.99));

        Iterator<Book> iterator = data.iterator();

        /* 判单是否有下一个元素 有的话索引+1 */
        while (iterator.hasNext()){
            /* 获取当前元素 */
            System.out.println(iterator.next());
        }
    }

    static class Book {
        private String name;
        private String author;
        private double price;

        public Book() {

        }

        public Book(String name, String author, double price) {
            this.name = name;
            this.author = author;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "书名 => 《" + getName() + "》 作者 => " + getAuthor() + " 价格 => " + getPrice();
        }
    }
}
