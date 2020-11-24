package leetcode;

public class HammingWeight {
    public static void main(String[] args) {
        int n = -0;
        int rs = hammingWeight(n);
        System.out.println(rs);
    }

    public static int hammingWeight(int n) {
        int rs = 0;
        if (n < 0) {
            //存在最高位为1的负数
            rs = 1;
        }
        for (int i = 0; i <= 31; i++) {
            int temp = 0;
            temp ^= (n & (1 << i));

            if (temp == Math.pow(2, i)) {
                rs++;
            }
            //存在最高位为1的情况，结果都是少1位
        }
        return rs;
    }

    //TODO:
    //优化：循环从0到32，每次把n左移，判断&1的值是否是1，是则rs++
    //优化：循环从0到32，每次&2的n(n从0到32，就是每一位)，判断结果是否为0，否则计数+1，每次1<<1(左移一位)

    //n 和 n - 1 做与运算最后一位1变成0，其他位置不变，知道n为0 while
}
