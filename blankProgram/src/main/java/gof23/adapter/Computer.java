package gof23.adapter;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 客户端类：想上网，插不上网线
 */
public class Computer {

    //电脑需要连接上转换器才可以上网
    public void net(NetToUsb adapter) {
        //上网的具体实现，找一个转接头
        adapter.handleRequest();
    }

    public static void main(String[] args) {
        //电脑，适配器，网线
        Computer computer = new Computer();//电脑
        Adaptee adaptee = new Adaptee();//网线
       /* //类适配器
       Adapter adapter = new Adapter();//转接器

        computer.net(adapter);*/
        //对象适配器
        Adapter2 adapter = new Adapter2(adaptee);//转接器
        computer.net(adapter);
    }
}
