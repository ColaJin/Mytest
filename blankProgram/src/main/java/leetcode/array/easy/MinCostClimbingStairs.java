package leetcode.array.easy;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = new int[]{10, 15, 20, 22};
        System.out.println(minCostClimbingStairsWrongByDynamic(cost));
    }

    //遍历数组，没走一步的时候要看后面两个哪一个位置的花销最小，那么就i+1或者i+2,存在缺陷，10,15,20
    //问题：每次都把cost[0]作为了其实台阶
    public static int minCostClimbingStairsWrong(int[] cost) {
        int minCost = Integer.MAX_VALUE;
        int costSum = 0;
        //暴力法
        for (int i = 0; i < cost.length; i++) {
            int temp = cost[i];
            //外层计算控制循环次数，内层计算最小的花销
            for (int j = i + 1; j < (i + 2) && (i + 2) < cost.length; j++) {
                temp += cost[j];
                if (temp < minCost) {
                    minCost = temp;
                }
            }
        }
        return minCost;
    }

    //动态规划，是要记录最小的花销
    public static int minCostClimbingStairsWrongByDynamicBetter(int[] cost) {
        //之前的开销都为0
        int prev = 0;
        int curr = 0;
        for (int i = 2; i <= cost.length; i++) {
            int temp = Math.min(prev + cost[i - 2], curr + cost[i - 1]);
            prev = curr;
            curr = temp;
        }
        return curr;
    }

    //动态规划，dp[cost.length+2]是要记录最小的花销
    public static int minCostClimbingStairsWrongByDynamic(int[] cost) {

        int[] dp = new int[cost.length + 2];
        //之前的开销都为0
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            int temp = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
            dp[i] = temp;
        }
        return dp[cost.length];
    }
}
