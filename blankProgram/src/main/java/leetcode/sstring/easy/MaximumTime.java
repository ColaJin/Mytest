package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1736.替换隐藏数字得到的最晚时间
 * @Date:2024/8/15
 */
public class MaximumTime {
    public String maximumTime(String time) {
        char hh = time.charAt(0);
        char hl = time.charAt(1);
        char sh = time.charAt(3);
        char sl = time.charAt(4);
        StringBuffer sb = new StringBuffer();
        if (hh == '?') {
            // 需要判断hl
            if (hl == '?') {
                sb.append('2');
            } else {
                if (hl <= '3') {
                    sb.append('2');
                } else {
                    sb.append('1');
                }
            }
        } else {
            sb.append(hh);
        }
        if (hl == '?') {
            if (hh == '?') {
                sb.append(3);
            } else {
                if (hh <= '1') {
                    sb.append('9');
                } else {
                    sb.append('3');
                }
            }
        } else {
            sb.append(hl);
        }
        sb.append(":");
        if (sh == '?') {
            sb.append('5');
        } else {
            sb.append(sh);
        }

        if (sl == '?') {
            sb.append('9');
        } else {
            sb.append(sl);
        }

        return sb.toString();
    }
}
