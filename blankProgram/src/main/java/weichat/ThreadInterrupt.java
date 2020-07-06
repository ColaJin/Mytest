package weichat;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        ThreadInterrurtThread thread = new ThreadInterrurtThread();
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}

class ThreadInterrurtThread extends Thread {
    int i = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("中断异常被捕获了");
                return;
            }
            i++;
        }
    }
}