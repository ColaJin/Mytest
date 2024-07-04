package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1431. 拥有最多糖果的孩子
 * @Date:2023/12/11
 */
public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> rs = new ArrayList<>();
        int max = 0;
        for (int candy : candies) {
            if (candy > max){
                max = candy;
            }
        }
        for (int candy : candies) {
            if (candy + extraCandies >= max){
                rs.add(true);
            }else {
                rs.add(false);
            }
        }
        return rs;
    }
}
