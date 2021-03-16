package leetcode.Array.easy;

public class CheckPossibility {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 8, 1};
        System.out.println(checkPossibilityByChange(nums));
    }

    //必须改变值，不改变值无法确定对后面的数组的影响
    public static boolean checkPossibility(int[] nums) {
        //计算相邻两个数的差如果说<0的数字大于1个的时候就不能
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] < 0) {

                if ((i - 1) >= 0 && nums[i + 1] < nums[i - 1] && (i + 1) != nums.length - 1) {
                    //大数的右侧数字不能小于大数的左侧数据
                    return false;
                }
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPossibilityByGreedy(int[] nums) {
        // i-1 < i ;i > i+1;i-1<=i+1  1 4 3---->1 3 3   1 4 1 2---->1 1 1 2
        // i-1 < i ;i > i+1;i-1>i+1  3 4 1---->3 4 4
        if (nums.length == 1) {
            return true;
        }
        //是否可以改变数字
        boolean flag = nums[0] > nums[1] ? false : true;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                if (flag) {
                    //可以改变数字,包含=的情况,否则变成i-1>i+1的情况位置数字问题
                    if (nums[i - 1] <= nums[i + 1]) {
                        nums[i] = nums[i + 1];
                    } else {
                        nums[i + 1] = nums[i];
                    }

                    flag = false;
                } else {
                    //不可以再次改变数字的时候
                    return false;
                }
            }

        }
        return true;
    }

    //增加一个排序方法：在nums范围内1.n判断nums[i-1]和nums[i]的关系
    //遍历nums然后判断num[i+1]和num[i]的关系，递减时，记录nums[i+1]和nums[i]的值
    //把nums[i+1]的值赋值给n[i]然后去排序算法判断，如果true，返回true
    //否则还原nums[i]为记录的值，把num[i+1]的值也给nums[i]记录的值，返回排序的结果

    public static boolean isSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPossibilityByChange(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];//调整数字变小
                if (isSort(nums)) {
                    return true;
                }
                nums[i] = temp;//调整变小数字不正确，还原变小的数字
                nums[i + 1] = nums[i];//让后面的数字变大
                //不能放到if外如果数字发生改变之后数组还不是非递减那么就不能调整，否则就是可以调整
                return isSort(nums);
            }
        }
        //满足所有的值都是非递减的
        return true;
    }
}
