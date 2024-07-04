package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2210. 统计数组中峰和谷的数量
 * @Date:2023/12/27
 */
public class CountHillValley {
    public static void main(String[] args) {
        int[] nums = new int[]{57, 57, 57, 57, 57, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 85, 85, 85, 86, 86, 86};
        System.out.println(countHillValley(nums));
    }

    public static int countHillValley(int[] nums) {
        int rs = 0;
        int len = nums.length;
        /*for (int i = 1; i < len - 1; ) {
            int left = len;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] != nums[i]) {
                    left = j;
                    break;
                }
            }
            int right = 0;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] != nums[i]) {
                    right = j;
                    break;
                }
            }

            if (left != len && right != 0 && nums[right] < nums[i] && nums[i] > nums[left]) {
                // 峰
                rs++;
            }

            if (left != len && right != 0 && nums[right] > nums[i] && nums[i] < nums[left]) {
                // 谷
                rs++;
            }
            if (right - i != 1) {
                i += right - i;
            } else {
                i++;
            }

        }*/
        int flag = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                if (flag == 1) {
                    rs++;
                }
                flag = 2;
            }else if (nums[i] < nums[i - 1]){
                if (flag == 2){
                    rs++;
                }
                flag = 1;
            }
        }
        return rs;
    }
}
