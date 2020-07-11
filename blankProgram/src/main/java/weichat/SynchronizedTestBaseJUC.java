package weichat;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基于JUC的优化示例
 * JUC就是java.util .concurrent工具包的简称
 * 一个计数器的优化，我们分别用Synchronized，ReentrantLock，Atomic三种不同的方式来实现一个计数器
 * 在并发量高，循环次数多的情况，可重入锁的效率高于Synchronized，但最终Atomic性能最好。
 */
public class SynchronizedTestBaseJUC {
    public static int threadNum = 100;
    public static int loopTimes = 10000000;

    public static void userSyn() {
        //线程数
        Syn syn = new Syn();
        Thread[] threads = new Thread[threadNum];
        //记录运行时间
        long l = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < loopTimes; j++) {
//                        syn.increaseLock();
                        syn.increase();
                    }
                }
            });
            threads[i].start();
        }
        //等待线程结束
        try {
            for (int i = 0; i < threadNum; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("userSyn" + "-" + syn + " : " + (System.currentTimeMillis() - l) + "ms");
    }

    public static void useRea(){
        //线程数
        Syn syn = new Syn();
        Thread[] threads = new Thread[threadNum];
        //记录运行时间
        long l = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < loopTimes; j++) {
                        syn.increaseLock();
//                        syn.increase();
                    }
                }
            });
            threads[i].start();
        }
        //等待线程结束
        try {
            for (int i = 0; i < threadNum; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("userRea" + "-" + syn + " : " + (System.currentTimeMillis() - l) + "ms");
    }

    public static void useAto(){
        //线程数
        Syn syn = new Syn();
        Thread[] threads = new Thread[threadNum];
        //记录运行时间
        long l = System.currentTimeMillis();
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < loopTimes; j++) {
                        Syn.ai.incrementAndGet();
                    }
                }
            });
            threads[i].start();
        }
        //等待线程结束
        try {
            for (int i = 0; i < threadNum; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("useAto" + "-" + syn + " : " + (System.currentTimeMillis() - l) + "ms");
    }

    public static void main(String[] args) {
        SynchronizedTestBaseJUC.userSyn();
        SynchronizedTestBaseJUC.useRea();
        SynchronizedTestBaseJUC.useAto();
    }

}

class Syn {
    private int count = 0;
    public final static AtomicInteger ai = new AtomicInteger(0);

    private Lock lock = new ReentrantLock();

    public synchronized void increase() {
        count++;
    }

    public void increaseLock() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
