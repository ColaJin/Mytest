package annotation;

import java.lang.annotation.*;

//测试元注解
//,ElementType.TYPE没有时报错
//@MyAnnotation
public class Test02 {

    @MyAnnotation
    public void testAnnotation(){

    }
}

//定义一个注解，不能是public一个类中只能有一个public的类
@Target(value = {ElementType.METHOD,ElementType.TYPE})

//自定义注解的范围都设置为RUNTIME，表示我们的注解在什么地方有效，runtime>class>source
@Retention(RetentionPolicy.RUNTIME)

//是否将我们的注解生成在javadoc中
@Documented

//子类可以继承父类的注解
@Inherited
@interface MyAnnotation {

}
