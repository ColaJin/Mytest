package interview;

/**
 * 在外部类中定义内部类,内部类Inner及InnterTwo只在类Outer的作用域内是可知的
 */
class Outer {
    int outer_x = 100;

    private class InnerOne {
        // 私有的内部类
        public int inner_y = 10;
        private int inner_z = 9;
        int inner_m = 5;

        public void display() {
            System.out.println("display outer_x:" + outer_x);
        }

        private void display2() {
            System.out.println("display outer_x:" + outer_x);
        }
    }

    public InnerOne getInnerOne() {
        // 即使是对外公开的方法,外部类也无法调用
        return new InnerOne();
    }

    // 内部类
    class InnerTwo {
        InnerOne innerx = getInnerOne();// 可以访问

        public void show() {
            // System.out.println(inner_y); // 不可直接访问Innter的y成员
            // System.out.println(Inner.inner_y);   // 不可直接访问Inner的任何成员和方法
            innerx.display();// 可以访问
            innerx.display2();// 可以访问
            System.out.println(innerx.inner_y);// 可以访问
            System.out.println(innerx.inner_z);// 可以访问
            System.out.println(innerx.inner_m);// 可以访问
        }
    }

    void test() {
        InnerOne inner = new InnerOne();// 可以访问
        inner.display();
        inner.display2();
        // System.out.println("Inner y:" + inner_y); // 不能访问内部内变量
        System.out.println("Inner y:" + inner.inner_y);// 可以访问
        System.out.println("Inner z:" + inner.inner_z);// 可以访问
        System.out.println("Inner m:" + inner.inner_m);// 可以访问

        InnerTwo innerTwo = new InnerTwo();
        innerTwo.show();
    }
}

public class TestOuter {
    public static void main(String args[]) {
        Outer outer = new Outer();
        // Outer.Inner a=outer.getInner();
        // Inner类是私有的,外部类不能访问, 如果Inner类是public ,则可以.
        outer.test();
    }
}
