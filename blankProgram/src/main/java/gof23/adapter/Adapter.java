package gof23.adapter;

/**
 * 真正的适配器，需要连接USB，连接网线
 * 1、继承(类适配器，单继承)
 */
public class Adapter extends Adaptee implements NetToUsb {
    //继承父类，调用上网方法，实现上网
    @Override
    public void handleRequest() {
        super.request();//可以上网
    }
}
