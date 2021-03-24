package leetcode.Array.easy;

public class SortArrayByParityII {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 6, 9, 0, 3, 4, 5, 9, 0};
        int[] rs = sortArrayByParityIIBetter(nums);
        for (int i = 0; i < rs.length; i++) {
            System.out.print(rs[i] + "\t");
        }
    }

    public static int[] sortArrayByParityII(int[] nums) {
        //两个指针，从头和丛尾遍历数组，指针停止的时候是a[i]和a[j]奇偶位不对应的时候，交换

        for (int i = 0; i < nums.length - 1; i++) {
            //每次从尾巴遍历一次j
            int j = nums.length - 1;
            //判断i的奇偶性
            if (i % 2 == 0) {
                //i偶数，只有A[i]是奇数的时候才交换
                //判断A[i] 奇偶性
                if (nums[i] % 2 == 0) {
                    //A[i]偶数,继续下一个位置
                    continue;
                } else {
                    //A[i]奇数，找j是奇数位置，且A[j]是偶数
                    while (i < j && j % 2 == 0 || nums[j] % 2 != 0) {
                        //偶数位置和A[j]是奇数的时候j都要--
                        j--;
                    }
                        /*//A[i]奇数，找j是奇数位置，且A[j]是偶数
                        if (j % 2 != 0) {
                            //j是奇数位置,A[j]是偶数的时候交换
                            if (nums[j] % 2 == 0) {*/
                    //A[j]是偶数,交换
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                            /*}
                        }*/
                }
            } else {
                //i奇数，只有A[i]是偶数的时候交换
                if (nums[i] % 2 != 0) {
                    //A[i]奇数,继续下一个位置
                    continue;
                } else {
                    //A[i]偶数，找j是偶数位置而且A[j]是奇数的交换
                    while (i < j && j % 2 != 0 || nums[j] % 2 == 0) {
                        //奇数位置和A[j]是偶数的时候j都要--
                        j--;
                    }
                        /*if (j % 2 == 0) {
                            //j是偶数位，A[j]是奇数的时候交换
                            if (nums[j] % 2 != 0) {*/
                    //A[j]是奇数,交换
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                            /*}
                        }*/
                }
            }

        }

        return nums;

    }

    //两次遍历，第一次遍历把偶数位存到A[0]、A[2]...位置，第二次遍历把奇数存入A[1]、A[3]位置
    public static int[] sortArrayByParityIIByTwoTraverse(int[] nums) {
        int[] rs = new int[nums.length];
        int i = 0;
        //可以使用增强for循环
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 0) {
                rs[i] = nums[j];
                i = i + 2;
            }
        }
        i = 1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 != 0) {
                rs[i] = nums[j];
                i = i + 2;
            }
        }

        return rs;

    }


    //两个指针优化，i表示的是偶数位，j表示的是奇数位，
    //遍历时偶数位的奇数值，需要去找奇数位的偶数值去交换位置

    public static int[] sortArrayByParityIIBetter(int[] nums) {

        for (int i = 0; i < nums.length; ) {
            //不用每次都从1开始
            int j = 1;
            if (nums[i] % 2 != 0) {
                while (nums[j] % 2 != 0) {
                    j = j + 2;
                }
                //交换
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            i = i + 2;
        }
        return nums;
    }
}
