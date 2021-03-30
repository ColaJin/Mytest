package leetcode.array.easy;

public class FlipAndInvertImage {
    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 0, 0}, {1, 0, 1}, {0, 1, 1}, {1, 1, 0}};
        int[][] rs = flipAndInvertImageBetter(image);
        for (int i = 0; i < rs.length; i++) {
            for (int j = 0; j < rs[i].length; j++) {

                System.out.print(rs[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int row = image.length;
        int col = image[0].length;
        //遍历数组然后转换行元素之后与1异或
        for (int i = 0; i < row; i++) {
            int j = 0;
            int k = col - 1;
            //等于的时候做一次异或
            while (k >= j) {
                int tempj = image[i][j];
                int tempk = image[i][k];
                image[i][k] = tempj ^ 1;
                image[i][j] = tempk ^ 1;
                k--;
                j++;

            }
        }
        return image;
    }


    //不需要翻转，相同数据的时候直接异或就可以，但是存在中间相等的数据异或两次的情况需要再次异或
    public static int[][] flipAndInvertImageBetter(int[][] image) {
        int row = image.length;
        int col = image[0].length;
        //遍历数组然后转换行元素之后与1异或
        for (int i = 0; i < row; i++) {
            int j = 0;
            int k = col - 1;

            while (k >= j) {
                //等于的时候做一次异或
                if (image[i][j] == image[i][k]) {
                    //二者相同的时候同时做异或就Ok
                    image[i][k] = image[i][k] ^ 1;
                    image[i][j] = image[i][j] ^ 1;
                }
                if (k == j){
                    //经历两次异或时需要再进行一次异或
                    image[i][j] = image[i][j] ^ 1;
                }
                k--;
                j++;

            }
        }
        return image;
    }
}
