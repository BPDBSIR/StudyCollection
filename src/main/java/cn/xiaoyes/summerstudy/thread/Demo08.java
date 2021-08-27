package cn.xiaoyes.summerstudy.thread;

/**
 * Lambda表达式
 * 避免匿名内部类定义过多
 * 其实质是属于函数式编程的概念
 * 为什么要使用Lambda表达式
 * 避免匿名内部类过多
 * 可以让你的代码看起来更加简洁
 * 去掉了一堆没有意义的代码，只注重于核心逻辑
 * <p>
 * 函数式接口
 * 任何接口，如果只包含唯一一个抽象方法，那么他就是一个函数式接口
 */
public class Demo08 {
    // 静态内部类
    static class Like2 implements ILike {

        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        // 局部内部类
        class Like3 implements ILike {

            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }
        like = new Like3();
        like.lambda();

        // 匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.lambda();

        // 用Lambda简化
        like = () -> {
            System.out.println("I like lambda5");
        };
        // 如果lambda代码体只有一行代码则可以省略{ } 没有参数使用()代表
        like.lambda();

        // lambda参数
        IQueryWrapper queryWrapper = (s, obj) -> System.out.println("I like lambda6" + s + " " + obj);

        queryWrapper.wrapper("123",new Object());
    }


}

// 定义函数式接口
interface ILike {
    void lambda();
}

// 实现类
class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}

interface IQueryWrapper {
    void wrapper(String s, Object obj);
}