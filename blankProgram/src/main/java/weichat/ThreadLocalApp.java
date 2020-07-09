package weichat;

import java.util.Random;

/**
 * ThreadLocalMap使用ThreadLocal的弱引用作为key，
 * 如果一个ThreadLocal没有外部强引用来引用它，
 * 那么系统 GC 的时候，这个ThreadLocal势必会被回收，
 * 这样一来，ThreadLocalMap中就会出现key为null的Entry，
 * 就没有办法访问这些key为null的Entry的value，
 * 如果当前线程再迟迟不结束的话，这些key为null的Entry的value就会一直存在一条强引用链：
 * Thread Ref -> Thread -> ThreaLocalMap -> Entry -> value永远无法回收，造成内存泄漏。
 * 正确示例：
 */
public class ThreadLocalApp {
    public static final ThreadLocal threadLocal = new ThreadLocal();

    public static void muti2() {
        int i[] = (int[]) threadLocal.get();
        i[1] = i[0] * 2;
        threadLocal.set(i);
    }

    public static void muti3() {
        int i[] = (int[]) threadLocal.get();
        i[2] = i[1] * 3;
        threadLocal.set(i);
    }

    public static void muti5() {
        int i[] = (int[]) threadLocal.get();
        i[3] = i[2] * 5;
        threadLocal.set(i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread() {
                @Override
                public void run() {
                    int start = new Random().nextInt(10);
                    int end[] = {0,0,0,0};
                    end[0] = start;
                    threadLocal.set(end);
                    ThreadLocalApp.muti2();;
                    ThreadLocalApp.muti3();
                    ThreadLocalApp.muti5();
                    System.out.println(end[0]+" "+end[1] + " "+ end[2] + " "+ end[3]);
                    threadLocal.remove();
                }
            }.start();
        }
    }
}
