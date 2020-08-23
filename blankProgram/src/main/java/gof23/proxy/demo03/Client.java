package gof23.proxy.demo03;

public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();

        //代理角色
        ProxyInnovationHandler pih = new ProxyInnovationHandler();
        //通过调用程序处理角色来处理我们要调用的接口对象，host报错
        pih.setRent(host);

        Rent proxy = (Rent) pih.getProxy();//这里的proxy是动态生成的我们并没有写
        proxy.rent();
    }
}
