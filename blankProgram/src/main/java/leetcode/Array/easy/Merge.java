package leetcode.Array.easy;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;
        mergeNoSpace(nums1, m, nums2, n);
        for (int i = 0; i < m + n; i++) {


            System.out.println(nums1[i]);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //可以优化，使用System.arrayCopy，注意原是nums2，把nums2copy到nums1上
        /**
         * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
         * 代码解释:
         * 　　Object src : 原数组
         *    int srcPos : 从元数据的起始位置开始
         * 　　Object dest : 目标数组
         * 　　int destPos : 目标数组的开始起始位置
         * 　　int length  : 要copy的数组的长度
         */

        System.arraycopy(nums2, 0, nums1, m, n);
    }

    //直接比较大小（使用空间存储nums1），需要注意nums1和nums2不等长的情况

    public static void mergeStrighten(int[] nums1, int m, int[] nums2, int n) {
        //使用额外空间存储nums1，这种赋值方法，会使nums3跟着nums1一直变化
        /*int[] nums3 = nums1;*/
        int[] nums3 = new int[m];
        System.arraycopy(nums1, 0, nums3, 0, m);
        //从0开始指针，遍历nums3和nums2和nums1
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        while ((n3 < m) && (n2 < n)) {
            if (nums3[n3] < nums2[n2]) {

                nums1[n1] = nums3[n3];
                n3++;
            } else {
                nums1[n1] = nums2[n2];
                n2++;
            }
            n1++;
        }
        //不等长的情况操作
        if (n3 < m) {
            //nums3长，从n1所在位置，copy到nums1的n1+n2的位置开始，copy的长度是m+n-(n1+n2)
            System.arraycopy(nums3, n3, nums1, n3 + n2, m + n - n3 - n2);
        }
        if (n2 < n) {
            System.arraycopy(nums2, n2, nums1, n3 + n2, m + n - n3 - n2);
        }

    }

    //从后往前比较大小（不需要使用格外空间），
    // 需要注意最后需要考虑nums2的前面的所有数字都大于nums1的所有数字的情况
    public static void mergeNoSpace(int[] nums1, int m, int[] nums2, int n) {
        //比较最后两位大小，大的放到nums1的最后一位
        int q = m + n - 1;
        int n1 = m - 1;
        int n2 = n - 1;
        //条件是>=0否则会少一位判断
        while (n1 >= 0 && n2 >= 0) {
            if (nums1[n1] < nums2[n2]) {
                nums1[q] = nums2[n2];
                n2--;
            } else {
                nums1[q] = nums1[n1];
                n1--;
            }
            q--;
        }
        //不需要循环
        /*while (n2 > 0) {

        }*/
        //需要把n2的都要赋值一下哈，长度是n2+1
        System.arraycopy(nums2, 0, nums1, 0, n2 + 1);

        /*while (n1>0) {
            //不需要操作
        }*/

    }
}
