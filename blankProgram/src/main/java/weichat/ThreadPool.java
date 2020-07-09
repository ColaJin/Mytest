package weichat;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 结论：使用线程池，不要new Thread
 *  非线程池的缺点：
 *      每次创建性能消耗大
 *      无序，缺乏管理。容易无限制创建线程，引起OOM(Out Of Memory)和死机
 */
public class ThreadPool {
    /**
     *
     */
    public static int times = 10000;//100,1000,10000

    public static ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1000);
    public static ExecutorService threadPool = new ThreadPoolExecutor(5,
            //corePoolSize线程池中核心线程数
            10,
            60,
            TimeUnit.SECONDS,
            arrayBlockingQueue,
            new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void useThreadPool() {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("说点什么吧。。。");
                }
            });
        }
        threadPool.shutdown();
        while (true) {
            if (threadPool.isTerminated()) {
                long end = System.currentTimeMillis();
                System.out.println(end - start);
                break;
            }
        }
    }

    public static void createNewThread() {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            new Thread(){
                @Override
                public void run() {
                    System.out.println("说点什么吧。。");
                }
            }.start();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void main(String[] args) {
        //createNewThread();
        useThreadPool();
    }
}
