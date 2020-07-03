package controller;

import Projection.TeacherProjection;
import dao.TeacherReposity;
import entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.criteria.Predicate;
import java.util.List;


public class SchoolController {

    @Autowired
    private TeacherReposity teacherReposity;

    @GetMapping("/specification/{subject}")
    public List<Teacher> specification(@PathVariable("subject") String subject) {
        //实例化 Specification 类
        Specification specification = ((root, criteriaQuery, criteriaBuilder) -> {
            // 构建查询条件,现在存在问题equal cannot resolve method
            /*<dependency>
                <groupId>org.eclipse.persistence</groupId>
                <artifactId>javax.persistence</artifactId>
                <version>2.0.0</version>
                </dependency>*/
            Predicate predicate = criteriaBuilder.equal(root.get("subject"), subject);
            // 使用 and 连接上一个条件
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThan(root.get("age"), 21));
            return predicate;
        });
        //使用查询
        return teacherReposity.findAll(specification);
    }

    @GetMapping("/projection")
    public List<TeacherProjection> projection() {
        // 返回指定字段的数据
        List<TeacherProjection> projections = teacherReposity.getTeacherNameAndAge();

        // 打印字段值
        projections.forEach(teacherProjection -> {
            System.out.println(teacherProjection.getAge());
            System.out.println(teacherProjection.getName());
            System.out.println(teacherProjection.getTotal());
        });
        return projections;
    }
}
