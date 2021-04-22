package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
public class Test03 {
    //要么加参数，要么下面的参数加上默认值
    //即使定义了默认值也可以显示的定义参数值，如果没有默认值必须给注解赋值
    @MyAnnotation1(name = "jyd")
    public void testMyAnnotaion1() {

    }

    //value为参数值时可以直接写""形式
    @MyAnnotation2("参数为value")
    public void testMyAnnotaion2() {

    }
}

//基本格式
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1 {
    //注解的参数：参数类型  参数名();
    String name() default "";

    int age() default 0;

    int id() default -1;//如果默认值为-1，代表不存在，indexof如果找不到就返回-1，类似indexof

    String[] schools() default {"燕山大学","燕大"};
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    String value();
}