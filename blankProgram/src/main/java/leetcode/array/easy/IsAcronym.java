package leetcode.array.easy;

import java.util.List;

/**
 * @author:jinyandong
 * @description:2828. 判别首字母缩略词
 * @Date:2024/8/6
 */
public class IsAcronym {
    public boolean isAcronym(List<String> words, String s) {
        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            sb.append(word.charAt(0));
        }
        if (sb.toString().equals(s)){
            return true;
        }
        return false;
    }
}
