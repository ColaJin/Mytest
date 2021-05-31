package extend;

public class extendDemo {
    public class Hero {
        public String name() {
            return "超级英雄";
        }
    }

    public class SuperMan extends Hero {
        @Override
        public String name() {
            return "超人";
        }

        public Hero hero() {
            return new Hero();
        }
    }

    public class SuperSuperMan extends SuperMan {
        // void和基本数据类型不可以修改返回值类型
        @Override
        public String name() {
            return "超级超级英雄";
        }

        // 引用类型可以修改返回值类型
        @Override
        public SuperMan hero() {
            return new SuperMan();
        }
    }
}
