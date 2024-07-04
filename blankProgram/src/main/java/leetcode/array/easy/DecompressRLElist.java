package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1313. 解压缩编码列表
 * @Date:2023/12/5
 */
public class DecompressRLElist {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3};
        int[] rs = decompressRLElist(nums);
        for (int r : rs) {
            System.out.println(r);
        }
    }

    public static int[] decompressRLElist(int[] nums) {
        // 1,2,3,4

        List<Integer> temp = new ArrayList<>();
        int fre = 0;
        for (int i = 0; i < nums.length - 1; ) {
            fre = nums[i];
            for (int j = 0; j < fre; j++) {
                temp.add(nums[i + 1]);
            }
            i += 2;
        }
        int size = temp.size();
        int[] rs = new int[size];
        for (int i = 0; i < size; i++) {
            rs[i] = temp.get(i);
        }
        return rs;
    }
}
