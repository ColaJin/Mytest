package hikversion;

/**
 * @author:jinyandong
 * @description:测试byte数组是否为空
 * @Date:2023/8/11
 */
public class TestByteArryIsNull {
    public static void main(String[] args) {
        byte[] bytes= new byte[0];
        byte[] bytes1= {0x00};
        System.out.println(isNullOrEmpty(bytes));
        System.out.println(isNullOrEmpty(bytes1));
    }
    public static boolean isNullOrEmpty(byte[] array) {
        return array == null || array.length == 0;
    }
}
