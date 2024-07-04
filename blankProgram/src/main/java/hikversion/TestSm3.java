package hikversion;

/**
 * @author:jinyandong
 * @description:测试Sm3加密
 * @Date:2023/9/8
 */
public class TestSm3 {
    public static void main(String[] args) {
        System.out.println(Sm3Utils.encrypt("Abc123++"));
        String hash = Sm3Utils.encrypt("Abc123++");
        String hash1 = Sm3Utils.encrypt("Abc123+++");
        System.out.println(hash);
        System.out.println(hash1);
        boolean flag = Sm3Utils.verify("Abc123++", hash);
        System.out.println(flag);
        String s = "Zgfv/cNrQu7IQ+kn8ZV9Mg==";
        //String s = "f388ccc7e931d41470bf4fd1ecec3b97c8c794d284525d15dde8ebaa6c6014ec";
    }
}
