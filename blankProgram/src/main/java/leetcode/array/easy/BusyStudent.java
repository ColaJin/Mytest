package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1450. 在既定时间做作业的学生人数
 * @Date:2023/12/12
 */
public class BusyStudent {
    public static void main(String[] args) {
        int[] startTime = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] endTime = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10};
        int queryTime = 5;
        int rs = busyStudent(startTime, endTime, queryTime);
        System.out.println(rs);
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int rs = 0;
        int len = startTime.length;
        for (int i = 0; i < len; i++) {
            boolean isAdd = false;
            if (queryTime == endTime[i] || queryTime == startTime[i]) {
                rs++;
                isAdd = true;
            }
            for (int j = startTime[i]; j < endTime[i]; j++) {
                if (j > queryTime) {
                    break;
                }
                if (j == queryTime) {
                    if (!isAdd) {
                        rs++;
                    }
                }
            }
        }
        return rs;
    }
}
