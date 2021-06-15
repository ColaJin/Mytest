package leetcode.hash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class LongestWord {

    public static void main(String[] args) {
        String[] words = new String[]{"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"};
        System.out.println(longestWord(words));
    }

    public static String longestWord(String[] words) {
        String rs = "";
        // 存储前缀
        HashSet<String> set = new HashSet<>();

        for (String str : words) {
            /*if (str.length() > 1) {

            }*/
            // 不能存储前缀，直接存储字符串
            set.add(str);
        }

        int length = 0;
        // 需要考虑长度问题，导致覆盖
        /*for (String str : words) {
            // 包含的是前缀,单个字母的也不存在...
            if (set.contains(str.substring(0, str.length() - 1))) {
                // 长的字母
                if (str.length() > length) {
                    rs = str;
                    length = str.length();
                }
            }
        }*/
        List<String> list = new ArrayList<>();
        // 遍历每个单词判断单词的所有前缀是否都在数组中，要放在if里面做循环哦
        for (String str : words) {
            // 每一个子串都要判断
            int j = 1;
            // 设置找到的标志位
            boolean flag = false;
            // 只有1个长度时，也是true
            if (str.length() ==1)
                flag =true;
            while (j < str.length()) {
                if (set.contains(str.substring(0, j))) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
                j++;
            }

            // ew没找到e但是ewq找到了ew，更换了rs
            if (flag) {
                if (str.length() > length) {
                    rs = str;
                    length = str.length();
                } else if (str.length() == length) {
                    int i = str.compareTo(rs);
                    if (i < 0) {
                        rs = str;
                        length = str.length();
                    }
                }
            }
            /*for (int j = 1; j < str.length(); j++) {
                if (set.contains(str.substring(0, j))) {
                    // 这个时候length被第一次的更新了，导致后续判断也进不来哦
                    if (str.length() > length) {
                        rs = str;
                        length = str.length();
                    }else if (str.length() == length) {
                        int i = str.compareTo(rs);
                        if (i < 0) {
                            rs = str;
                            length = str.length();
                        }
                    }
                } else {
                    // 不包含子串直接跳出循环继续下一个单词的判断
                    break;
                }
            }*/
        }

        // list导致的数据重复存储(包括子串)
        /*if (list.size() > 0) {
            if (list.size() == 1) {
                rs = list.get(0);
            } else {
                // 比较长度
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).length() > length) {
                        rs = list.get(i);
                        length = list.get(i).length();
                    } else if (list.get(i).length() == length) {
                        // 比较字典序,需要重写方法
                        Comparator<String> comparator = new Comparator<String>() {

                            @Override
                            public int compare(String o1, String o2) {
                                return o1.compareTo(o2);
                            }
                        };

                        int i1 = comparator.compare(rs,list.get(i));
                        if (i1 > 0) {
                            rs = list.get(i);
                            length = list.get(i).length();
                        }
                    }
                }
            }
        }*/

        // 存储后的单词比较长度，选择最长的一个或者字典序在前面的

        return rs;
    }

    public static String longestWordCopy(String[] words) {
        String rs = "";
        HashSet<String> set = new HashSet<>();
        for (String str : words) {
            set.add(str);
        }

        for (String str : words) {
            if (str.length() > rs.length() || str.length() == rs.length() && str.compareTo(rs) < 0) {
                boolean flag = true;
                for (int j = 1; j < str.length(); j++) {
                    if (!set.contains(str.substring(0, j))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    rs = str;
                }
            }
        }

        return rs;
    }
}
