package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1385. 两个数组间的距离值
 * @Date:2023/12/8
 */
public class FindTheDistanceValue {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 2, 3};
        int[] arr2 = new int[]{-4, -3, 6, 10, 20, 30};
        int d = 3;
        int rs = findTheDistanceValue(arr1, arr2, d);
        System.out.println(rs);
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int rs = 0;
        // 遍历数组1，且每个元素和数组2比较距离，满足全部满足>2则结果++
        for (int i = 0; i < arr1.length; i++) {
            boolean temp = false;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    temp = true;
                    break;
                }
            }
            if (!temp) {
                rs++;
            }
        }
        return rs;
    }

}
