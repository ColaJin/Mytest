package lambda;

/**
 * 推导lambda表达式
 */
public class TestLambda {

    //3.静态内部类
    static class Like1 implements ILike {

        @Override
        public void lambda() {
            System.out.println("i like lambda1");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like1();
        like.lambda();

        //4.局部内部类
        class Like2 implements ILike {

            @Override
            public void lambda() {
                System.out.println("i like lambda2");
            }
        }

        like = new Like2();
        like.lambda();

        //5.匿名内部类:没有类的名称，必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        };
        like.lambda();

        //6.lambda
        like = () -> {
            System.out.println("i like lambda4");
        };
        like.lambda();
    }
}

//1.定义一个接口
interface ILike {
    void lambda();
}

//2.实现类
class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("i like lambda0");
    }
}
