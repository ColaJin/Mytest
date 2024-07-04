package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2562. 找出数组的串联值
 * @Date:2024/2/2
 */
public class FindTheArrayConcVal {
    public long findTheArrayConcVal(int[] nums) {
        long rs = 0l;
        int len = nums.length;
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            StringBuffer temp = new StringBuffer();
            if (i == j) {
                temp.append(nums[i]);
            }else {
                temp.append(nums[i]).append(nums[j]);
            }
            rs += Long.valueOf(temp.toString());
            i++;
            j--;
        }
        return rs;
    }
}
