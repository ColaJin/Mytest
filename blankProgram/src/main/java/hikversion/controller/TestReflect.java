package hikversion.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author:jinyandong
 * @description:测试反射
 * @Date:2024/7/29
 */
public class TestReflect {
    public static void main(String[] args) {
        try {
            // 获取Person类的Class对象
            Class<?> personClass = Class.forName("hikversion.controller.Person");

            // 使用反射创建Person对象
            Constructor<?> constructor = personClass.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true); // 因为构造函数是公共的，这里可以省略
            Object personObject = constructor.newInstance("John Doe", 30);

            // 获取并访问私有字段
            Field nameField = personClass.getDeclaredField("name");
            nameField.setAccessible(true);
            String name = (String) nameField.get(personObject);
            System.out.println("Name: " + name);

            // 调用公共方法
            Method greetMethod = personClass.getMethod("greet");
            greetMethod.invoke(personObject);

            // 访问并修改私有字段
            Field ageField = personClass.getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.setInt(personObject, 31); // 修改年龄为31
            System.out.println("Updated Age: " + ageField.getInt(personObject));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
