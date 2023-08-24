package hikversion;

import java.math.BigDecimal;

/**
 * @author:jinyandong
 * @description:测试long计算百分比
 * @Date:2023/5/18
 */
public class TestLongPercent {
    public static void main(String[] args) {
        Long count = 20L;
        Long total = 20000L;

        BigDecimal currentCount = new BigDecimal(count);
        BigDecimal totalCount = new BigDecimal(total);
        BigDecimal divide = currentCount.divide(totalCount, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println( divide.multiply(new BigDecimal(100)).longValue());
    }
}
