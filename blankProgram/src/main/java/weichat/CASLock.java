package weichat;

/**
 * 乐观锁实现实例
 */
public class CASLock {
    public static int money = 2000;

    public static boolean add2(int oldm, int newm) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (money == oldm) {
            money = money + newm;
            return true;
        }
        return false;
    }

    public synchronized static void add1(int newm) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        money = money + newm;
    }

    public static void add(int newm) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        money = money + newm;
    }

    public static void main(String[] args) {
        Thread one = new Thread(){
            @Override
            public void run() {
                //add(5000);
                add1(5000);
                /*while (true) {
                    if (add2(money,5000)) {
                        break;
                    }
                }*/
            }
        };
        Thread two = new Thread() {
            @Override
            public void run() {
                //add(7000);
                add1(7000);
                /*while (true) {
                    if (add2(money,7000)) {
                        break;
                    }
                }*/
            }
        };
        one.start();
        two.start();
        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(money);
    }
}
