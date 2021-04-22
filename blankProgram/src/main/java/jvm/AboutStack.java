package jvm;

public class AboutStack {
    public static void main(String[] args) {
        new AboutStack().test();
    }

    public void test(){
        a();
    }

    public void a(){
        test();
    }
}
