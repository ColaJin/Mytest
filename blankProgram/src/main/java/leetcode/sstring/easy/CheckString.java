package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:2124.检查是否所有A都在B之前
 * @Date:2024/8/23
 */
public class CheckString {
    public boolean checkString(String s) {
        // 找最后出现的a和第一个出现的b比较未知
        if(!s.contains("a")) {
            return true;
        }
        int bPos = 101;
        int aPos = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a'){
                aPos = i;
            }else {
                if (bPos == 101){
                    bPos = i;
                }
            }
        }
        if (aPos < bPos){
            return true;
        }
        return false;
    }
}
