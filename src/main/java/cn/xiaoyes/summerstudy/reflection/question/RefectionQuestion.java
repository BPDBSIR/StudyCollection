package cn.xiaoyes.summerstudy.reflection.question;

import cn.xiaoyes.summerstudy.reflection.question.domain.Cat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class RefectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 传统的方式 new对象 调用方法
        /*Cat cat = new Cat();
        cat.hi();*/

        // 读取信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classFullPath = properties.getProperty("classfullpath");
        String method = properties.getProperty("method");
        System.out.println("classfullpath =>" + classFullPath + " method => " + method);

        // 加载类 返回Class类型的对象
        Class cls = Class.forName("cn.xiaoyes.summerstudy.reflection.question.domain.Cat");// 参数为全路径类名
        // 创建实例
        Object o = cls.newInstance();
        /*System.out.println(o.getClass());
        // 对象转型
        Cat cat = (Cat) o;
        cat.hi();*/
        // 通过cls得到该加载类中的方法名称为 "hi" 的方法对象(在反射中每个方法都是一个对象)
        Method hi = cls.getMethod(method);
        // 通过hi调用方法 通过方法对象来实现调用方法
        hi.invoke(o);// 传统方法: 对象.方法() 反射机制: 方法.invoke(对象)
    }
}
