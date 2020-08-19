package gof23.proxy.demo02;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        /*//增加功能可使用代理方式
        System.out.println("使用了add方法");*/
        System.out.println("增加一个用户");
    }

    @Override
    public void delete() {
        /*System.out.println("使用了delete方法");*/
        System.out.println("删除一个用户");
    }

    @Override
    public void update() {
        /*System.out.println("使用了update方法");*/
        System.out.println("修改一个用户");
    }

    @Override
    public void query() {
        /*System.out.println("使用了query方法");*/
        System.out.println("查询一个用户");
    }
}
