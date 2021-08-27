package cn.xiaoyes.summerstudy.thread;

/**
 * 静态代理模式 Thread就用到了静态代理模式
 * 真实对象和代理对象都要实现同一个接口
 * 代理对象要代理真实角色
 * <p>
 * 代理对象可以做很多真实对象做不了的事情
 * 真实对象专注做自己的事情
 */
public class Demo07 {
    public static void main(String[] args) {
        You you = new You();
        WeddingCompany weddingCompany = new WeddingCompany(you);
        weddingCompany.happyMarry();

    }
}

interface Marry {
    void happyMarry();
}

// 真实角色，你去结婚
class You implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("小黑要结婚了");
    }
}

// 代理角色，帮助你结婚
class WeddingCompany implements Marry {

    // 代理谁 => 真实目标角色
    private final Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        // 真实对象-结婚
        this.target.happyMarry();
        after();
    }

    /**
     * 结婚之前
     */
    private void before() {
        System.out.println("结婚之前布置礼堂");
    }

    /**
     * 结婚之后
     */
    private void after() {
        System.out.println("结婚之后收尾款");
    }
}