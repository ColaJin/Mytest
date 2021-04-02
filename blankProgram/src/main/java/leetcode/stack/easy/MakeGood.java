package leetcode.stack.easy;

public class MakeGood {
    public static void main(String[] args) {
        String s = "lC";
        System.out.println(makeGoodBetter(s));
    }

    public static String makeGood(String s) {
        //原理同之前删除字符是一样的
        StringBuffer sb = new StringBuffer();
        //sb.append(s.charAt(0));
        //可优化，创建标志位top=-1，append时++，delete(top>=0)时--,top为sb的索引
        //判断当前元素是否是小写字母Character.isLowerCase
        int top = -1;
        //top-1开始，遍历从0开始
        for (int i = 0; i < s.length(); i++) {
            //判断条件可以简约为如果两个位置的小写字母比较相同，而且两个位置比较不同时(取消比较大小写的问题)
            if (Character.isLowerCase(s.charAt(i))) {
                //当前字符是小写字母时，i+1位置不能是大写
                if (top >= 0 && Character.isUpperCase(sb.charAt(top))) {
                    if (Character.toLowerCase(sb.charAt(top)) == s.charAt(i)) {
                        sb.deleteCharAt(top);
                        top--;
                    } else {
                        //此时也要append
                        sb.append(s.charAt(i));
                        top++;
                    }
                } else {
                    sb.append(s.charAt(i));
                    top++;
                }

            } else {
                //i+1位置不能为小写
                if (top >= 0 && Character.isLowerCase(sb.charAt(top))) {
                    if (Character.toLowerCase(s.charAt(i)) == sb.charAt(top)) {
                        sb.deleteCharAt(top);
                        top--;
                    } else {
                        sb.append(s.charAt(i));
                        top++;
                    }
                } else {
                    sb.append(s.charAt(i));
                    top++;
                }
            }
        }

        return sb.toString();
    }

    public static String makeGoodBetter(String s) {
        StringBuffer sb = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            //判断条件可以简约为如果两个位置的小写字母都比较相同，而且两个位置比较不同时(取消比较大小写的问题)
            if (top >= 0 && Character.toLowerCase(sb.charAt(top)) == Character.toLowerCase(s.charAt(i)) && sb.charAt(top) != s.charAt(i)) {
                sb.deleteCharAt(top);
                top--;
            } else {
                sb.append(s.charAt(i));
                top++;
            }
        }

        return sb.toString();
    }
}
