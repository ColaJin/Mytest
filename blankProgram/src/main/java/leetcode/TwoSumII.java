package leetcode;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = new int[]{-2, 2, 11, 15};
        int target = 9;
        int[] rs = twoSum(numbers, target);
        int[] ints = twoSumByTwoPoint(numbers, target);
        for (int i = 0; i < rs.length; i++) {
//            System.out.println(rs[i]);
            System.out.println(ints[i]);
        }
    }

    //暴力求解
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = 0;
                sum = numbers[i] + numbers[j];
                if (sum == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    break;
                }
            }
        }
        return result;
    }

    //双指针法
    public static int[] twoSumByTwoPoint(int[] numbers, int target) {
        int[] result = new int[]{-1, -1};
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                result[0] = l + 1;
                result[1] = r + 1;
                //直接return
                return result;
            }
        }
        return result;
    }

    //二分查找法
    //可以固定一个数，然后利用二分查找法，在该数的右侧查找
    //TODO

    //使用Hash表,存储当前结点的值和当前结点的坐标+1(从1开始计算位置),计算target-当前是否存在Hash表，返回坐标+1的值
}
