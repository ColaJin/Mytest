package leetcode.array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:2465. 不同的平均值数目
 * @Date:2024/1/25
 */
public class DistinctAverages {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        Set<Double> ave = new HashSet<>();
        while (i < j) {
            double temp = (double)(nums[i]+nums[j])/2;
            ave.add(temp);
            i++;
            j--;
        }
        return ave.size();
    }
}
