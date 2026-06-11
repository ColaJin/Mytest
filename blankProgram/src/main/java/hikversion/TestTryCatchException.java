package hikversion;

/**
 * @author:jinyandong
 * @description:测试捕获异常
 * @Date:2025/1/21
 */
public class TestTryCatchException {
    public static void main(String[] args) {
        try {
            throw ClusterUtils.ErrorWithCode("eeee");
        }catch (DacException e1){
            System.out.println("11");
        }catch (Exception e) {
            System.out.println("22");
        }
    }
}
