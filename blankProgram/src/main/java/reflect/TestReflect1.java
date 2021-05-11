package reflect;

//什么叫反射
public class TestReflect1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的对象，需要抛出异常，Class大写
        Class c1 = Class.forName("reflect.User");
        System.out.println(c1);

        Class c2 = Class.forName("reflect.User");
        Class c3 = Class.forName("reflect.User");
        Class c4 = Class.forName("reflect.User");
        Class c5 = Class.forName("reflect.User");

        //一个类在内存中只有一个class对象
        //一个类加载后，类的整个结构都会被封装在Class对象中
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
        System.out.println(c5.hashCode());
    }
}

//实体类pojo,entity
class User{
    private int id;
    private String name;
    private int age;

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
