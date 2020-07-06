package weichat;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private ReentrantLock reentrantLock = new ReentrantLock();

    public int inc = 0;

    public void increase() {
        reentrantLock.lock();
        try {
            inc++;
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReentrantLockTest test = new ReentrantLockTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        test.increase();
                    }
                }
            }.start();
        }

        while (Thread.activeCount() > 1) {
            //保证前面的线程执行完
            Thread.yield();
            System.out.println(test.inc);
        }
    }
}
