package leetcode.Array.easy;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        int majorityElement = majorityElement(nums);
        System.out.println(majorityElement);
        int r = majorityElementByRandom(nums);
        System.out.println(r);
    }

    public static int majorityElement(int[] nums) {
        int rs = -1;
        //思路：遍历数组然后统计相同的数字，然后比较count大小然后交换为最大的数字
        //map存储数组的值和出现在数组中的次数
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (map.containsKey(nums[i])) {
                count = map.get(nums[i]) + 1;
            }
            map.put(nums[i], count);
        }


        //遍历map然后找到最大的map的value返回key值
        /*Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            //entrySet集合的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }*/

        //上面是单纯的遍历可以修改为实现获取最大值对应的key
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        /*
        //找到value最小或者key最小
        Collection<Integer> c = map.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        obj[0];*/

        /*return test(map);*/

        return majorityEntry.getKey();
    }

    /**
     * 比较返回map中的最大值或最小值对应的key值
     *
     * @param map
     * @return
     */
    public static int test(Map<Integer, Integer> map) {
        //不能使用==null
        if (map.isEmpty()) {
            return -1;
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

            /**
             * 参数：
             *        o - 要比较的对象。
             * 返回：
             *         负整数、零或正整数，根据此对象是小于、等于还是大于指定对象。
             *         返回正数代表o1排在o2后面，返回负数表示o1排在o2前面
             */
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                //升序排列
                return (o1.getValue() - o2.getValue());

                //降序排列
//                return (o2.getValue() - o1.getValue());

            }
        });
        //返回较小的值对应的key
//        return list.get(0).getKey();

        //返回较大的值对应的key
        return list.get(list.size() - 1).getKey();
    }

    //TODO:

    // 排序方法：数组排序下标n/2向下取整的下标对应的值？？？需要解释

    //随机化：给定下标对应的数字很可能是众数，随机挑选一个下标，检查是否为众数(超过n/2个下标被众数占用)，是就返回，否则继续随机挑选
    public static int majorityElementByRandom(int[] nums) {
        Random random = new Random();
        /*//最大值取nums.length
        int max = nums.length;
        int min = 0;*/
        //超过n/2个下标被众数占用
        int majorityCount = nums.length / 2;
        while (true) {
            int randomIndex = getRandomIndex(random, nums.length, 0);
            //大于
            if (isMajor(nums, nums[randomIndex]) > majorityCount) {
                //返回众数，不是元素个数
                return nums[randomIndex];
            }
        }
    }

    //随机化一个下标，返回int
    public static int getRandomIndex(Random rand, int max, int min) {
        return rand.nextInt(max - min) + min;
    }

    //计算元素个数
    public static int isMajor(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }


    // 分治法：首先递归成子问题都是长度为1的数组
    // 长度为1的子数组唯一的树显然是众数，否则分开左右两部分递归
    // 递归后判断左右值是否相等，相等返回
    // 不相等时，遍历数组然后统计该数组的个数。返回众数


    //Boyer-Moore投票算法
    // 众数记为1，其他记为-1，全部加起来和大于0
    //候选众数candidate，次数count，candidate开始可以为任何值，count为0
    //count值为0时将nums的元素x赋值给candidate(更换众数的过程)
    //之后判断x与candidate和x相等，计数器count+1，不相等计数器count-1
    //candidate即为众数

}
