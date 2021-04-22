package annotation;

import java.util.ArrayList;
import java.util.List;

//什么是注解
@SuppressWarnings("all")
public class Test01 extends Object {
    //默认继承Object
    //Thread--->Runnable  @FunctionalInterface @Deprecated


    //@Override 重写的注解,不能改变方法tostring:Error:(14, 5) java: 方法不会覆盖或实现超类型的方法
    @Override
    public String toString() {
        return super.toString();
    }

    //@Deprecated 不推荐程序使用，但是可以使用，或者存在更好的方式
    @Deprecated
    public static void testDeprected(){
        System.out.println("@Deprecated");
    }

    //也可以放在类的上面

    public void testSuppressWarning(){
        //不加@SuppressWarnings("all")会警告未被使用
        List list = new ArrayList();
        System.out.println("@SuppressWarnings(\"all\")");
    }

    public static void main(String[] args) {
        testDeprected();
    }
}
