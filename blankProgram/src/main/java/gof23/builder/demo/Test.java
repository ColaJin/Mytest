package gof23.builder.demo;

public class Test {
    public static void main(String[] args) {
        //指挥
        Director director = new Director();
        //指挥 具体的工人完成 产品，可更换不同的工人实现接口
        Product build = director.build(new Worker());
        System.out.println(build.toString());
    }
}
