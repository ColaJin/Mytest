package gof23.builder.demo;

/**
 * 具体的建造者：工人
 */
public class Worker extends Builder {
    private Product product;

    /*//不是传参的product
    public Worker(Product product) {
        this.product = product;
    }*/

    public Worker() {
        //非常重要，工人创建产品
        product = new Product();
    }

    @Override
    void buildA() {
        product.setBuildA("地基");
        System.out.println("地基");
    }

    @Override
    void buildB() {
        product.setBuildB("钢筋工程");
        System.out.println("钢筋工程");
    }

    @Override
    void buildC() {
        product.setBuildC("铺电线");
        System.out.println("铺电线");
    }

    @Override
    void buildD() {
        product.setBuildD("粉刷");
        System.out.println("粉刷");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
