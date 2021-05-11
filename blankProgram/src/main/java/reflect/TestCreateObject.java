package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态创建对象，通过反射
public class TestCreateObject {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        //获得Class对象
        Class c1 = Class.forName("reflect.User");

        //构造一个对象,抛出异常
        //User user = (User)c1.newInstance();//本质调用了类的无参构造
        //System.out.println(user);

        //通过构造器创建对象,抛出异常
        //Constructor constructor = c1.getConstructor(int.class, String.class, int.class);
        //抛出异常
        //User user2 = (User) constructor.newInstance(1, "jyd", 3);
        //System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke：激活的意思
        //(对象  ，方法的值)
        setName.invoke(user3,"jyd");
        System.out.println(user3.getName());

        //通过反射操作属性
        User user4 = (User) c1.newInstance();
        //报错can not access a member of class reflect.User with modifiers "private"
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，需要关闭程序中的安全检测
        name.setAccessible(true);
        name.set(user4,"jyd");
        System.out.println(user4.getName());
    }
}
