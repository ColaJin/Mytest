package leetcode.Array.easy;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {
    public static void main(String[] args) {
        String s = "aa";
        System.out.println(largeGroupPositionsBetter(s));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        //遍历字符串的每个字符，判断是否和后一个元素相同，相同时更新start,不同时更新end,计算end和start的差
        //比较差是否大于等于3，如果等于的话记录start和end的值到List中，同时更新start和end为0
        List<List<Integer>> rs = new ArrayList<>();
        int start = 0;
        int end = 0;
        boolean flag = false;
        for (int i = 0; i < s.length() - 1; i++) {
            //这样会导致start一直改变
            if (!flag && s.charAt(i) == s.charAt(i + 1)) {
                start = i;
                flag = true;
            }

            //存在问题如果说元素全部相同的情况无法比较
            if (flag && s.charAt(i) != s.charAt(i + 1)) {
                end = i;
                //此时
                flag = false;
            }
            if (flag && i + 1 == s.length() - 1) {
                //后面连续数据的长度得大于等于3
                if (s.length() - 1 - start >= 2) {
                    //后面全是连续数字时
                    List<Integer> temp = new ArrayList<>();

                    temp.add(start);
                    temp.add(s.length() - 1);
                    rs.add(temp);
                }

            }
            //3个数之间的位置差距为2，存在问题(存在连续的数字之后一直flage是true)
            if (end - start >= 2) {
                List<Integer> temp = new ArrayList<>();

                temp.add(start);
                temp.add(end);
                rs.add(temp);
                start = 0;
                end = 0;

            }
        }

        return rs;
    }

    //不需要增加标志位置，每次不同时更新start，end即为i
    public static List<List<Integer>> largeGroupPositionsBetter(String s) {
        List<List<Integer>> rs = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(start) == s.charAt(i + 1)) {
                //当前和下一位置相同时
                //存在问题会重复加到temp中baaaaaaa
                /*if (i + 1 - start > 2) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(start);
                    temp.add(i + 1);
                    rs.add(temp);
                }*/
                if ((i + 1) == (s.length() - 1)) {
                    //从0开始到结束连续就会出现问题
                    if (i + 1 - start >= 2) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(start);
                        //i+1最后一位
                        temp.add(i + 1);
                        rs.add(temp);
                    }
                }

            } else {

                //发现不等于的时候才加入到temp，怎么保证start位置不改变呐
                if (i + 1 - start > 2) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(start);
                    //结束位置在i，i+1不一样
                    temp.add(i);
                    rs.add(temp);
                }

                //下一位开始重新计算
                start = i + 1;
            }
        }
        return rs;
    }
}
