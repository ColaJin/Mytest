
package hikversion;

import java.util.*;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelSum {
    public static void main(String[] args) {
        String number = "1,2,3,2";
        String[] split = number.split(",");
        Map<Integer,Integer> map = new HashMap<>();
        if (split.length == 1){
            System.out.println(split[0]);
            return;
        }
        for(int i=0;i<split.length;i++) {
            if (map.containsKey(Integer.valueOf(split[i]))){
                Integer count = map.get(Integer.valueOf(split[i]));
                map.put(Integer.valueOf(split[i]),count+1);
            }else {
                map.put(Integer.valueOf(split[i]),1);
            }
        }

        int rs = 0;
        Set<Integer> set=map.keySet();
        for (Integer key : set) {
            Integer value=map.get(key);
            if (value == 1){
                rs +=key;
            }
        }
        System.out.println(rs);
    }
}
