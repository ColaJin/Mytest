package leetcode.Array.easy;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] A = new int[]{3, 1};
        for (int i = 0; i < sortArrayByParityBetter(A).length; i++) {
            System.out.print(sortArrayByParityBetter(A)[i] + "\t");
        }
    }

    public static int[] sortArrayByParity(int[] A) {
        //j指针从后向前移动
        //从头遍历数组，判断当前位置是否是奇数，是的话判读j的位置是否是奇数，是的话向前移动j
        //否则交换当前元素
        int j = A.length - 1;
        //需要限定否则数组下标越界
        /*while (A[j] % 2 != 0) {
            j--;
        }*/
        for (int i = 0; i < A.length - 1; i++) {
            if (i >= j) {
                break;
            }
            while (i < j && A[j] % 2 != 0) {
                j--;
            }
            if (A[i] % 2 != 0) {
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                //此时我已经不知道这个位置是不是奇数位置
                j--;
            }

        }
        return A;
    }

    public static int[] sortArrayByParityBetter(int[] A) {
        //j指针从后向前移动
        //从头遍历数组，判断当前位置是否是奇数，是的话判读j的位置是否是奇数，是的话向前移动j
        //否则交换当前元素
        int j = A.length - 1;
        for (int i = 0; i < A.length - 1; ) {
            if (A[i] % 2 != 0) {
                //奇数的情况
                /*while (i <= j && A[j] % 2 == 0) {
                    //j的位置为偶数需要交换
                    int temp = A[j];
                    A[j] = A[i];
                    A[i] = temp;
                    //交换之后移动j然后跳出循环
                    break;
                }*/

                //

                    //j的位置为偶数需要交换,i<j放到while里面否则数组越界
                    while (i < j && A[j] % 2 != 0) {
                        j--;
                    }
                    int temp = A[j];
                    A[j] = A[i];
                    A[i] = temp;

            }
            //奇偶都要++i
            i++;


        }
        return A;
    }
}
