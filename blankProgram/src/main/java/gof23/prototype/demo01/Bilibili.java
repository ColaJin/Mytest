package gof23.prototype.demo01;

import java.util.Date;

/**
 * 客户端：克隆
 * Spring Bean:单例模式，原型模式
 * 原型模式 + 工厂模式===>new <=>原型模式
 */
public class Bilibili {
    public static void main(String[] args) throws CloneNotSupportedException {
        //原型对象
        Date date = new Date();
        Video v1 = new Video("jyd", date);
        Video v2 = (Video) v1.clone();//克隆出来的对象和原来是一模一样的
        System.out.println("v1=>"+v1);
        System.out.println("v2h:"+v2);

        System.out.println("=====================================");
        date.setTime(222222222);
        System.out.println("v1=>"+v1);
        System.out.println("v2h:"+v2);
/*
        //v1克隆v2
        //Video v2 = new Video("jyd", date);

        System.out.println("v2=>"+v2);
        System.out.println("v2=>hash:"+v1.hashCode());

        v2.setName("Clone:jyd");
        System.out.println("v2=>"+v2);
        System.out.println("v2=>hash:"+v1.hashCode());*/

    }
}
