package leetcode.array.easy;

public class SortedSquares {

    public static void main(String[] args) {
        int[] nums = new int[]{-7,-3,-2};
        int[] rs = sortedSquaresByTwoPointBetter(nums);
        for (int i : rs) {
            System.out.print(i + "\t");
        }
    }

    //双指针，判断负数和正数的分界位置，分别移动指针
    //index作为新数组的索引，每次都要++
    //如果比较结束之后i<0或者j=N的时候需要把其余元素一直放到新数组中
    //while(i>=0 || j < N)

    public static int[] sortedSquaresByTwoPoint(int[] nums) {
        int u0 = 0;
        int l0 = 0;
        //结果数组存放
        int[] rs = new int[nums.length];
        //遍历数组并计算平方
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                l0++;
            }
        }
        //大于0的位置是小于0的位置的下一位
        u0 = l0;
        l0--;
        int index = 0;
        while (l0 >= 0 || u0 < nums.length) {
            if (u0 == nums.length) {
                rs[index] = nums[l0] * nums[l0];
                l0--;
            } else if (l0 < 0) {
                rs[index] = nums[u0] * nums[u0];
                u0++;
            } else if (nums[u0] * nums[u0] > nums[l0] * nums[l0]) {
                rs[index] = nums[l0] * nums[l0];
                l0--;
            } else {
                rs[index] = nums[u0] * nums[u0];
                u0++;
            }
            index++;
        }

        return rs;
    }


    //双指针，收尾指针指向位置的平方较大的数放在最后一位
    //维持一个索引每次都要--
    //前面大i++，后面大j--
    //条件i<=j
    public static int[] sortedSquaresByTwoPointBetter(int[] nums) {
        int[] rs = new int[nums.length];
        int index = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                rs[index] = nums[j] * nums[j];
                j--;
            } else {
                rs[index] = nums[i] * nums[i];
                i++;
            }
            index--;
        }
        return rs;
    }

}
