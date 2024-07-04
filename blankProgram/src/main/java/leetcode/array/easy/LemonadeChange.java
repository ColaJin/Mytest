package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:860. 柠檬水找零
 * @Date:2023/8/29
 */
public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        // 两个数量记录5元和10元个数返回
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {

                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {

                if (five > 0 && ten > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = new int[]{5, 5, 5, 10, 20};
        //int[] bills = new int[]{5, 5, 10, 10, 20};
        System.out.println(lemonadeChange(bills));
    }
}
