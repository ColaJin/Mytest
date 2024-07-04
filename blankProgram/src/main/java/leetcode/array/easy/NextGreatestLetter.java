package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:744. 寻找比目标字母大的最小字母
 * @Date:2023/8/28
 */
public class NextGreatestLetter {

    public static char nextGreatestLetter(char[] letters, char target) {

        char rs = letters[0];
        for (int i = 0; i < letters.length; i++) {
            if ((letters[i] - 'a') > (target - 'a')) {
                rs = letters[i];
                // 直接跳出，最小的那个
                break;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'j'};
        // char target = 'a';
        char target = 'c';
        System.out.println(nextGreatestLetter(letters, target));
    }
}
