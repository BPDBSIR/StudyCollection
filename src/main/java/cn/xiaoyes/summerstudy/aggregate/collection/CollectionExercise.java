package cn.xiaoyes.summerstudy.aggregate.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 练习
 * 1.编写3个Dog{name,age}对象 放入ArrayList中赋给List引用
 * 2.用迭代器和增强for两种方式来遍历
 * 3.重写Dog的toString方法 输出name和age
 */
public class CollectionExercise {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("小黑",8));
        dogs.add(new Dog("大黄",10));
        dogs.add(new Dog("小花",6));
        Iterator<Dog> iterator = dogs.iterator();
        System.out.println("迭代器输出");
        while (iterator.hasNext()){
            Dog next = iterator.next();
            System.out.println(next);
        }
        System.out.println("增强for输出");
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
        System.out.println("for输出");
        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(dogs.get(i));
        }
        System.out.println("forEach输出");
        dogs.forEach(new Consumer<Dog>() {
            @Override
            public void accept(Dog dog) {
                System.out.println(dog);
            }
        });
    }

    static class Dog{
        private String name;
        private int age;

        public Dog(){

        }
        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "名字 => " + getName() + " 年龄 => " + getAge();
        }
    }
}
