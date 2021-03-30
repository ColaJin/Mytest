package leetcode.array.easy;

import java.util.*;

public class ThirdMax {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(thirdMaxOneTraverse(nums));
    }

    public static int thirdMax(int[] nums) {
        //去掉重复数字(此处可以取消List直接存入时直接删除重复元素contains不存入)
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        List<Integer> setList = new ArrayList<>();
        for (Integer i : set) {
            setList.add(i);
        }

        Collections.sort(setList);

        if (setList.size() < 3) {
            return setList.get(setList.size() - 1);
        }

        int j = 0;
        for (int i = setList.size() - 1; i > 0; i--) {

            if (j == 2) {
                //返回的是get(i)
                return setList.get(i);
            }
            //先比较后+j
            j++;
        }
        return setList.get(0);
        /*Arrays.sort(nums);

        if (nums.length < 3) {
            return nums[nums.length - 1];
        }

        int j = 0;
        for (int i = nums.length - 1; i > 1; i--) {
            if (nums[i] != nums[i - 1]) {
                j++;
            }
            if (j == 2) {
                return nums[i - 1];
            }
        }
        //存在1,1,2情况会导致返回结果不正确，返回的应该是最大值
        return nums[nums.length-1];
*/
    }

    //Long类型最小值
    public static int thirdMaxOneTraverse(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                //大于最大值全部替换,注意顺序2-3后，1-2后，赋值14
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] > second && nums[i] != first) {
                //判断条件需要增加&& nums[i]!=first否则不更新first直接更新second情况或者使用nums[i]<first
                //大于第二大值时更换第二和第三
                third = second;
                second = nums[i];
            } else if (nums[i] > third && nums[i] != first && nums[i] != second) {
                //大于第三大值时更新第三大值,可以减少判断到nums[i]<second
                third = nums[i];
            }
        }
        //判断第三大值是否被更新过没有返回第一大值
        return (third == Long.MIN_VALUE) ? (int) first : (int) third;

    }


    public static int thirdMaxNoRepeat(int[] nums) {
        Arrays.sort(nums);
        int j = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                j++;
            }
            if (j == 2) {
                return nums[i - 1];
            }
        }
        //存在1,1,2情况会导致返回结果不正确，返回的应该是最大值
        return nums[nums.length - 1];
    }
}
