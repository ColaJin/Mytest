package jvm;

public class Car {
    public static void main(String[] args) {
        //类是模板，对象是具体的
        //Class<Car> carClass = Car.class;

        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        //不同的对象
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());

        System.out.println("====================================");

        Class<? extends Car> car1Class = car1.getClass();
        Class<? extends Car> car2Class = car2.getClass();
        Class<? extends Car> car3Class = car3.getClass();

        /*System.out.println(car1Class);
        System.out.println(car2Class);
        System.out.println(car3Class);*/


        //相同的类
        System.out.println(car1Class.hashCode());
        System.out.println(car2Class.hashCode());
        System.out.println(car3Class.hashCode());

        System.out.println("====================================");
        //abstract类
        ClassLoader classLoader = car1Class.getClassLoader();

        System.out.println(classLoader);//AppClassLoader
        System.out.println(classLoader.getParent());//ExtClassLoader  \jre1.8.0_112\lib\ext
        System.out.println(classLoader.getParent().getParent());//null  1.不存在  2.java程序获取不到(c)

        //\jre1.8.0_112\lib\rt.jar

        System.out.println("====================================");
    }
}
