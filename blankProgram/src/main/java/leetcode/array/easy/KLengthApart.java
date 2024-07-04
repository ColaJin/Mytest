package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1437. 是否所有 1 都至少相隔 k 个元素
 * @Date:2023/12/11
 */
public class KLengthApart {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,1,0,1};
        int k = 2;
        boolean b = kLengthApart(nums, k);
        System.out.println(b);
    }

    public static boolean kLengthApart(int[] nums, int k) {
        boolean rs = true;
        /*int apart = 0;
        boolean temp = false;
        for (int num : nums) {
            if (num == 1){
                temp = true;
            }
            if (temp){
                apart++;
                if (apart >=k){
                    apart =0;
                }else {
                    return false;
                }
            }

        }*/
        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (start != -1) {
                    if (i - start <= k) {
                        return false;
                    }else {
                        start = i;
                    }
                } else {
                    start = i;
                }
            }
        }
        return rs;
    }
}
