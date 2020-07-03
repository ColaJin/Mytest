package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    //rphanRemoval 这个属性只存在两类关系注解中 @OneToOne 和 @OneToMany
    //删除教室的时候，教室里的学生也都被删除了，该属性会有一个级联的效果,现在报错提示can not resolve method orphanRemoval
    //hibernate-jpajavax.persistence和javax.persistence冲突使用前者就没有问题，去除pom文件中的后者依赖
    @OneToMany(mappedBy = "classRoom",orphanRemoval = true)
    @JsonIgnore
    private Set<Student> students;
}
