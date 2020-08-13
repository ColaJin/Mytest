package gof23.builder.demo2;

public class Test {
    public static void main(String[] args) {

        //服务员
        Worker worker = new Worker();
        /*Product product = worker.getProduct();*/
        //链式编程：在原来基础上，可以自由组合，如果不组合也有默认组合
        Product product = worker.buildA("全家桶").buildB("雪碧").
                getProduct();
        System.out.println(product.toString());
    }

}
