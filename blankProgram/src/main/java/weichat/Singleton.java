package blankProgram.src.main.java.weichat;

public class Singleton {
    /**
     * 重排之后：
     * ①分配内存空间
     * ②将内存空间的地址赋值给instance
     * ③初始化对象Singleton
     */
    static Singleton instance;
    static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();//创建对象步骤：①分配内存空间②初始化对象Singleton③将内存空间的地址赋值给instance
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        /**
         * 线程A先执行getInstance()方法，当执行完指令②时恰好发生了线程切换，切换到了线程B上；
         * 如果此时线程B也执行getInstance()方法，
         * 那么线程B在执行第一个判断时会发现instance!=null，所以直接返回instance，而此时的instance是没有初始化过的，
         * 如果我们这个时候访问instance的成员变量就可能触发空指针异常。
         */
        for(int i=0;i<10;i++){
            //
            new Thread(){
                @Override
                        public void run(){
                    Singleton.getInstance();
                }
            }.start();
        }


    }
}
