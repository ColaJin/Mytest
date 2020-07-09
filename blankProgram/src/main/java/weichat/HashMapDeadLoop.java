package weichat;

import java.util.HashMap;

/**
 * HashMap死循环示例
 * HashMap死循环产生的线程栈
 * 在jar所在文件目录下执行java -cp ThreadState.jar test.ThreadState
 * windows下执行jps查看进程号
 * 执行 jstack 进程号查看线程状态
 */
public class HashMapDeadLoop {
    private HashMap hashMap = new HashMap();

    public HashMapDeadLoop() {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    hashMap.put(new Integer(i),i);
                }
                System.out.println("t1 over");
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    hashMap.put(new Integer(i),i);
                }
                System.out.println("t2 over");
            }
        };

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new HashMapDeadLoop();
        }
        System.out.println("end");
    }
}
