package leetcode.array.easy;

import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:3069. 将元素分配到两个数组中 I
 * @Date:2024/8/7
 */
public class ResultArray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 3};
        int[] ints = resultArray(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0;
        int r = 1;
        // 记录每个list后续遍历写入res
        List<Integer> lList = new ArrayList<>();
        List<Integer> rList = new ArrayList<>();

        lList.add(nums[0]);
        rList.add(nums[1]);
        int cur = 2;
        while (cur < n) {
            if (nums[l] > nums[r]) {
                l = cur;

                lList.add(nums[l]);
            } else {
                r = cur;
                rList.add(nums[r]);
            }
            cur++;
        }
        int start = lList.size();
        for (int i = 0; i < lList.size(); i++) {
            res[i] = lList.get(i);
        }
        for (int i = 0; i < rList.size(); i++) {
            res[i + start] = rList.get(i);
        }

        return res;
    }
}
