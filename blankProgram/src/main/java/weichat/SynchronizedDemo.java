package weichat;

public class SynchronizedDemo {

    // 同步代码块
    public void doSth1(){
        synchronized (SynchronizedDemo.class){
            System.out.println("HelloWorld");
        }
    }
    // 同步方法
    public synchronized void doSth2(){
        System.out.println("HelloWorld");
    }

}
