package weichat;

public class CreateThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("创建线程");
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("创建线程");
    }
}

