package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestRunTimeClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("reflect.User");

        //获取类名
        System.out.println(c1.getName());//获取包名+类名
        System.out.println(c1.getSimpleName());//类名

        System.out.println("===============================================================");

        User user = new User();
        c1 = user.getClass();
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        System.out.println("===============================================================");

        //获得类的属性
        Field[] fields = c1.getFields();//只能找到public属性
        for (Field field : fields) {
            System.out.println("field：" + field);
        }

        System.out.println("================================================================");
        fields = c1.getDeclaredFields();//找到全部属性
        for (Field field : fields) {
            System.out.println("declaredField：" + field);
        }

        System.out.println("=============================");
        //获得指定属性的值,抛出异常NoSuchFieldException: name
        //System.out.println("getField获得User指定name属性"+c1.getField("name"));
        System.out.println("getDeclaredField获得User指定name属性" + c1.getDeclaredField("name"));

        System.out.println("===============================================================");

        //获得类方法
        Method[] methods = c1.getMethods();//获得本类和父类的全部public方法
        for (Method method : methods) {
            System.out.println("getMethods：" + method);
        }

        methods = c1.getDeclaredMethods();//获得本类的全部方法
        for (Method method : methods) {
            System.out.println("getDeclaredMethods：" + method);
        }

        System.out.println("===============================================================");
        //获取指定方法,抛出异常,没有方法时报错.NoSuchMethodException，重载(需要参数)
        Method getName = c1.getMethod("getName",null);
        Method setName = c1.getMethod("setName",String.class);

        System.out.println(getName);
        System.out.println(setName);

        System.out.println("===============================================================");
        //获得构造器
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        //获得指定构造器
        Constructor declaredConstructor = c1.getDeclaredConstructor(int.class, String.class, int.class);

        System.out.println("指定构造器："+declaredConstructor);
    }
}
