package gof23;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 懒汉式单例
 * 构造器私有
 * 单线程下没有问题
 * 多线程下加锁
 * 双重检测锁加原子性操作
 */
public class LayMan {

    //解决反射创建两个对象破坏DCL懒汉单例模式问题：红绿灯方式
    private static boolean jyd = false;

    //解决反射破坏DCL懒汉式单例,通过无参构造器
    private LayMan() {
        synchronized (LayMan.class) {
            if (jyd == false) {
                jyd = true;
            } else {
                throw new RuntimeException("不要试图使用反射破坏异常");
            }
        }
        System.out.println(Thread.currentThread().getName() + "ok");
    }

    //加上volatile避免指令重排
    private volatile static LayMan layMan;

    //双重检测锁模式的懒汉单例  DCL懒汉式
    private static LayMan getInstance() {
        if (layMan == null) {
            synchronized (LayMan.class) {

                if (layMan == null) {
                    layMan = new LayMan();//不是一个原子操作
                    /**
                     * 1、分配内存空间
                     * 2、执行构造方法，初始化对象
                     * 3、把对象指向这个空间
                     *
                     * 执行操作希望是123
                     * 执行操作可能出现情况132
                     * 132  A线程  A线程不存在问题，但是如果此时出现线程B
                     *      B线程  B线程认为此时lazyMan不为null，此时lazyMan还没有完成构造
                     */
                }
            }
        }
        return layMan;
    }

    //反射：任何关键词都是不安全的
    public static void main(String[] args) throws Exception {
//        LayMan instance = LayMan.getInstance();
        /*//正常情况下两个对象相等，使用反射破坏单例
        LayMan instance1 = LayMan.getInstance();*/
        //空参构造器
        Constructor<LayMan> declaredConstructor = LayMan.class.getDeclaredConstructor(null);
        //.setAccessible()暴力方法,无视私有构造器private volatile static LayMan layMan;
        declaredConstructor.setAccessible(true);

        Field jyd = LayMan.class.getDeclaredField("jyd");
        jyd.setAccessible(true);

        //通过反射创建对象
        LayMan instance2 = declaredConstructor.newInstance();
        LayMan instance = declaredConstructor.newInstance();

        jyd.set(instance,false);

        //按照单例模式instance和instance2应该是同一个值，反射破坏DCL懒汉式单例
        System.out.println(instance);
        System.out.println(instance2);
    }
}
