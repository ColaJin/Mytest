package gof23.factory.abstract1;

/**
 * 华为路由器
 */
public class HuaweiRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("启动华为路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为路由器");
    }

    @Override
    public void openWifi() {
        System.out.println("华为路由器打开WIFI");
    }

    @Override
    public void setting() {
        System.out.println("华为路由器设置");
    }
}
