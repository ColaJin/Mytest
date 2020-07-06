package weichat;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    public void createOrder() {
        reentrantLock.lock();//获取锁
        try {
            //同步代码
        }finally {

            reentrantLock.unlock();//释放锁
        }
    }
}
