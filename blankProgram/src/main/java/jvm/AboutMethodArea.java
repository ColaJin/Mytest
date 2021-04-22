package jvm;

public class AboutMethodArea {
    private int a;
    private String name = "jyd";

    public static void main(String[] args) {
        AboutMethodArea aboutMethodArea = new AboutMethodArea();
        aboutMethodArea.a = 1;
        aboutMethodArea.name = "未赋值就直接去方法区获取";
    }
}
