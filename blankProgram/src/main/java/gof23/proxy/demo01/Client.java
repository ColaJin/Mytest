package gof23.proxy.demo01;

public class Client {
    public static void main(String[] args) {
        /*//正常租房子情况
        Host host = new Host();
        host.rent();*/

        //房东要租房子
        Host host = new Host();
        //代理帮房东租房子，代理一般会有一些附属操作
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
