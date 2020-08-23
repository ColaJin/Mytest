package gof23.proxy.demo04;

import gof23.proxy.demo02.UserService;
import gof23.proxy.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();
        //代理角色
        ProxyInnovationHandler pih = new ProxyInnovationHandler();
        //通过调用程序处理角色来处理我们要调用的接口对象，host报错
        pih.setTarget(userService);

        UserService proxy = (UserService) pih.getProxy();//这里的proxy是动态生成的我们并没有写
        proxy.add();
    }
}
