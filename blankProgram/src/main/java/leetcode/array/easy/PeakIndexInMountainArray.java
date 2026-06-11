package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:LCR 069.山脉数组的峰顶索引
 * @Date:2024/8/12
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] < arr[i + 1] && arr[i + 1] > arr[i + 2]) {
                return i + 1;
            }
        }
        return 0;
    }
}
