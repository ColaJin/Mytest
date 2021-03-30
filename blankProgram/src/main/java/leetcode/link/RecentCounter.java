package leetcode.link;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> queue = new LinkedList<Integer>();

    public RecentCounter() {

    }

    public int ping(int t) {
        //必须先放入数组，否则peek的时候队列会变空，导致出现空指针异常问题
        queue.add(t);
        if (!queue.isEmpty()) {
            //判断队列的顶部是否是t-3000，需要先放入数组数据，最新放入的数据不满足条件直接跳出while，解决空指针
            while (queue.peek() < t - 3000){
                queue.poll();
            }
        }

        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        recentCounter.ping(642);     // requests = [1]，范围是 [-2999,1]，返回 1
        recentCounter.ping(1849);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
        recentCounter.ping(4921);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        recentCounter.ping(5936);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
        recentCounter.ping(5957);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
    }
}
