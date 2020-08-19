package gof23.proxy.demo02;

public class UserServiceProxy implements UserService {

    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        //相当于在UserServiceImpl调用
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    //日志方法
    public void log(String msg) {
        System.out.println("使用啦" + msg + "方法");
    }
}
