package gof23.proxy.demo02;

public class Client {
    public static void main(String[] args) {
        //未使用代理
        UserServiceImpl userService = new UserServiceImpl();
        userService.add();
        //使用代理
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);
        proxy.add();
    }
}
