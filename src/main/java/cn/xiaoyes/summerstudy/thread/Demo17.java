package cn.xiaoyes.summerstudy.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 三大不安全案例
 */
public class Demo17 {

}

/**
 * 不安全的买票
 * 线程不安全 有-1
 */
class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();
        new Thread(station, "苦逼的我").start();
        new Thread(station, "牛逼的你们").start();
        new Thread(station, "可恶的黄牛党").start();
    }
}

class BuyTicket implements Runnable {

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

    private void buy() {
        // 判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        // 模拟延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 买票
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }
}


/**
 * 不安全的取钱
 * 两个人去银行取钱，账户
 */
class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚基金");
        Drawing drawing1 = new Drawing(account, 50, "你");
        Drawing drawing2 = new Drawing(account, 50, "GirlFriend");
        drawing1.start();
        drawing2.start();

    }
}

// 账户
class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 银行
class Drawing extends Thread {
    Account account;// 账户
    // 取了多少钱
    int drawingMoney;
    // 现在手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }

    // 取钱
    @Override
    public void run() {
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


/**
 * 线程不安全的集合
 */
class UnsafeList {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> items.add(Thread.currentThread().getName())).start();
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(items.size());
    }
}