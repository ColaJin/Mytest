package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1629. 按键持续时间最长的键
 * @Date:2023/12/18
 */
public class SlowestKey {
    public static void main(String[] args) {
        int[] releaseTimes = new int[]{12,23,36,46,62};
        String keysPressed = "spuda";
        char c = slowestKey(releaseTimes, keysPressed);
        System.out.println(c);
    }
    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        char rs = keysPressed.charAt(0);
        int max = releaseTimes[0];
        int last = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int push = releaseTimes[i] - last;
            if (push >= max) {
                char temp = keysPressed.charAt(i);
                if (push == max) {
                    if (rs < temp) {
                        rs = temp;
                    }
                }else {
                    rs = temp;
                }
                max = push;
            }
            last = releaseTimes[i];
        }
        return rs;
    }
}
