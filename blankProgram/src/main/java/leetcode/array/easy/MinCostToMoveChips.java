package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1217. 玩筹码
 * @Date:2023/11/29
 */
public class MinCostToMoveChips {
    public static void main(String[] args) {

    }

    public int minCostToMoveChips(int[] position) {
        // 2 2 2 2 3 3
        // 查看最多位置的筹码，转换成奇数位置和偶数位置
        // 其他位置移动计算cost
        int p = 0;
        int q = 0;
        for (int i : position) {
            if (i % 2 == 0){
                p++;
            }else {
                q++;
            }
        }
        return Math.min(p,q);
    }
}
