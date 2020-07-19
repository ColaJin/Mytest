package entity;

import java.lang.annotation.*;

/**
 * 接口需要继承Annotation否则@Repeatable(MyAnnotations.class)出问题
 * 使用@interface不能extends
 * 需要加上@Inherited否则运行报错Error:(8, 1) java: 可重复注释类型 (entity.MyAnnotation) 是 @Inherited, 而包含注释类型 (entity.MyAnnotations) 则不是
 */
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations{
    MyAnnotation[] value();
}

