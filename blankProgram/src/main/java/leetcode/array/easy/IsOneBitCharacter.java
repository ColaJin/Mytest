package leetcode.array.easy;

public class IsOneBitCharacter {
    public static void main(String[] args) {
        int[] bits = new int[]{0};
        System.out.println(isOneBitCharacterByGreedy(bits));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        boolean rs = false;
        //遍历数组，每次判断此时位置是否是1，1的时候i+2,0的时候i+1
        //当i=数组长度时返回true
        int i = 0;
        //可以优化while循环
        for (; i < bits.length; ) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                //最后一位i是0的情况满足条件返回true
                if (i == bits.length - 1) {
                    return true;
                }
                //否则i++
                i += 1;
            }
        }
        //上面循环条件修改为bits.length-1就满足要求
        /*//判断不出来因为都是等于数组的情况返回
        if (i == bits.length) {
            return true;
        }*/

        return rs;
    }

    //贪心：从倒数第二位开始根据最后一位0和倒数第二位0之间1的个数进行判断，如果奇数个false，偶数个为true
    public static boolean isOneBitCharacterByGreedy(int[] bits) {
        int count = 0;
        //优化可以使用while循环初始i为bits.length - 2条件为i >= 0 && bits[i] > 0此时i--，return (bits.length-i)%2==0
        for (int i = bits.length - 2; i >= 0; i--) {
            if (i >= 0 && bits[i] > 0) {
                count++;
            } else if (i >= 0 && bits[i] == 0) {
                break;
            }
        }
        return count % 2 == 0 ? true : false;

    }

}
