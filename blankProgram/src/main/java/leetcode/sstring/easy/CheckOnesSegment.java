package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1784.检查二进制字符串字段
 * @Date:2024/8/15
 */
public class CheckOnesSegment {
    public boolean checkOnesSegment(String s) {
        boolean flag = false;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                if (!flag) {
                    count++;
                    if (count > 2){
                       return false;
                    }
                }
                flag = true;
            }else {
                flag = false;
            }
        }
        return true;
    }
}
