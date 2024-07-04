package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1184. 公交站间的距离
 * @Date:2023/11/28
 */
public class DistanceBetweenBusStops {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                sum1 += distance[i];
            } else {
                sum2 += distance[i];
            }
        }
        return Math.min(sum1, sum2);
    }

    public static void main(String[] args) {
        int[] distance = new int[]{1, 2, 3, 4};
        int start = 0;
        int des = 2;
        int i = distanceBetweenBusStops(distance, start, des);
        System.out.println(i);
    }
}
