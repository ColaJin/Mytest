package blankProgram.src.main.java.weichat;

public class MyThread1 {
    public int a = 0;
    public void increase() {
        a++;
    }

    public static void main(String[] args) {
        final MyThread1 myThread = new MyThread1();
        Thread th = new Thread(){
            @Override
            public void run() {
                for (int j = 0;j<10;j++){
                    myThread.increase();
                }
            }
        };

        th.start();
        System.out.println(myThread.a);
    }
}
