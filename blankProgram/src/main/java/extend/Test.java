package extend;

public class Test {
    public static void main(String[] args) {
        // is not an enclosing class
        // new extendDemo.Hero();
        /**
         * public class A {
         *     public class B {
         *
         *     }
         * };
         *
         * A a = new A();
         * A.B ab = a.new B();
         */
        extendDemo extendDemo = new extendDemo();
        extend.extendDemo.Hero hero = extendDemo.new Hero();
        hero.name();
    }
}
