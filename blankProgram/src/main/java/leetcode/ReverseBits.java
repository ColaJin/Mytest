package leetcode;

public class ReverseBits {
    public static void main(String[] args) {
        int i = reverseBits(-3);
        System.out.println(i);
    }

    public static int reverseBits(int n) {

        /*//现在n转换成有符号整数
        if(n<0){

            n = ~n;
            //按位取反+1
            n = n + 1;
        }
        //直接转换成字符串然后转换字符串
        StringBuffer sb = new StringBuffer();
        sb.append(n);
        sb.reverse();
        //字符再转换成int
        Integer rs = Integer.valueOf(sb.toString());
        return rs;*/

        //按位反转
        int rs = 0;
        for (int i = 0; i < 32; i++) {
            rs = (rs << 1) + (n & 1);
            n >>= 1;
        }
        return rs;

    }
    //按位翻转：思想是收尾互换
    //操作与1左移i次&结果判断是否为0.为0，异或(^)或者或(|)或者加(+)1左移31-i次
    public int reverseBitsChange(int n) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            // res += (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
            // res |= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
            res ^= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
        }
        return res;
    }

    //分治:思想是移动16位，后16位，移动8位，移动4位，移动2位
    //|或操作进行拼接
    //           11111111 00000000 11111111 00000000(0xff00ff00)和00000000 11111111 00000000 11111111(0x00ff00ff)
    //找到特殊数字1111 0000 1111 0000 1111 0000 1111 0000(0xf0f0f0f0) 和 0000 1111 0000 1111 0000 1111 0000 1111(0x0f0f0f0f)
    //           11 00 11 00 11 00 11 00 11 00 11 00 11 00 11 00(0xcccccccc)和00 11 00 11 00 11 00 11 00 11 00 11 00 11 00 11(0x33333333)
    //           1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0(0xaaaaaaaa)和 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1(0x55555555)
    //
    public int reverseBitsDivdide(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

}
