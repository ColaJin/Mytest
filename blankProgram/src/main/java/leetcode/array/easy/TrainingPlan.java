package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:LCR 139.训练计划I
 * @Date:2024/8/12
 */
public class TrainingPlan {
    public int[] trainingPlan(int[] actions) {
        int len = actions.length;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (actions[i] % 2 != 0) {
                i++;
                continue;
            }
            if (actions[j] % 2 != 0) {
                // 奇数
                int temp = actions[i];
                actions[i] = actions[j];
                actions[j] = temp;
            } else {
                j--;
            }
        }
        return actions;
    }
}
