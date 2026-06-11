package leetcode.sstring.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:412. Fizz Buzz
 * @Date:2024/8/12
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> rs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 3 == 0 && (i + 1) % 5 == 0) {
                rs.add("FizzBuzz");
            } else if ((i + 1) % 3 == 0) {
                rs.add("Fizz");
            } else if ((i + 1) % 5 == 0) {
                rs.add("Buzz");
            } else {
                rs.add(String.valueOf(i + 1));
            }
        }
        return rs;
    }

}
