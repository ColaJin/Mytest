package gof23.builder.demo2;

import gof23.builder.demo2.Product;

/**
 * 抽象的建造者：方法，建造者创建产品返回Builder
 */
public abstract class Builder {
    abstract Builder buildA(String msg);//汉堡
    abstract Builder buildB(String msg);//可乐
    abstract Builder buildC(String msg);//薯条
    abstract Builder buildD(String msg);//甜点

    //完工：得到产品
    abstract Product getProduct();
}
