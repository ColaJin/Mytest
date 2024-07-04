package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author:jinyandong
 * @description:1051. 高度检查器
 * @Date:2023/11/27
 */
public class HeightChecker {
    public static void main(String[] args) {

    }
    public int heightChecker(int[] heights) {
        List<Integer> temp = new ArrayList<>();
        for (int height : heights) {
            temp.add(height);
        }
        Collections.sort(temp);
        int rs = 0;
        int index = 0;
        for (int height : heights) {
            if (height != temp.get(index)){
                rs++;
            }
            index++;
        }
        return rs;

        // 也可以采用数组copy的方式
    }
}

