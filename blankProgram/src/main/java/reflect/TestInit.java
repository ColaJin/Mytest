package reflect;

public class TestInit {
    public static void main(String[] args) {
        A a = new A();
        //不可以使用a.m但是可以运行，结果是100
        System.out.println(A.m);
    }
}

class A{
    static {
        System.out.println("A类静态代码块被初始化");
        m = 300;
    }

    static int m = 100;

    public A() {
        System.out.println("A类的无参构造初始化");
    }
}

