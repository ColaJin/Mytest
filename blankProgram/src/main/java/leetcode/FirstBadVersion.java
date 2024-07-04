package leetcode;

/**
 * @author:jinyandong
 * @description:278. 第一个错误的版本
 * @Date:2023/8/28
 */
public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            // 二分查询防止计算溢出
            int mid = left + (right - left) / 2;
            if (mid == 4) {
                // 不清楚是否mid - 1是否是坏版本，所以right = mid而不是mid-1
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
}
