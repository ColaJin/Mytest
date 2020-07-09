package weichat;

public class DeadLock {
    public static Integer i1 = 2000;
    public static Integer i2 = 3000;

    public static synchronized Integer getI2() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i2;
    }

    public static void main(String[] args) {
        Thread one = new Thread() {
            @Override
            public void run() {
                synchronized (i1) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (i2) {
                        System.out.println(i1+i2);
                    }
                }
            }
        };
        one.start();
        Thread two = new Thread() {
            @Override
            public void run() {
                synchronized (i2) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (i1) {
                        System.out.println(i1+i2);
                    }
                }
            }
        };
        two.start();
    }
}
