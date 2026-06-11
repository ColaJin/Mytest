package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2960. 统计已测试设备
 * @Date:2024/8/6
 */
public class CountTestedDevices {
    public static void main(String[] args) {
        int[] batteryPercentages = new int[]{0,1,2};
        System.out.println(countTestedDevices(batteryPercentages));
    }

    public static int countTestedDevices(int[] batteryPercentages) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            int temp = batteryPercentages[i] - count;
            if (temp > 0) {
                res++;
                count++;
            }
        }
        return res;
    }
}
