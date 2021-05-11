package reflect;

//测试什么时候会初始化
public class TestInitTime {

    static {
        System.out.println("Main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用
        //Son son = new Son();

        //反射也会产生主动引用
        //Class.forName("reflect.Son");

        //不会产生类的引用
        //父类引用被调用，子类没有引用
        //System.out.println(Son.b);

        //父类子类都不会被引用
        //Son[] array = new Son[8];
        System.out.println(Son.M);
    }
}

class Father {
    static int b = 2;

    static {
        System.out.println("Father类被加载");
    }
}

class Son extends Father {
    static {
        System.out.println("Son类被加载");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;
}
