package cn.xiaoyes.summerstudy.thread;

/**
 * (跑的在慢也不要停下脚步)
 * 龟兔赛跑
 * 1、首先来个赛道距离，然后要离重点越来越近
 * 2、判断比赛是否结束
 * 3、打印出胜利者
 * 4、龟兔赛跑开始
 * 5、故事中是乌龟赢的，兔子需要睡觉，所以我们来模拟兔子睡觉
 * 6、终于，乌龟赢得比赛
 */
public class Demo05 {
    public static void main(String[] args) {
        Race race = new Race();
        Thread rabbit = new Thread(race,"兔子");
        Thread turtle = new Thread(race, "乌龟");
        rabbit.start();
        turtle.start();
    }
}

// 模拟龟兔赛跑
class Race implements Runnable {

    /**
     * 胜利者
     */
    private static String winner;


    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            // 模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0){
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 判断 比赛是否结束
            boolean flag = gameOver(i);
            if (flag) {
                // 比赛结束
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    /**
     * 判断是否完成比赛
     *
     * @return
     */
    private boolean gameOver(int steps) {
        if (winner != null) {
            System.out.println("已经存在胜利者了!");// 比赛结束
            return true;
        }
        if (steps >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("Winner is " + winner);
            return true;
        }
        return false;
    }
}