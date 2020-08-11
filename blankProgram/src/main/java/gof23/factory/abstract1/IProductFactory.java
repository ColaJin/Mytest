package gof23.factory.abstract1;

/**
 * 抽象产品工厂
 */
public interface IProductFactory {
    //生产手机
    IphoneProduct iphoneProduct();

    //生产路由器
    IRouterProduct routerProduct();
}
