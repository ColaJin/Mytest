package leetcode;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        int result = removeDuplicatesB(nums);
        System.out.println(result);

    }


    public static int removeDuplicatesB(int[] nums) {
        //记录数组不重复数据的位置
        int j = 1;
        if (nums.length > 1) {
            int val = nums[0];
            for (int i = 1; i < nums.length; i++) {
                //不相等时更换比较的变量
                if (nums[i] != val) {
                    nums[j] = nums[i];
                    val = nums[i];
                    j++;
                }
            }
        }
        return nums.length;
    }
}
