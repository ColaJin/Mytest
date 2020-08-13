package gof23.builder.demo;

/**
 * 指挥：核心，负责指挥构建一个工程，工程如何创建，由它决定
 */
public class Director {
    //指挥工人按照顺序建房子：更新顺序，更改指挥
    public Product build(Builder builder) {
        //指挥一个抽象建造者
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();
        return builder.getProduct();
    }
}
