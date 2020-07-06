package weichat;

public class ThreadScheduling {

    public static void main(String[] args) throws InterruptedException {
        /*new ThreadScheduleThread("高级", 10).start();
        new ThreadScheduleThread("低级", 1).start();*/

        Thread t1 = new MyCommon();
        Thread t2 = new Thread(new MyDaemon());
        t2.setDaemon(true); // 设置为守护线程

        t2.start();
        t1.start();
    }
}
class ThreadScheduleThread extends Thread {
    public ThreadScheduleThread(String name, int pro) {
        super(name);// 设置线程的名称
        setPriority(pro);// 设置线程的优先级
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(this.getName() + "线程第" + i + "次执行！");
        }
    }
}

class MyCommon extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("线程1第" + i + "次执行！");
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyDaemon implements Runnable {
    @Override
    public void run() {
        for (long i = 0; i < 9999999L; i++) {
            System.out.println("后台线程第" + i + "次执行！");
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
