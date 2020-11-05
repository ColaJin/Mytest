package leetcode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 1, 2, 1, 2, 0};
        int singleNumber = singleNumberViolence(nums);
        System.out.println(singleNumber);
    }

    //存在问题的思路
    public static int singleNumber(int[] nums) {
        //遍历数组，首先设置第一个位置为结果，
        // 从第一个位置开始比较是否和当前相同，是则结果设置为0，否则返回结果
        int rs = 0;

        for (int i = 0; i < nums.length; i++) {
            //每次进来都是需要改变的
            boolean change = false;
            rs = nums[i];
            //j需要从头来
            for (int j = 0; j < nums.length; j++) {
                if (!change) {

                    if (rs == nums[j]) {
                        //找到存在的跳出循环然后重新开始找知道返回唯一的结果
                        change = true;
                        break;
                    } else {
                        change = false;
                    }
                } else {

                }
            }
            //没找到重复的不需要更换结果
            if (!change) {
                return rs;
            }
        }

        //存在前面数字和最后一个是重复的数字5,4,1,2,1,2,5


        return rs;
    }

    //暴力法，时间复杂度(O(n^2))
    public static int singleNumberViolence(int[] nums) {
        int rs = 0;

        for (int i = 0; i < nums.length; i++) {
            rs = nums[i];
            int count = 0;
            //遍历数组，同时统计数组的数字，如果，出现一次那么就返回，否则继续遍历
            for (int j = 0; j < nums.length; j++) {
                if (rs == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return rs;
            }
        }

        //存在前面数字和最后一个是重复的数字5,4,1,2,1,2,5


        return rs;
    }

    //可以使用位运算^异或运算
    //a^b=b^a;所以a^b^a=b^(a^a)=b^0=b唯一的一个数字
    //a^0=a
    //a^a=0
}
