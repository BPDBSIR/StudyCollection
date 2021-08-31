package cn.xiaoyes.summerstudy.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 同步方法以及同步块
 * 由于我们可以通过private关键字来保证数据对象只能被方法访问，所以我们需要正对方法提出一套机制，这套机制就是
 * synchronized关键字，它包括两种用法，synchronized方法和synchronized块。
 * 同步方法: public synchronized void method(int args){}
 * <p>
 * synchronized方法控制对象的访问，每个对象应该加一把锁，每个synchronized方法都必须获得调用该对象的锁才能执行，否则会线程阻塞
 * 方法一旦执行，就独占该锁，知道该方法返回才释放锁，后面被阻塞的线程才能获得这个锁，继续执行
 * 缺陷：若将一个大的方法声明为synchronized将会影响执行性能以及效率
 * <p>
 * 方法里面需要修改的内容才需要锁，如果锁的太多，则会浪费资源
 *
 *
 * 同步块: synchronized(obj){}
 *
 * obj称之为同步监视器
 *  obj可以是任何对象，但是推荐使用共享资源作为同步监视器
 *  同步对象中五无需指定同步监视器，因为同步方法的同步监视器就是this，就是这个对象本身，或者是class
 *
 * 同步监视器的执行过程
 *  1、第一个线程访问，锁定同步监视器，执行其中的代码
 *  2、第二个线程访问，发现同步监视器被锁定，无法访问
 *  3、第三个线程访问完毕，解锁哦同步监视器
 *  4、第二个线程访问，发现同步监视器没有锁，然后锁定并访问
 */
public class Demo18 {
}

/**
 * 安全的买票
 */
class UnsafeBuyTicket2 {
    public static void main(String[] args) {
        BuyTicket2 station = new BuyTicket2();
        new Thread(station, "苦逼的我").start();
        new Thread(station, "牛逼的你们").start();
        new Thread(station, "可恶的黄牛党").start();
    }
}

class BuyTicket2 implements Runnable {

    // 票
    int ticketNums = 10;

    // 外部停止方式
    boolean flag = true;

    @Override
    public void run() {
        // 买票
        while (flag) {
            buy();
        }
    }

    /**
     * 同步方法
     * 锁的是this
     */
    private synchronized void buy() {
        // 判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        // 模拟延时
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 买票
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }
}


/**
 * 安全的取钱
 */
class UnsafeBank2 {
    public static void main(String[] args) {
        Account2 account = new Account2(1000, "结婚基金");
        Drawing2 drawing1 = new Drawing2(account, 50, "你");
        Drawing2 drawing2 = new Drawing2(account, 50, "GirlFriend");
        drawing1.start();
        drawing2.start();
    }
}

// 账户
class Account2 {
    int money;
    String name;

    public Account2(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 银行
class Drawing2 extends Thread {
    Account2 account;// 账户
    // 取了多少钱
    int drawingMoney;
    // 现在手里有多少钱
    int nowMoney;

    public Drawing2(Account2 account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }

    // 取钱
    // synchronized默认锁的是this
    @Override
    public void run() {
        // 锁的对象就是变化的量 -> 需要增删改的对象
        synchronized (account) {
            // 判断有没有钱
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够了，去不了");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 卡内余额 = 余额 -  你取的前
            account.money = account.money - drawingMoney;
            // 你手里的钱
            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.name + "余额为: " + account.money);
            System.out.println(this.getName() + "手里的钱: " + nowMoney);
        }
    }
}

/**
 * 线程安全的集合
 */
class UnsafeList2 {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (items) {
                    items.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(items.size());
    }
}


