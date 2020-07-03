package dao;

import Projection.TeacherProjection;
import entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherReposity extends JpaRepository<Teacher,Integer>, JpaSpecificationExecutor {
    // 正常使用，只是多加了一个 sort 参数而已
    @Query("select t from Teacher t where t.subject = ?1")
    List<Teacher> getTeachers(String subject, Sort sort);

    //正常使用，只是多加了一个 Pageable 参数而已
    @Query("select t from Teacher t where t.subject = :subject")
    Page<Teacher> getPage(@Param("subject") String subject, Pageable pageable);

    // 返回 TeacherProjection 接口类型的数据
    @Query("select t from Teacher t ")
    List<TeacherProjection> getTeacherNameAndAge();
}
