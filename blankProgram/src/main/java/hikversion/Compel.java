package hikversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:jinyandong
 * @description:竞赛测试
 * @Date:2023/5/6
 */
public class Compel {
    public static void main(String[] args) {
        int index = Integer.valueOf("50");
        /*boolean[]A = new boolean[index+1];
        for (int a = 2; a < A.length; a++ ) {
            A[a]=true;
        }

        double sqrt_index=Math.sqrt(index);
        for(int i=2; i < sqrt_index; i++) {
            if (A[i] == true) {
                for (int k = 0; k <= index; k++) {
                    int j = i*i + k*i;
                    if(j <= index){
                        A[j] = false;
                    }
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int x = 2; x <= index; x++) {
            if (A[x] == true) {
                stringBuffer.append(x + " ");
            }
        }
        System.out.println(stringBuffer.toString());*/

        /*StringBuffer stringBuffer = new StringBuffer();
        for (int i = 2; i <= index; i++) {
            //定义一个flag
            boolean flag = true;
            for (int j = 2; j < i - 1; j++) {
                *//**
                 *抛开1和它本身，除以2到它-1之间的所有数，如果有余数为0，
                 *则直接跳出本次循环
                 *//*
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stringBuffer.append(i + " ");
            }
        }
        System.out.println(stringBuffer.toString());*/



    }
}
