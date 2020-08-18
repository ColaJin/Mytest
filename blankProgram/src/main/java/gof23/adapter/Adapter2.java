package gof23.adapter;

/**
 * 真正的适配器，需要连接USB，连接网线
 * 2、组合(对象适配器：常用)
 */
public class Adapter2 extends Adaptee implements NetToUsb {

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    //继承父类，调用上网方法，实现上网
    @Override
    public void handleRequest() {
        adaptee.request();//可以上网
    }
}
