package gof23.factory.method;

public class Consumer {
    public static void main(String[] args) {

        Car car1 = new WuLingFactory().getCar();
        Car car2 = new TeslaFactory().getCar();

        car1.name();
        car2.name();

        Car car3 = new MobaiFactory().getCar();
        car3.name();
    }
}
