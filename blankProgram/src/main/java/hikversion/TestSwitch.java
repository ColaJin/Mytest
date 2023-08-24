package hikversion;

/**
 * @author:jinyandong
 * @description:测试switch case
 * @Date:2023/8/10
 */
public class TestSwitch {
    public static void main(String[] args) {
        int type = 0;
        switch (type) {
            case 0:
                System.out.println(0);
                // 没有break会都case
                break;
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            case 3:
                System.out.println(3);
            case 4:
                System.out.println(4);
            case 5:
                System.out.println(5);
            case 6:
                System.out.println(6);

        }
    }
}
