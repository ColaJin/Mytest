package gof23.factory.simple;

/**
 * 简单工厂模式即静态工厂模式
 * 增加一个新的产品，不修改代码做不到
 */
public class CarFactory {
    //方法一：
    public static Car getCar(String car) {
        if (car.equals("五菱")){
            return new WuLing();
        }else if (car.equals("特斯拉")) {
            return new Tesla();
        }else {
            return null;
        }
    }

    //方法二:仍然不满足需求
    public static Car getWuling(){
        return new WuLing();
    }

    public static Car getTesla(){
        return new Tesla();
    }

}
