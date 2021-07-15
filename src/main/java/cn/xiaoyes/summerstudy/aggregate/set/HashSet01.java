package cn.xiaoyes.summerstudy.aggregate.set;

import java.util.HashSet;

@SuppressWarnings("all")
public class HashSet01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        System.out.println(hashSet.add("Jack"));
        System.out.println(hashSet.add("Andrew"));
        System.out.println(hashSet.add("Jane"));
        System.out.println(hashSet.add("Tom"));
        System.out.println(hashSet.add("Make"));

        // 移除某个元素
        hashSet.remove("Jane");

        hashSet.add(new Dog("TomDog"));// 加入成功
        hashSet.add(new Dog("TomDog"));// 加入成功
        hashSet.add(new Dog("AndrewDog"));


        hashSet.add(new String("Anima"));// 加入成功
        hashSet.add(new String("Anima"));// 未加入成功



        System.out.println("sets => " + hashSet);
    }
}


class Dog{
    private String name;

    public Dog(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}