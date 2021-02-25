package leetcode.Array.easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 2;
        int result = searchInsert(nums, target);
        System.out.println(result);
        int resultMid = searchInsertMid(nums, target);
        System.out.println(resultMid);
    }

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int result = 0;
        //注意边界值如果是比最小值还要小那么直接返回0，比最大值还要大直接返回数组长度
        if (nums.length > 0) {
            if (nums[0] > target) {
                return 0;
            }
            if (nums[length - 1] < target) {
                return length;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                return i;
            }
        }

        return result;
    }

    /**
     * 二分法需要满足有序不重复
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsertMid(int[] nums, int target) {
        int result = 0;
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        /*//注意边界值如果是比最小值还要小那么直接返回0，比最大值还要大直接返回数组长度
        if (nums.length > 0) {
            if (nums[0] > target) {
                return 0;
            }
            if (nums[length - 1] < target) {
                return length;
            }
        }*/
        //<=条件
        while (left <= right) {
            //二分法中间位置计算
            int mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                result = mid;
                right = mid - 1;
            }else {
                //直接返回找到的位置
                return mid;
            }
        }
        //返回left：left作为跳出循环的条件，所以lef可为0或者数组长度
        //返回result需要加上边界值判断部分代码
        return left;
    }
}
