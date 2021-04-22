package jvm;

public class AboutNative {
    public static void main(String[] args) {
        new Thread( ()->{
            System.out.println(Thread.currentThread().getName());
        },"my thread name").start();
    }

    // native:凡是带了native关键字的，说明java的作用域抵达不到，回去调用底层c语言的库
    // 会进入本地方法栈  Native Method Stack
    // 调用本地方法接口  JNI
    // JNI作用：扩展java的使用，融合不同的编程语言为java所用
    // java诞生的时候 C C++横行，想要立足，必须调用C、C++的程序
    // 它在内存区域中专门开辟一块标记区域：Native Method Stack，登记Native方法
    // 在最终执行的时候，通过JNI加载本地方法库中的方法

    // Java程序驱动打印机  Robot() 管理系统  拿到即可 在企业级应用中较为少见
    private native void start0();

    // 调用其他接口：   Socket... WebService ... http
}
