package leetcode.sstring.easy;

/**
 * @author:jinyandong
 * @description:1614.括号的最大嵌套深度
 * @Date:2024/8/14
 */
public class MaxDepth {
    public int maxDepth(String s) {
        int max = 0;
        int size = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == '(') {
                ++size;
                max = Math.max(max, size);
            } else if(s.charAt(i) == ')'){
                --size;
            }
        }
        return max;
    }
}
