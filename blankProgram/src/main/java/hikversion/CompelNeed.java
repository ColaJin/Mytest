package hikversion;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class CompelNeed {
    public static void main(String[] args) {
        int task = Integer.valueOf("7");
        int peo = Integer.valueOf("1");

        /*int rs = 0;
        // 8的倍数
        int i = task / 8;

        // 取余
        int mod = task % 8;
        if (i < 1) {
            rs = -1;
        } else if (i == 1) {
            if (peo > 1){
                rs = -1;
            }else {
                rs = 1;
            }
        } else {
            if (mod == 4) {
                // 取模是4的时候，如果剩余的人不止一人那么就可以后面的人分
                if (peo - i > 1) {
                    rs = i;
                } else {
                    rs = peo - 1;
                }

            } else {
                if (i > peo) {
                    rs = peo - 1;
                } else {
                    rs = i;
                }
            }
        }*/
        int rs = 0;
        if (task <= peo) {
            rs = -1;
        } else if (task <= 8) {
            rs = 0;
        } else {
            // 每人至少一个任务
            task = task - peo;
            int i = task / 7;
            if (i <= 0 || i > peo) {
                rs = -1;
            } else {
                int mod = task % 7;
                // 剩的这个数量+3不为4就行
                // 取模为0时人数相等不可以20 2
                if (((peo - i) == 1 && mod == 3) || (peo == i && mod != 0)) {
                    rs = i - 1;
                } else {
                    rs = i;
                }
            }
        }
        System.out.println(rs);
    }
}
