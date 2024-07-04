package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:1299. 将每个元素替换为右侧最大元素
 * @Date:2023/12/5
 */
public class ReplaceElements {
    public static void main(String[] args) {
        int[] arr = new int[]{17,18,5,4,6,1};
    }
    public static int[] replaceElements(int[] arr) {
        int len = arr.length;
        int[] rs = new int[len];
        for (int i = 0; i < arr.length; i++) {
            int tempMax = 0;
            for (int j = i + 1; j < arr.length; j++) {
                tempMax = Math.max(arr[j], tempMax);
            }
            rs[i] = tempMax;
        }
        rs[len - 1] = -1;
        return rs;
    }
    // 从右向左找最大赋值即可
}
