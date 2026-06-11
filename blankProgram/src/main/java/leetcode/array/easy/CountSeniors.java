package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2678. 老人的数目
 * @Date:2024/8/5
 */
public class CountSeniors {
    public static void main(String[] args) {
        String[] details = new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"};
        System.out.println(countSeniors(details));
    }

    public static int countSeniors(String[] details) {
        int count = 0;
        for (String str : details) {
            String temp = str.substring(11, 13);
            if (Integer.valueOf(temp) > 60) {
                count++;
            }
        }
        return count;
    }
}
