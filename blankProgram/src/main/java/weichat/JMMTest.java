package blankProgram.src.main.java.weichat;

public class JMMTest {
    /**
     * 线程之间通信
     */
    static int a = 0;// 主内存中的共享变量
    static volatile boolean stop = false;// 是否中断线程1标志,
    // volatile修饰stop防止可见性thread2设置stop为true，但是内存中stop还是true，导致thread1继续执行
    //Tread2设置stop=true时，立即将volatile修饰的变量stop=true刷到主内存；
    //Tread1读取stop的值时，会到主内存中读取最新的stop值。

    public static void main(String[] args) {


        new Thread() {
            @Override
            public void run() {
                a=1;// 线程本地内存中操作共享变量a，并将a=1刷新到猪内存中
                while(true) {// 测试用，为了保持线程运行

                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                System.out.println(a);// 线程到主内存中读取变量a
                while(true) {

                }
            }
        }.start();

        /**
         * 一个线程修改volatile变量的值时，该变量的新值会立即刷新到主内存中，这个新值对其他线程来说是立即可见的。
         * 一个线程读取volatile变量的值时，该变量在本地内存中缓存无效，需要到主内存中读取。
         * @param args
         */
        //Thread1
        new Thread() {
            @Override
            public void run() {
                while(!stop) {
                    a++;
                }
            }
        }.start();
        //Thread2
        new Thread() {
            @Override
            public void run() {
                stop = true;
            }
        }.start();

    }
}
