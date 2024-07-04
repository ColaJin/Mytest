package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2383. 赢得比赛需要的最少训练时长
 * @Date:2024/1/17
 */
public class MinNumberOfHours {
    public static void main(String[] args) {
        int initialEnergy = 5;
        int initialExperience = 3;
        int[] energy = new int[]{1,4};
        int[] experience = new int[]{2,5};
        int i = minNumberOfHours(initialEnergy, initialExperience, energy, experience);
        System.out.println(i);
    }
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int rs = 0;
        int sum = 0;
        for (int i : energy) {
            sum += i;
        }
        if (sum >= initialEnergy) {
            rs += sum - initialEnergy + 1;
        }
        for (int i : experience) {
            if (initialExperience > i) {
                initialExperience += i ;
            } else {
                rs += i - initialExperience + 1;
                initialExperience = initialExperience + i - initialExperience + i + 1;
            }
        }
        return rs;
    }
}
