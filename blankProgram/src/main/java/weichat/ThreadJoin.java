package weichat;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        ThreadJoinThread thread = new ThreadJoinThread();
        thread.start();
        thread.join(1);//将主线程加入到子线程后面，不过如果子线程在1好嘛时间内没执行完，则主线程便不再等待它执行完，进入就绪状态，等待cpu调度
        for (int i = 0; i < 30; i++) {
            System.out.println("main线程第" + i + "次执行");
        }
    }
}

class ThreadJoinThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("ThredJoinThread线程第" + i + "次执行");
        }
    }
}
