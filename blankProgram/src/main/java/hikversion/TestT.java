package hikversion;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:jinyandong
 * @description:测试泛型
 * @Date:2023/8/24
 */
public class TestT {
    public static void main(String[] args) {
        List<? super Number> numbers = new ArrayList<Number>();
        numbers.add(1);
        // 报错：返回Object类型非Number
        // Number item = numbers.get(0);

        // 支持多态
        // 编译错误
        // List<Animal> animals = new ArrayList<Dog>();
        // List<Dog> list = new ArrayList<Dog>();
        // 报错
        // sum(list);
        // 协变：上界通配符限定上界Animal，只读不写
        List<? extends Animal> dogs = new ArrayList<Dog>();
        dogs.add(null);
        Animal animal = dogs.get(0);
        // 编译错误
        // dogs.add(new Dog());
        // dogs.add(new Cat());
        List<Dog> list = new ArrayList<Dog>();
        sum(list);

        // 逆变：下界通配符限定下界是Dog,只写不读
        List<? super Dog> animals = new ArrayList<Animal>();
        animals.add(new BigDog());
        animals.add(new SmallDog());

        // 不变
        List<Animal> animalList = new ArrayList<Animal>();

        List<Integer> src = Arrays.asList(1, 2, 3, 4, 5);
        List<Number> dest = new ArrayList<Number>();
        copy1(src,dest);
        copy2(src,dest);

    }
    static void copy1(List<Integer> src,List<Number> dest){
        for (Integer obj : src) {
            dest.add(obj);
        }
    }

    static <T> void copy2(List<? extends T> src, List<? super T> dest){
        for (T obj : src) {
            dest.add(obj);
        }
    }

    /*public static long sum(List<Animal> animals){
        return animals.size();
    }*/
    public static long sum(List<? extends Animal> animals) {
        return animals.size();
    }
}

class BigDog extends Dog {
}
class SmallDog extends Dog {
}

class Cat {
}

class Dog extends Animal {
}

class Animal {
}
