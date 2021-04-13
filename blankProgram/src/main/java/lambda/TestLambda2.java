package lambda;

public class TestLambda2 {
    public static void main(String[] args) {

        ILove love = (int a, int b) -> {
            System.out.println("i love " + a);
            System.out.println("i love " + b);
        };

        love.Love(4,4);

        //简化：参数类型(全部简化)
        love = (a,b) -> {
            System.out.println("i love " + a);
            System.out.println("i love " + b);
        };
        love.Love(5,5);

        //简化：括号(多参数必须加括号)
        love = (a, b) -> {
            System.out.println("i love " + a);
            System.out.println("i love " + b);
        };
        love.Love(6,6);

        //简化：花括号(只有一句语句时)
        love = (a,b) ->
                System.out.println("i love " + a);
        //只能有一句话
        //System.out.println("i love " + b);
        love.Love(7,7);

        //总结：lamba表达式只能有一行代码的情况下才能简化成为一行，否则就用代码块包裹
        //前提是接口未函数式接口
        //多个参数可以去掉参数类型，但是要去都去
    }
}

interface ILove {
    void Love(int a, int b);
}

