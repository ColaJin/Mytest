package leetcode.array.easy;

/**
 * @author:jinyandong
 * @description:2446. 判断两个事件是否存在冲突
 * @Date:2024/1/19
 */
public class HaveConflict {
    public static void main(String[] args) {
        String[] event1 = new String[]{"14:13","22:08"};
        String[] event2 = new String[]{"02:40","08:08"};
        System.out.println(haveConflict(event1, event2));
    }
    public static boolean haveConflict(String[] event1, String[] event2) {
        String start1 = event1[0];
        start1 = start1.replace(":", "");
        String start2 = event2[0];
        start2 = start2.replace(":", "");

        String end = "";
        String start = "";
        if (Integer.parseInt(start1.substring(0)) - Integer.parseInt(start2.substring(0)) > 0){
            end = event2[1];
            start = event1[0];
        }else {
            end = event1[1];
            start = event2[0];
        }


        end = end.replace(":", "");
        start = start.replace(":", "");
        int rs = Integer.parseInt(end.substring(0)) - Integer.parseInt(start.substring(0));
        if (rs < 0){
            return false;
        }
        return true;
    }
}
