package leetcode.array.easy;

public class SumEvenAfterQueries {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        int[][] queries = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}, {-10, 3}, {1, 4}};
        int[] rs = sumEvenAfterQueriesBetter(A, queries);
        for (int i : rs) {
            System.out.print(i + "\t");
        }
    }

    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] rs = new int[queries.length];
        //计算原数组的偶数和
        int old = 0;
        for (int i : A) {
            if (i % 2 == 0) {
                old += i;
            }
        }

        //遍历queries计算结果
        for (int i = 0; i < queries.length; i++) {
            //判断原来A位置是奇数还是偶数
            if (A[queries[i][1]] % 2 == 0) {
                int temp = A[queries[i][1]];
                //计算A的新值
                A[queries[i][1]] += queries[i][0];
                //判断新值是否是偶数
                if (A[queries[i][1]] % 2 == 0) {
                    rs[i] = old + queries[i][0];
                } else {
                    rs[i] = old - temp;
                }
            } else {
                A[queries[i][1]] += queries[i][0];
                //判断新值是否是偶数
                if (A[queries[i][1]] % 2 == 0) {
                    rs[i] = old + A[queries[i][1]];
                } else {
                    //不变化
                    rs[i] = old;
                }
            }
            //更新old的值
            old = rs[i];
        }

        //上述操作可以优化
        //先判断是否是偶数，是的话先减掉此值，在计算+queries[i][0]之后的值，判断是否是偶数，是则加，存入rs
        //不是偶数的时候不更新old，直接计算+queries[i][0]的值

        return rs;
    }

    public static int[] sumEvenAfterQueriesBetter(int[] A, int[][] queries) {
        int[] rs = new int[queries.length];
        //计算原数组的偶数和
        int old = 0;
        for (int i : A) {
            if (i % 2 == 0) {
                old += i;
            }
        }

        //遍历queries计算结果
        for (int i = 0; i < queries.length; i++) {
            //判断原来A位置是奇数还是偶数
            if (A[queries[i][1]] % 2 == 0) {
                old -= A[queries[i][1]];
            }
            //计算A的新值
            A[queries[i][1]] += queries[i][0];
            if (A[queries[i][1]] % 2 == 0) {
                old += A[queries[i][1]];
            }
            rs[i] = old;
        }
        //先判断是否是偶数，是的话先减掉此值，在计算+queries[i][0]之后的值，判断是否是偶数，是则加，存入rs
        //不是偶数的时候不更新old，直接计算+queries[i][0]的值
        return rs;
    }
}
