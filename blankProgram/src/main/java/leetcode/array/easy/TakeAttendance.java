package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:LCR 173.点名
 * @Date:2024/8/12
 */
public class TakeAttendance {
    public int takeAttendance(int[] records) {
        for (int i = 0; i < records.length; i++) {
            if (records[i] != i) {
                return i;
            }
        }
        return records.length;
    }
}
