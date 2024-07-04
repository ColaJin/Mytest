package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1413. 逐步求和得到正数的最小值
 * @Date:2023/12/11
 */
public class MinStartValue {
    public static void main(String[] args) {
        int[] nums = new int[]{-3, 2, -3, 4, 2};
        int i = minStartValue(nums);
        System.out.println(i);
    }

    public static int minStartValue(int[] nums) {
        int rs = 1;
        int temp = rs;
        while (true) {
            boolean cant = false;
            for (int num : nums) {
                temp += num;
                if (temp < 1) {
                    cant = true;
                    break;
                }
            }
            if (cant) {
                rs++;
                temp = rs;
            } else {
                break;
            }
        }
        return rs;
    }
}
