package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author:jinyandong
 * @description:LCR 159.库存管理II
 * @Date:2024/8/12
 */
public class AnventoryManagement {
    public int[] inventoryManagement(int[] stock, int cnt) {
        Arrays.sort(stock);
        return Arrays.copyOfRange(stock, 0, cnt);
    }
}
