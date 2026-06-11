package leetcode.array.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:jinyandong
 * @description:LCR 120.寻找文件副本
 * @Date:2024/8/12
 */
public class FindRepeatDocument {
    public int findRepeatDocument(int[] documents) {
        Set<Integer> temp = new HashSet<>();
        for (int document : documents) {
            if (temp.contains(document)) {
                return document;
            } else {
                temp.add(document);
            }
        }
        return 0;
    }
}
