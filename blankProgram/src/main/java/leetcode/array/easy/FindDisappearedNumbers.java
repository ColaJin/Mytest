package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbersByItselfHash(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> rs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1 && nums[i] != 0) {
                /*if (nums[nums[i] - 1] == nums[i]){
                    //其他没交换时出现问题
                    rs.add(i);
                    continue;
                }*/
                //此时会下标越界需要增加判断
                if (nums[nums[i] - 1] == nums[i]) {
                    //此时不需要交换，重复数字，当前位置置为0
                    nums[i] = 0;
                    continue;
                }
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                //当前位置再次比较是否是i+1
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                rs.add(i + 1);
            }
        }
        return rs;
    }

    //数组充当哈希表
    public static List<Integer> findDisappearedNumbersByItselfHash(int[] nums) {
        List<Integer> rs = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
           /*
           //不需要判断直接存储就OK
           if ((nums[i] % n) != i + 1) {
                if (nums[i] % n == 0) {
                    nums[nums.length - 1] += n;
                } else {
                    nums[nums[i] % n - 1] += n;
                }
            }*/
            /*int x = (nums[i] - 1) % n;
            nums[x] = nums[x] + n;*/

            //这样导致变成负值的重复数字变成正值，返回的值变多

            int x = (Math.abs(nums[i]) - 1);
            if (nums[x] > 0) {
                nums[x] = -nums[x];
            }

        }
        for (int i = 0; i < nums.length; i++) {
            /*if (nums[i] <= n) {
                rs.add(i + 1);
            }*/
            if (nums[i] > 0) {
                rs.add(i + 1);
            }
        }
        return rs;
    }
}
