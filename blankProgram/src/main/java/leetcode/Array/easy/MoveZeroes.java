package leetcode.Array.easy;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        //moveZeroes(nums);
        moveZeroesTwoTraverse(nums);
    }

    public static void moveZeroes(int[] nums) {
        //记录count每个不是0的元素前面0的个数就是最后每个元素需要移动的位置
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                if (count != 0) {
                    nums[i - count] = nums[i];
                    nums[i] = 0;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    //两次遍历：
    public static void moveZeroesTwoTraverse(int[] nums) {
        // 第一次遍历把所有的非0元素移动到前面
        // 第二次遍历把后面数组后面元素变成0
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
