package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:LCR 006.两数之和II-输入有序数组
 * @Date:2024/8/9
 */
public class TwoSumLCR006 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }else if (numbers[i] + numbers[j] > target){
                    break;
                }
            }
        }
        return res;
    }
}
