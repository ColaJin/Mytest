package interview;

/**
 * 内部静态类Person只在类StaticTest 范围内可见, 若在其它类中引用或初始化, 均是错误的.
 */
public class StaticTest {
    private static String name = "woobo";
    private String num = "X001";

    // static nested Class
    static class Person {
        private String address = "China";
        public String mail = "kongbowoo@yahoo.com.cn";//内部类公有成员

        public void display() {
            //System.out.println(num);//不能直接访问外部类的非静态成员
            System.out.println(name);//只能直接访问外部类的静态成员
            System.out.println("Inner " + address);//访问本内部类成员。
        }
    }

    public void printInfo() {
        Person person = new Person();
        person.display(); // 可以访问内部类的方法

        //System.out.println(mail);//不可直接访问
        //System.out.println(address);//不可直接访问

        System.out.println(person.address);//可以访问内部类的私有成员
        System.out.println(person.mail);//可以访问内部类的公有成员

    }

    public static void main(String[] args) {
        StaticTest staticTest = new StaticTest();
        staticTest.printInfo();
    }
}
