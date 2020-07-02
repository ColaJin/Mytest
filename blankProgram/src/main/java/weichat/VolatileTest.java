package weichat;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

    /**
     * volatile不保证原子性（指一个操作是不可中断的，要全部执行完成，要不就都不执行。）
     * synchronized保证原子性，用synchronized修饰increase()方法。
     * CAS来实现原子性操作，AtomicInteger修饰变量a。
     */
    //public volatile int a = 0;
    public AtomicInteger  a = new AtomicInteger(0);

    public synchronized void increase() {
        //a++;
        a.incrementAndGet();
        //getAndIncrement以原子方式将当前值加 1。返回旧值（即加1前的原始值）即a++，
        //incrementAndGet以原子方式将当前值加 1。返回的是新值（即加1后的值）即++a
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j=0;j<1000;j++) {
                        test.increase();
                    }
                }
            }.start();
        }

        while(Thread.activeCount() >1) {
            // 保证前面的线程都执行完
            Thread.yield();
        }
        System.out.println("test:"+test.a);
    }
}

