package interview;

/**
 * 在方法中定义内部类,只在方法内部
 * 可见, 在外部类(及外部类的其它方法中)中都不可见了.
 * 同时, 它有一个特点, 就是方法内的内部类连本方法的成员变量都不可访问,
 * 它只能访问本方法的final型成员.同时另一个需引起注意的是方法内部定义成员,
 * 只允许final修饰或不加修饰符, 其它像static等均不可用
 */
public class FunOuter {
    int out_x = 100;

    public void test() {
        class Inner {
            String inner_x = "x";

            void display() {
                System.out.println(out_x);
            }
        }
        Inner inner = new Inner();
        inner.display();
    }

    public void showStr(String str) {
        // public String str1 = "test Inner";
        // 不可定义, 只允许final修饰
        // static String str4 = "static Str";
        // 不可定义, 只允许final修饰
        String str2 = "test Inner";
        final String str3 = "final Str";
        class InnerTwo {
            public void testPrint() {
                System.out.println(out_x);
                // 可直接访问外部类的变量
                // System.out.println(str); // 不可访问本方法内部的非final变量
                // System.out.println(str2); // 不可访问本方法内部的非final变量
                System.out.println(str3); // 只可访问本方法的final型变量成员
            }
        }
        InnerTwo innerTwo = new InnerTwo();
        innerTwo.testPrint();
    }

    public void use() {
        // Inner innerObj = new Inner();//此时Inner己不可见了
        // System.out.println(Inner.x);//此时Inner己不可见了
    }

    public static void main(String[] args) {
        FunOuter outer = new FunOuter();
        outer.test();
    }
}
