package cn.xiaoyes.summerstudy.io.file;


import java.io.File;

/**
 * 目录操作
 */
public class FileDirectory {
    public static void main(String[] args) {
//        method1();
//        method2();
        method3();
    }

    /**
     * 判断D:\\news1.txt 是否存在 存在就删除
     */
    public static void method1(){
        String filePath = "D:\\news1.txt";
        File file = new File(filePath);
        if (file.exists()){
            if (file.delete()){
                System.out.println(filePath + "删除成功");
            }else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("文件不存在");
        }
    }

    /**
     * 判断D:\\demo 是否存在 存在就删除 否则提示不存在
     */
    public static void method2(){
        String path = "D:\\demo";
        File file = new File(path);
        if (file.exists()){
            if (file.delete()){
                System.out.println(path + "删除成功");
            }else {
                System.out.println(path + "删除失败");
            }
        }else {
            System.out.println(path + "目录不存在");
        }
    }

    /**
     * 判断D:\\abc\\aaa\\bbb 是否存在不存在 则创建
     */
    public static void method3(){
        String path = "D:\\abc\\aaa\\bbb";
        File file = new File(path);
        if (file.exists()){
            System.out.println(path + "已存在");
        }else {
            boolean mkdirs = file.mkdirs();
            if (mkdirs){
                System.out.println(path + "创建成功");
            }else {
                System.out.println(path + "创建失败");
            }
        }
    }
}
