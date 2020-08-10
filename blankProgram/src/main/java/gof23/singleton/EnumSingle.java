package gof23.singleton;

import java.lang.reflect.Constructor;

/**
 * 枚举本身也是一个类
 */
public enum  EnumSingle {
    INSTANCE;

    public EnumSingle getInstance() {
        return INSTANCE;
    }
}

//测试是否保证唯一性
class Test {
    public static void main(String[] args) throws Exception {
        //获取对象第一种方式直接.
        EnumSingle instance1 = EnumSingle.INSTANCE;
        EnumSingle instance2 = EnumSingle.INSTANCE;

        //instance1和instance2相同
        System.out.println(instance1);
        System.out.println(instance2);

        //反射不能破坏枚举测试
        //源码存在无参构造方法
//        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(null);
        //使用jad查看class文件反编译成的java文件使用参数注意是int不是Integer
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        //破除私有权限
        declaredConstructor.setAccessible(true);
        EnumSingle instance3 = declaredConstructor.newInstance();

        //产生错误
        System.out.println(instance1);
        System.out.println(instance3);

        //解决后错误提示：反射源码Cannot reflectively create enum objects
    }
}
