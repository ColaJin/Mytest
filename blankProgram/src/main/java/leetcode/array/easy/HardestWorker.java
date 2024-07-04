package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:2432. 处理用时最长的那个任务的员工
 * @Date:2024/1/19
 */
public class HardestWorker {
    public static void main(String[] args) {
        int n = 70;
        // [[36,3],[1,5],[12,8],[25,9],[53,11],[29,12],[52,14]]
        int[][] logs = new int[][]{{36,3},{1,5},{12,8},{25,9},{53,11},{29,12},{52,14}};
        System.out.println(hardestWorker(n, logs));
    }
    public static int hardestWorker(int n, int[][] logs) {
        int maxTime = logs[0][1];
        int rs = logs[0][0];
        int lastTime = logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int person = logs[i][0];
            int time = logs[i][1];
            int temp = time - lastTime;
            if (temp > maxTime) {
                maxTime = temp;
                rs = person;
            }else {
                if (temp == maxTime && rs > person){
                    rs = person;
                }
            }
            // 每次都要变换time
            lastTime = time;
        }
        return rs;
    }
}
