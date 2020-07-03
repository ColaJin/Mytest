package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;


@Getter
@Setter
@Entity(name = "stu")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(length = 100)
    private String name;

    // 这里是定义学生和课桌的一对一的关系,级联保存学生，保存课桌
    @OneToOne(cascade = CascadeType.PERSIST)
// 下面的这个注解用来生成第三张表，来维护学生和课桌的关系
    @JoinTable( name = "stu_desk",joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name="desk_id") )
    private Desk desk;

    @Transient
    private String test;
    private int age;
    private LocalTime onDuty;
    private LocalDate onPosition;
    private LocalDateTime birthdayTime;

    //设置级联更新，在跟新 student 的时候如果更新 classroom , 会级联更新 classroom
    @ManyToOne(cascade = CascadeType.MERGE)
    private ClassRoom classRoom;

    //设置级联删除操作，这是多对对的级联删除，
    // 删除学生的同时会删除关联的老师，如果老师还有关联其他的学生，就会报错，除非老师类也要级联删除，这个删除是要慎重的
    @ManyToMany(cascade = {CascadeType.REMOVE})
    @JoinTable(name="stu_teacher",joinColumns = @JoinColumn(name ="stu_id"),inverseJoinColumns = @JoinColumn(name="teacher_id"))
    private Set<Teacher> teachers;
}
