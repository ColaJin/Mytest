package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2239. 找到最接近 0 的数字
 * @Date:2023/12/27
 */
public class FindClosestNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,1,4,8};
        System.out.println(findClosestNumber(nums));
    }
    public static int findClosestNumber(int[] nums) {
        int rs = Integer.MIN_VALUE;
        int pos = Integer.MAX_VALUE;
        for (int num : nums) {
            // pos = Math.min(pos, (Math.abs(num)));
            if (pos > Math.abs(num)) {
                pos = Math.abs(num);
                rs = num;
            } else if (pos == Math.abs(num)) {
                rs = Math.max(rs, num);
            }
        }
        return rs;
    }
}
