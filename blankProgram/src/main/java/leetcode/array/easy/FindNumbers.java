package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1295. 统计位数为偶数的数字
 * @Date:2023/12/5
 */
public class FindNumbers {
    public static void main(String[] args) {

    }

    public static int findNumbers(int[] nums) {
        int rs = 0;
        for (int num : nums) {
            String temp = String.valueOf(num);
            if (temp.length() % 2 == 0){
                rs++;
            }
        }
        return rs;
    }
}
