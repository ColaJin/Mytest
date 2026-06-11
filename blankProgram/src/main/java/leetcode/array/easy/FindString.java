package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:面试题 10.05.稀疏数组搜索
 * @Date:2024/8/12
 */
public class FindString {
    public int findString(String[] words, String s) {

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }
}
