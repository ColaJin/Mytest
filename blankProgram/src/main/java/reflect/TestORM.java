package reflect;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//练习反射操作注解
public class TestORM {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("reflect.People");

        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value值
        TableAno tableAno = (TableAno) c1.getAnnotation(TableAno.class);
        String value = tableAno.value();
        System.out.println(value);

        //获得类指定的注解
        Field name = c1.getDeclaredField("name");
        FieldAno fieldAno = name.getAnnotation(FieldAno.class);
        System.out.println(fieldAno.columnName());
        System.out.println(fieldAno.type());
        System.out.println(fieldAno.length());
    }
}

@TableAno("db_people")
class People{
    @FieldAno(columnName = "db_id",type = "int",length = 10)
    private int id;
    @FieldAno(columnName = "db_age",type = "int",length = 10)
    private int age;
    @FieldAno(columnName = "db_name",type = "varchar",length = 3)
    private String name;

    public People() {
    }

    public People(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableAno{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldAno{
    String columnName();
    String type();
    int length();
}
