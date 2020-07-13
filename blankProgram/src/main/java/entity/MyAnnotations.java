package entity;

import java.lang.annotation.Annotation;

/**
 * 接口需要继承Annotation否则@Repeatable(MyAnnotations.class)出问题
 */
public interface MyAnnotations extends Annotation {

}
