package leetcode;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 8, 9, 9, 3};
        int rs = robDynamic(nums);
        System.out.println(rs);
    }

    public static int rob(int[] nums) {
        //找两个数分别计算单数位之和双数位之和，返回最大的和值，方法存在问题：存在连着两家都少，例如2,1,1,2
        //暴力法计算所有和最大的利益
        int max = 0;
        /*if (nums.length <= 3) {
            //少于3位情况使用奇偶位判断
            int odd = 0;
            int even = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0) {
                    odd += nums[i];
                } else {
                    even += nums[i];
                }
            }
            return Math.max(odd, even);
        }
        for (int i = 0; i < nums.length; i++) {
            //存在少计算的情况，1位，2位，3位的情况
            int temp = nums[i];
            for (int j = i + 2; j < nums.length; j++) {
            //存在问题，不能连着计算结果
                temp += nums[j];
                if (temp > max) {
                    max = temp;
                }
            }
        }*/

        for (int i = 0; i < nums.length; i++) {
            //存在问题：连着两家都少，例如2,1,1,2(最多是连着两家)
            int temp = nums[i];


            int j = i + 2;
            //=下标越界,一次移动一个位置还是两个位置
            while (j < nums.length) {
                int k = j + 1;
                if (k < nums.length) {
                    //不能加=，尽可能的多用位数
                    if (nums[k] > nums[j]) {
                        //移动三次，存在问题，如果两位两位移动结果大于3位2位的结果2,4,8,9,9,3
                        temp += nums[k];
                        //更新j的位置
                        j = k;
                    } else {
                        //移动两次
                        temp += nums[j];
                    }
                } else {
                    //必须有，不能移动3次时，可以移动2次
                    temp += nums[j];
                }

                j = j + 2;
            }

            if (temp > max) {
                max = temp;
            }
        }

        return max;
    }

    //动态规划 + 滚动数组
    public static int robDynamicAndArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //数组为空时就是最大值就是0，数组一个值时就是本身
        //比较两个值Sn = max(Sn-1,Sn-2,Hn)
        int first = nums[0];
        //每个时刻只需要存储前两间房屋的最高总金额。
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = second;
            //更新前两间房屋的最高金额
            second = Math.max(first + nums[i], second);
            first = temp;

        }
        return second;
    }

    //动态规划
    //子问题
    public static int robDynamic(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //数组为空时就是最大值就是0，数组一个值时就是本身
        //比较两个值Sn = max(Sn-1,Sn-2,Hn)
        //存储最大值数组
        int[] dec = new int[nums.length];
        dec[0] = nums[0];
        dec[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // 偷窃第 k 间房屋，那么就不能偷窃第 k-1间房屋
            // 偷窃总金额为前 k-2 间房屋的最高总金额与第 k 间房屋的金额之和。
            // 不偷窃第 k 间房屋，偷窃总金额为前 k-1 间房屋的最高总金额。
            dec[i] = Math.max(dec[i - 2] + nums[i], dec[i - 1]);
        }
        return dec[nums.length - 1];
    }
}
