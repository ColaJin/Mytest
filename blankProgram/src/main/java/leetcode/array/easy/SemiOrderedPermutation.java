package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2717. 半有序排列
 * @Date:2024/8/5
 */
public class SemiOrderedPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,5};
        System.out.println(semiOrderedPermutation(nums));
    }
    public static int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int pos1 = 0;
        int count = 0;
        int posN = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                pos1 = i;
            }
        }
        while (nums[0] != 1) {
            int temp = nums[pos1];
            nums[pos1] = nums[pos1 - 1];
            nums[pos1 - 1] = temp;
            pos1--;
            count++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n){
                posN = i;
            }
        }
        while (nums[n - 1] != n){
            int temp = nums[posN];
            nums[posN] = nums[posN + 1];
            nums[posN + 1] =  temp;
            posN++;
            count++;
        }
        return count;
    }
}
