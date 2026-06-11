package hikversion.controller;

/**
 * @author:jinyandong
 * @description:反射
 * @Date:2024/7/29
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greet() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
}
