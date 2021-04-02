package leetcode.stack.easy;

public class MinOperations {
    public static void main(String[] args) {
        String[] logs = new String[]{"../","../","../"};
        System.out.println(minOperationsBetter(logs));
    }

    public static int minOperations(String[] logs) {
        //遍历数组，遇到x/那么count++；
        //遇到../count--(count>0时)
        int count = 0;//或者使用栈计数
        for (String s : logs) {
            if (s.equals("../") && count > 0) {
                count--;
            } else if (s.equals("../") && count == 0) {
                //在主目录中../时,不能跳出，否则后面如果有文件的话就少计算层级
                continue;
            } else if (s.equals("./")) {
                //不操作但是需要加入否则count++
                continue;
            } else {
                count++;
            }
        }
        return count;
    }

    public static int minOperationsBetter(String[] logs) {

        int count = 0;
        for (String s : logs) {
            //注意顺序
            if (s.equals("./")) {
                continue;
            }
            if (!s.equals("../")) {
                //此时不包括./的情况，只有../和x/
                count++;
            } else {

                if (count > 0) {
                    //存在上一级的时候count--
                    count--;
                }
            }
        }
        return count;
    }

}
