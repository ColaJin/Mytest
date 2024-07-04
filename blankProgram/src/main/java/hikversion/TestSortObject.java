package hikversion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author:jinyandong
 * @description:测试排序对象
 * @Date:2024/1/18
 */
public class TestSortObject {
    public static void main(String[] args) {
        List<TabulationDto> needSort = new ArrayList<>();
        TabulationDto t1 =new TabulationDto();
        t1.setKey("shebeihuqu");
        t1.setLabel("设备获取");
        t1.setOrder(2);
        TabulationDto t2 =new TabulationDto();
        t2.setKey("远程");
        t2.setLabel("远程");
        t2.setOrder(1);
        needSort.add(t1);
        needSort.add(t2);
        // Collections.sort(needSort); // 调用sort()方法进行排序
        needSort.sort((x, y) -> Integer.compare(x.getOrder(), y.getOrder()));
        for (TabulationDto tabulationDto : needSort) {
            System.out.println(tabulationDto.getLabel());
        }

    }
}
