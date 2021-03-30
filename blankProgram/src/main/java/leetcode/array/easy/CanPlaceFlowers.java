package leetcode.array.easy;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowered = new int[]{1, 0, 0, 1, 0, 0};
        int n = 2;
        System.out.println(canPlaceFlowersBetter(flowered, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        //重新copy一个数组然后头尾都是0

        /*if (flowerbed[0] == 0 && n==1){
            return true;

        }*/
        //特殊情况[0] 1 [0,1,0] 1报错啦....不可取

        //统计0的个数，如果是0开头的或者0结尾都要多算一个0
        int count0 = 0;
        //可以放1的个数
        int count1 = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0 && flowerbed[0] == 0) {
                count0++;
            }
            if ((i == flowerbed.length - 1) && (flowerbed[flowerbed.length - 1] == 0)) {
                count0++;
            }
            if (flowerbed[i] == 0) {
                count0++;
            }
            if (flowerbed[i] == 1) {
                count1 += (count0 - 1) / 2;
                //从0开始计算
                count0 = 0;
            }
        }

        //最后0收尾的时候未计算结果需要在加上
        if (count0 > 0) {
            count1 += (count0 - 1) / 2;
        }

        if (count1 >= n) {
            return true;
        }
        return false;
    }

    //跳格子
    public static boolean canPlaceFlowersBetter(int[] flowerbed, int n) {
        //如果当前为1，那么跳过下一个格子(这个格子一定为0)
        //可以种植的格子，当做1,n--
        //如果下一个格子为1那么也不能种植，跳过3个格子
        for (int i = 0; i < flowerbed.length; ) {
            if (flowerbed[i] == 1) {
                i += 2;
                //判断下一位不为1这里flowered[i+1]会越界，需要先判断
            } else if (i == (flowerbed.length - 1) || flowerbed[i + 1] == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        if (n > 0) {
            return false;
        }
        return true;
    }
}
