package interview;

import java.util.ArrayList;
import java.util.List;

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}

/**
 * 编译器可以支持向上转型，但不支持向下转型
 * 上界的list只能get，不能add（确切地说不能add出除null之外的对象，包括Object）
 *
 * 下界的list只能add，不能get
 */
public class CovariantArrays {
    public static void main(String[] args) {
        //上界
        List<? extends Fruit> flistTop = new ArrayList<Apple>();
        flistTop.add(null);
        //add Fruit对象会报错
        //flist.add(new Fruit());
        Fruit fruit1 = flistTop.get(0);

        //下界
        List<? super Apple> flistBottem = new ArrayList<Apple>();
        flistBottem.add(new Apple());
        flistBottem.add(new Jonathan());
        //get Apple对象会报错
        //Apple apple = flistBottem.get(0);
    }
}
