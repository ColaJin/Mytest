package leetcode.array.easy;

import java.util.*;

/**
 * @author:jinyandong
 * @description:1046. 最后一块石头的重量
 * @Date:2023/11/27
 */
public class LastStoneWeight {
    public static void main(String[] args) {

    }

    public int lastStoneWeight(int[] stones) {
        // [2,7,4,1,8,1]
        // 最大堆：堆中某个节点的值总是不大于或不小于其父节点的值；完全二叉树
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            if (a > b) {
                maxHeap.offer(a - b);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
