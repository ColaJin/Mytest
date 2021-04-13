package gof23.proxystatic;

//静态代理模式综计：
//真实对象和代理对象都要实现一个接口
//代理对象要代理真实角色

//优点：
//代理对象可以做很多真实对象做不了的是想
//真实对象专注在做自己的事情
public class StaticMarry {
    public static void main(String[] args) {
        //你要结婚
        You you = new You();
        //原操作是你要结婚你自己实现
        //you.happyMarry();
        //现在是婚庆公司帮你实现
        WeddingCompany weddingCompany = new WeddingCompany(you);
    }
}

interface Marry{
    //人间四大喜事
    //久旱逢甘霖
    //他乡遇故知
    //洞房花烛夜
    //金榜题名时
    void happyMarry();
}

class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("你要结婚啦，很开心");
    }
}

//代理角色帮助你结婚
class WeddingCompany implements Marry{

    //代理谁--->目标角色
    private Marry target;

    public WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();

    }

    public void before(){
        System.out.println("婚前，准备");
    }
    public void after(){
        System.out.println("婚后，收钱");
    }

}
