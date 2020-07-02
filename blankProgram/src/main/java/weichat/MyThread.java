package blankProgram.src.main.java.weichat;

public class MyThread {

    public int a = 0;
    public void increase() {
        a++;
    }

    public static void main(String[] args) {
        final MyThread myThread = new MyThread();
        for (int i = 0;i< 10;i++){
            //10个线程都要执行加1000的操作，值要小于10*1000=10000
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0;j<1000;j++){
                        myThread.increase();
                    }
                }
            }.start();
        }
        System.out.println(myThread.a);
        while(Thread.activeCount() >1) {
            Thread.currentThread().interrupt();
            Thread.yield();
        }
    }

}
